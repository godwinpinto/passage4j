package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserBodyBean {

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("user_metadata")
  private Map<String, Object> userMetadata;

  public CreateUserBodyBean() {
  }

  // Getters and setters for the fields

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

  public Map<String, Object> getUserMetadata() {
    return userMetadata;
  }

  public void setUserMetadata(Map<String, Object> userMetadata) {
    this.userMetadata = userMetadata;
  }
}
