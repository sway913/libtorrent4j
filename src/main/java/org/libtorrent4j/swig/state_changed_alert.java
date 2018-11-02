/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class state_changed_alert extends torrent_alert {
  private transient long swigCPtr;

  protected state_changed_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.state_changed_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(state_changed_alert obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libtorrent_jni.delete_state_changed_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.state_changed_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.state_changed_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.state_changed_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.state_changed_alert_message(swigCPtr, this);
  }

  public torrent_status.state_t getState() {
    return torrent_status.state_t.swigToEnum(libtorrent_jni.state_changed_alert_state_get(swigCPtr, this));
  }

  public torrent_status.state_t getPrev_state() {
    return torrent_status.state_t.swigToEnum(libtorrent_jni.state_changed_alert_prev_state_get(swigCPtr, this));
  }

  public final static int priority = libtorrent_jni.state_changed_alert_priority_get();
  public final static int alert_type = libtorrent_jni.state_changed_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.state_changed_alert_static_category_get(), false);
}