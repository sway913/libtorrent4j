/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class web_seed_entry_vector extends java.util.AbstractList<web_seed_entry> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected web_seed_entry_vector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(web_seed_entry_vector obj) {
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
        libtorrent_jni.delete_web_seed_entry_vector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public web_seed_entry_vector(web_seed_entry[] initialElements) {
    this();
    reserve(initialElements.length);

    for (web_seed_entry element : initialElements) {
      add(element);
    }
  }

  public web_seed_entry_vector(Iterable<web_seed_entry> initialElements) {
    this();
    for (web_seed_entry element : initialElements) {
      add(element);
    }
  }

  public web_seed_entry get(int index) {
    return doGet(index);
  }

  public web_seed_entry set(int index, web_seed_entry e) {
    return doSet(index, e);
  }

  public boolean add(web_seed_entry e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, web_seed_entry e) {
    modCount++;
    doAdd(index, e);
  }

  public web_seed_entry remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public web_seed_entry_vector() {
    this(libtorrent_jni.new_web_seed_entry_vector__SWIG_0(), true);
  }

  public web_seed_entry_vector(web_seed_entry_vector other) {
    this(libtorrent_jni.new_web_seed_entry_vector__SWIG_1(web_seed_entry_vector.getCPtr(other), other), true);
  }

  public long capacity() {
    return libtorrent_jni.web_seed_entry_vector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    libtorrent_jni.web_seed_entry_vector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return libtorrent_jni.web_seed_entry_vector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    libtorrent_jni.web_seed_entry_vector_clear(swigCPtr, this);
  }

  public web_seed_entry_vector(int count, web_seed_entry value) {
    this(libtorrent_jni.new_web_seed_entry_vector__SWIG_2(count, web_seed_entry.getCPtr(value), value), true);
  }

  private int doSize() {
    return libtorrent_jni.web_seed_entry_vector_doSize(swigCPtr, this);
  }

  private void doAdd(web_seed_entry x) {
    libtorrent_jni.web_seed_entry_vector_doAdd__SWIG_0(swigCPtr, this, web_seed_entry.getCPtr(x), x);
  }

  private void doAdd(int index, web_seed_entry x) {
    libtorrent_jni.web_seed_entry_vector_doAdd__SWIG_1(swigCPtr, this, index, web_seed_entry.getCPtr(x), x);
  }

  private web_seed_entry doRemove(int index) {
    return new web_seed_entry(libtorrent_jni.web_seed_entry_vector_doRemove(swigCPtr, this, index), true);
  }

  private web_seed_entry doGet(int index) {
    return new web_seed_entry(libtorrent_jni.web_seed_entry_vector_doGet(swigCPtr, this, index), false);
  }

  private web_seed_entry doSet(int index, web_seed_entry val) {
    return new web_seed_entry(libtorrent_jni.web_seed_entry_vector_doSet(swigCPtr, this, index, web_seed_entry.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    libtorrent_jni.web_seed_entry_vector_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
