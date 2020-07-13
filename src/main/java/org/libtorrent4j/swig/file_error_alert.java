/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class file_error_alert extends torrent_alert {
  private transient long swigCPtr;

  protected file_error_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.file_error_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(file_error_alert obj) {
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
        libtorrent_jni.delete_file_error_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.file_error_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.file_error_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.file_error_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.file_error_alert_message(swigCPtr, this);
  }

  public error_code getError() {
    long cPtr = libtorrent_jni.file_error_alert_error_get(swigCPtr, this);
    return (cPtr == 0) ? null : new error_code(cPtr, false);
  }

  public void setOp(operation_t value) {
    libtorrent_jni.file_error_alert_op_set(swigCPtr, this, value.swigValue());
  }

  public operation_t getOp() {
    return operation_t.swigToEnum(libtorrent_jni.file_error_alert_op_get(swigCPtr, this));
  }

  public String filename() {
    return libtorrent_jni.file_error_alert_filename(swigCPtr, this);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.file_error_alert_priority_get());
  public final static int alert_type = libtorrent_jni.file_error_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.file_error_alert_static_category_get(), false);
}
