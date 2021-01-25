#! /usr/bin/env bash
#
# Copyright (C) 2013-2021 360.cn
# build libtorrent4j
#

#-----------prepare--------
#need cmake,gcc,git


export BT_ARCH="$1"
if [ "${BT_ARCH}" == "" ];then
  echo "input BT_ARCH";
  exit;
fi

echo "---------------------build libtorrent4j for---------------------"
echo ${BT_ARCH}
echo "----------------------------------------------------------------"
export SH_PATH=${PWD}

#0.env
setup_env()
{
  
  echo "---------------------setup env---------------------"
  export BOOST_DOT_VERSION="1.75.0"
  export BOOST_VERSION="1_75_0"
  export NDK_VERSION="r21d"
  export OPENSSL_VERSION="1.1.1i"
  export OPENSSL_NO_OPTS="no-deprecated no-shared no-makedepend -fno-strict-aliasing -fvisibility=hidden -O3"


  export LIBBT4J_DIR=${SH_PATH}/libtorrent4j
  echo $TRAVIS_BUILD_DIR
  if [ ! -d "$LIBBT4J_DIR" ];then
    git clone https://github.com/aldenml/libtorrent4j.git libtorrent4j;
    cd $LIBBT4J_DIR
    git submodule update --depth=1 --init --recursive
  fi
  export ROOT_PATH=$LIBBT4J_DIR
}


#1.setup boost
setup_boost()
{
  echo "---------------------setup boost---------------------"
  cd $ROOT_PATH

  if [ ! -d "${ROOT_PATH}/boost" ];then
    echo "get boost......"
    if [ ! -f "${SH_PATH}/boost.tar.gz" ];then
      echo "download boost......"
      wget -c -O "${SH_PATH}/boost.tar.gz" https://dl.bintray.com/boostorg/release/${BOOST_DOT_VERSION}/source/boost_${BOOST_VERSION}.tar.gz
      echo "download boost finish."
    fi
    echo "unzip boost......"
    tar xzf "${SH_PATH}/boost.tar.gz" 
    mv boost_${BOOST_VERSION} boost
  fi

  cd boost
  echo "---gcc version:"
  gcc --version
  echo "---" 
  ./bootstrap.sh
  cd ..
}


#2.setup ndk
setup_ndk()
{
  echo "---------------------setup ndk---------------------"
  cd $ROOT_PATH

  if [ ! -d "$ROOT_PATH/android-ndk-${NDK_VERSION}" ];then
    echo "get android ndk......"
    if [ ! -f "${SH_PATH}/android-ndk.zip" ];then
      echo "download android ndk......"
      wget -c -O "${SH_PATH}/android-ndk.zip" https://dl.google.com/android/repository/android-ndk-${NDK_VERSION}-linux-x86_64.zip
      echo "download android ndk finish."
    fi
    echo "unzip android ndk......"
    unzip -qq "${SH_PATH}/android-ndk.zip"
  fi

  export NDK=${ROOT_PATH}/android-ndk-${NDK_VERSION}
  ${NDK}/build/tools/make_standalone_toolchain.py --arch arm --api 21 --stl libc++ --install-dir android-toolchain
  export ANDROID_TOOLCHAIN=${ROOT_PATH}/android-toolchain
  export BOOST_ROOT=${ROOT_PATH}/boost

  sed -i 's/24/21/g' ${ANDROID_TOOLCHAIN}/sysroot/usr/include/ifaddrs.h
  sed -i 's/24/21/g' ${ANDROID_TOOLCHAIN}/sysroot/usr/include/stdio.h
  sed -i 's/28/21/g' ${ANDROID_TOOLCHAIN}/sysroot/usr/include/sys/random.h
  sed -i 's/RANLIB = ranlib/RANLIB = "${ANDROID_TOOLCHAIN}\/bin\/arm-linux-androideabi-ranlib"/g' ${BOOST_ROOT}/tools/build/src/tools/gcc.jam
}

