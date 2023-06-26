package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import java.util.Map;

/**
 * Bean class representing a user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("user")
public class UserBean {


  /**
   * the error message when a passage User with a specific ID does not exist.
   */
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

  /**
   * Create a new instance of the UserBean.
   */
  public UserBean() {
  }

  /**
   * Get the ID.
   *
   * @return The ID.
   */
  public String getID() {
    return ID;
  }

  /**
   * Set the ID.
   *
   * @param ID The ID to set.
   */
  public void setID(String ID) {
    this.ID = ID;
  }

  /**
   * Get the status.
   *
   * @return The status.
   */
  public UserStatusEnum getStatus() {
    return status;
  }

  /**
   * Set the status.
   *
   * @param status The status to set.
   */
  public void setStatus(UserStatusEnum status) {
    this.status = status;
  }

  /**
   * Get the email.
   *
   * @return The email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email.
   *
   * @param email The email to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the phone.
   *
   * @return The phone.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set the phone.
   *
   * @param phone The phone to set.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Check if the email is verified.
   *
   * @return True if the email is verified, false otherwise.
   */
  public boolean isEmailVerified() {
    return emailVerified;
  }

  /**
   * Set the email verification status.
   *
   * @param emailVerified The email verification status to set.
   */
  public void setEmailVerified(boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  /**
   * Check if the phone is verified.
   *
   * @return True if the phone is verified, false otherwise.
   */
  public boolean isPhoneVerified() {
    return phoneVerified;
  }

  /**
   * Set the phone verification status.
   *
   * @param phoneVerified The phone verification status to set.
   */
  public void setPhoneVerified(boolean phoneVerified) {
    this.phoneVerified = phoneVerified;
  }

  /**
   * Get the creation date.
   *
   * @return The creation date.
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Set the creation date.
   *
   * @param createdAt The creation date to set.
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Get the last login date.
   *
   * @return The last login date.
   */
  public Date getLastLogin() {
    return lastLogin;
  }

  /**
   * Set the last login date.
   *
   * @param lastLogin The last login date to set.
   */
  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  /**
   * Get the user metadata.
   *
   * @return The user metadata.
   */
  public Map<String, Object> getUserMetadata() {
    return userMetadata;
  }

  /**
   * Set the user metadata.
   *
   * @param userMetadata The user metadata to set.
   */
  public void setUserMetadata(Map<String, Object> userMetadata) {
    this.userMetadata = userMetadata;
  }

  /**
   * Get a string representation of the UserBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "UserBean{" +
        "ID='" + ID + '\'' +
        ", status=" + status +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", emailVerified=" + emailVerified +
        ", phoneVerified=" + phoneVerified +
        ", createdAt=" + createdAt +
        ", lastLogin=" + lastLogin +
        ", userMetadata=" + userMetadata +
        '}';
  }
}

