/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.libtorrent4j.swig;

public class dht_announce_alert extends alert {
  private transient long swigCPtr;

  protected dht_announce_alert(long cPtr, boolean cMemoryOwn) {
    super(libtorrent_jni.dht_announce_alert_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(dht_announce_alert obj) {
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
        libtorrent_jni.delete_dht_announce_alert(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public int type() {
    return libtorrent_jni.dht_announce_alert_type(swigCPtr, this);
  }

  public alert_category_t category() {
    return new alert_category_t(libtorrent_jni.dht_announce_alert_category(swigCPtr, this), true);
  }

  public String what() {
    return libtorrent_jni.dht_announce_alert_what(swigCPtr, this);
  }

  public String message() {
    return libtorrent_jni.dht_announce_alert_message(swigCPtr, this);
  }

  public void setPort(int value) {
    libtorrent_jni.dht_announce_alert_port_set(swigCPtr, this, value);
  }

  public int getPort() {
    return libtorrent_jni.dht_announce_alert_port_get(swigCPtr, this);
  }

  public void setInfo_hash(sha1_hash value) {
    libtorrent_jni.dht_announce_alert_info_hash_set(swigCPtr, this, sha1_hash.getCPtr(value), value);
  }

  public sha1_hash getInfo_hash() {
    long cPtr = libtorrent_jni.dht_announce_alert_info_hash_get(swigCPtr, this);
    return (cPtr == 0) ? null : new sha1_hash(cPtr, false);
  }

  public address get_ip() {
    return new address(libtorrent_jni.dht_announce_alert_get_ip(swigCPtr, this), true);
  }

  public final static alert_priority priority = alert_priority.swigToEnum(libtorrent_jni.dht_announce_alert_priority_get());
  public final static int alert_type = libtorrent_jni.dht_announce_alert_alert_type_get();
  public final static alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_announce_alert_static_category_get(), false);
}
