package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Bean class representing a list of devices.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceListBean {

  @JsonProperty("devices")
  private List<DeviceBean> devices;

  /**
   * Get the list of devices.
   *
   * @return The list of devices.
   */
  public List<DeviceBean> getDevices() {
    return devices;
  }

  /**
   * Set the list of devices.
   *
   * @param devices The list of devices to set.
   */
  public void setDevices(List<DeviceBean> devices) {
    this.devices = devices;
  }

  /**
   * Get a string representation of the DeviceListBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "DeviceListBean{" +
        "devices=" + devices +
        '}';
  }
}
