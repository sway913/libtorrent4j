/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class connection_type_t {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected connection_type_t(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(connection_type_t obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_connection_type_t(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static connection_type_t all() {
    return new connection_type_t(libtorrent_jni.connection_type_t_all(), true);
  }

  public boolean op_bool() {
    return libtorrent_jni.connection_type_t_op_bool(swigCPtr, this);
  }

  public boolean op_eq(connection_type_t f) {
    return libtorrent_jni.connection_type_t_op_eq(swigCPtr, this, connection_type_t.getCPtr(f), f);
  }

  public boolean op_ne(connection_type_t f) {
    return libtorrent_jni.connection_type_t_op_ne(swigCPtr, this, connection_type_t.getCPtr(f), f);
  }

  public connection_type_t op_or(connection_type_t other) {
    return new connection_type_t(libtorrent_jni.connection_type_t_op_or(swigCPtr, this, connection_type_t.getCPtr(other), other), true);
  }

  public connection_type_t op_and(connection_type_t other) {
    return new connection_type_t(libtorrent_jni.connection_type_t_op_and(swigCPtr, this, connection_type_t.getCPtr(other), other), true);
  }

  public connection_type_t xor(connection_type_t other) {
    return new connection_type_t(libtorrent_jni.connection_type_t_xor(swigCPtr, this, connection_type_t.getCPtr(other), other), true);
  }

  public connection_type_t inv() {
    return new connection_type_t(libtorrent_jni.connection_type_t_inv(swigCPtr, this), true);
  }

  public int to_int() {
    return libtorrent_jni.connection_type_t_to_int(swigCPtr, this);
  }

  public connection_type_t() {
    this(libtorrent_jni.new_connection_type_t(), true);
  }

}
