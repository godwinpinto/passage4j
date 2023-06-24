package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceListBean {
@JsonProperty("devices")
  private List<DeviceBean> devices;

  public List<DeviceBean> getDevices() {
    return devices;
  }

  public void setDevices(List<DeviceBean> devices) {
    this.devices = devices;
  }

  @Override
  public String toString() {
    return "DeviceListBean{" +
        "devices=" + devices +
        '}';
  }
}