#3.setup openssl
setup_openssl()
{
  echo "---------------------setup openssl---------------------"
  cd $ROOT_PATH

  export ANDROID_TOOLCHAIN=${ROOT_PATH}/android-toolchain
  export PATH=${ANDROID_TOOLCHAIN}/arm-linux-androideabi/bin:${PATH}
  export CC=${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-clang

  if [ -d "${ROOT_PATH}/openssl-${OPENSSL_VERSION}" ];then
    echo "clear openssl src......"
    rm -rf "${ROOT_PATH}/openssl-${OPENSSL_VERSION}";
  fi

  if [ ! -f "${SH_PATH}/openssl.tar.gz" ];then
    echo "download openssl......"
    wget -c -O "${SH_PATH}/openssl.tar.gz" https://www.openssl.org/source/openssl-${OPENSSL_VERSION}.tar.gz
    echo "download openssl finish."
  fi
  echo "unzip openssl......"
  tar xzf "${SH_PATH}/openssl.tar.gz"

  cd openssl-${OPENSSL_VERSION}
  echo "build openssl......"
  ./Configure linux-armv4 ${OPENSSL_NO_OPTS} -march=armv7-a -mfpu=neon -fPIC --prefix=${PWD}/../openssl
  make &> /dev/null
  make install_sw &> /dev/null
  cd ..
}

#4.build
build_all()
{
  echo "---------------------build---------------------"
  cd $ROOT_PATH

  export ANDROID_TOOLCHAIN=${ROOT_PATH}/android-toolchain
  export PATH=${ANDROID_TOOLCHAIN}/arm-linux-androideabi/bin:${PATH}
  export BOOST_ROOT=${ROOT_PATH}/boost
  export BOOST_BUILD_PATH=${ROOT_PATH}/boost/tools/build
  export OPENSSL_ROOT=${ROOT_PATH}/openssl
  export LIBTORRENT_ROOT=${ROOT_PATH}/swig/deps/libtorrent
  export CXX=${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-clang++
  export CC=${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-clang
  cd swig
  echo "build boost"
  ${BOOST_ROOT}/b2 -j2 --user-config=config/android-arm-config.jam variant=release toolset=clang-linux-arm target-os=android location=bin/release/android/armeabi-v7a
  cd ..
}


#5.strip
strip()
{
  echo "---------------------strip---------------------"
  cd $ROOT_PATH

  export ANDROID_TOOLCHAIN=${ROOT_PATH}/android-toolchain
  ${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-objcopy --only-keep-debug ${ROOT_PATH}/swig/bin/release/android/armeabi-v7a/libtorrent4j.so swig/bin/release/android/armeabi-v7a/libtorrent4j.so.debug
  ${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-strip --strip-unneeded -x -g ${ROOT_PATH}/swig/bin/release/android/armeabi-v7a/libtorrent4j.so
}

#6.dependencies
dependencies()
{
  echo "---------------------dependencies---------------------"
  cd $ROOT_PATH

  export ANDROID_TOOLCHAIN=${ROOT_PATH}/android-toolchain
  ${ANDROID_TOOLCHAIN}/bin/arm-linux-androideabi-readelf -d swig/bin/release/android/armeabi-v7a/libtorrent4j.so
}

#7.artifact
artifact()
{
  echo "---------------------artifact---------------------"
  cd $ROOT_PATH

  if [ -d "$ROOT_PATH/output" ];then
    rm -rf "$ROOT_PATH/output"
  fi
  mkdir "$ROOT_PATH/output"

  cp "$ROOT_PATH/swig/bin/release/android/armeabi-v7a/libtorrent4j.so" "$ROOT_PATH/output"
  cp "$ROOT_PATH/swig/bin/release/android/armeabi-v7a/libtorrent4j.so.debug" "$ROOT_PATH/output"
}


#0.env
setup_env
#1.setup boost
setup_boost
#2.setup ndk
setup_ndk
#3.setup openssl
setup_openssl
#4.build
build_all
#5.strip
strip
#6.dependencies
dependencies
#7.artifact
artifact