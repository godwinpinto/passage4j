package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Map;

public class UserBean {
  public static final String UserIDDoesNotExist = "passage User with ID %s does not exist";

  @JsonProperty("id")
  private String ID;

  @JsonProperty("status")
  private UserStatusEnum status;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("email_verified")
  private boolean emailVerified;

  @JsonProperty("phone_verified")
  private boolean phoneVerified;

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("last_login_at")
  private Date lastLogin;

  @JsonProperty("user_metadata")
  private Map<String, Object> userMetadata;

  public UserBean() {
  }

  // Getters and setters for the fields

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public UserStatusEnum getStatus() {
    return status;
  }

  public void setStatus(UserStatusEnum status) {
    this.status = status;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean isEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public boolean isPhoneVerified() {
    return phoneVerified;
  }

  public void setPhoneVerified(boolean phoneVerified) {
    this.phoneVerified = phoneVerified;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  public Map<String, Object> getUserMetadata() {
    return userMetadata;
  }

  public void setUserMetadata(Map<String, Object> userMetadata) {
    this.userMetadata = userMetadata;
  }

}
