package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Bean class representing a device.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceBean {

  @JsonProperty("id")
  private String ID;

  @JsonProperty("cred_id")
  private String credID;

  @JsonProperty("friendly_name")
  private String name;

  @JsonProperty("usage_count")
  private int usageCount;

  @JsonProperty("updated_at")
  private Date updatedAt;

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("last_login_at")
  private Date lastLoginAt;

  /**
   * Create a new instance of the DeviceBean class.
   */
  public DeviceBean() {
  }

  /**
   * Get the ID of the device.
   *
   * @return The device ID.
   */
  public String getID() {
    return ID;
  }

  /**
   * Set the ID of the device.
   *
   * @param ID The device ID to set.
   */
  public void setID(String ID) {
    this.ID = ID;
  }

  /**
   * Get the credential ID associated with the device.
   *
   * @return The credential ID.
   */
  public String getCredID() {
    return credID;
  }

  /**
   * Set the credential ID for the device.
   *
   * @param credID The credential ID to set.
   */
  public void setCredID(String credID) {
    this.credID = credID;
  }

  /**
   * Get the friendly name of the device.
   *
   * @return The friendly name.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the friendly name for the device.
   *
   * @param name The friendly name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the usage count of the device.
   *
   * @return The usage count.
   */
  public int getUsageCount() {
    return usageCount;
  }

  /**
   * Set the usage count for the device.
   *
   * @param usageCount The usage count to set.
   */
  public void setUsageCount(int usageCount) {
    this.usageCount = usageCount;
  }

  /**
   * Get the date when the device was last updated.
   *
   * @return The update date.
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Set the date when the device was last updated.
   *
   * @param updatedAt The update date to set.
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * Get the date when the device was created.
   *
   * @return The creation date.
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Set the date when the device was created.
   *
   * @param createdAt The creation date to set.
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Get the date when the device was last logged in.
   *
   * @return The last login date.
   */
  public Date getLastLoginAt() {
    return lastLoginAt;
  }

  /**
   * Set the date when the device was last logged in.
   *
   * @param lastLoginAt The last login date to set.
   */
  public void setLastLoginAt(Date lastLoginAt) {
    this.lastLoginAt = lastLoginAt;
  }

  /**
   * Get a string representation of the DeviceBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "DeviceBean{" +
        "ID='" + ID + '\'' +
        ", credID='" + credID + '\'' +
        ", name='" + name + '\'' +
        ", usageCount=" + usageCount +
        ", updatedAt=" + updatedAt +
        ", createdAt=" + createdAt +
        ", lastLoginAt=" + lastLoginAt +
        '}';
  }
}

