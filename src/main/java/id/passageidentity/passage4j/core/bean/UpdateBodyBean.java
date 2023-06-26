package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * Bean class representing an update body.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateBodyBean {

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("user_metadata")
  private Map<String, Object> userMetadata;

  /**
   * Create a new instance of the UpdateBodyBean.
   */
  public UpdateBodyBean() {
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
   * Get a string representation of the UpdateBodyBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "UpdateBodyBean{" +
        "email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", userMetadata=" + userMetadata +
        '}';
  }
}
