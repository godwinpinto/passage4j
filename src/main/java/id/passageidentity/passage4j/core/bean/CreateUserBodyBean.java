package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Map;

/**
 * Bean class representing the body of a create user request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserBodyBean {

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("user_metadata")
  private Map<String, Object> userMetadata;

  /**
   * Create a new instance of the CreateUserBodyBean class.
   */
  public CreateUserBodyBean() {
  }

  /**
   * Get the email associated with the create user request.
   *
   * @return The email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email for the create user request.
   *
   * @param email The email to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the phone number associated with the create user request.
   *
   * @return The phone number.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set the phone number for the create user request.
   *
   * @param phone The phone number to set.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Get the user metadata associated with the create user request.
   *
   * @return The user metadata.
   */
  public Map<String, Object> getUserMetadata() {
    return userMetadata;
  }

  /**
   * Set the user metadata for the create user request.
   *
   * @param userMetadata The user metadata to set.
   */
  public void setUserMetadata(Map<String, Object> userMetadata) {
    this.userMetadata = userMetadata;
  }
}
