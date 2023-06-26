package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

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

  public DeviceBean() {
  }

  // Getters and setters for the fields

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getCredID() {
    return credID;
  }

  public void setCredID(String credID) {
    this.credID = credID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getUsageCount() {
    return usageCount;
  }

  public void setUsageCount(int usageCount) {
    this.usageCount = usageCount;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getLastLoginAt() {
    return lastLoginAt;
  }

  public void setLastLoginAt(Date lastLoginAt) {
    this.lastLoginAt = lastLoginAt;
  }

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
