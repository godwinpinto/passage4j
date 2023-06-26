package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bean class representing a user metadata field.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMetadataFieldBean {

  @JsonProperty("id")
  private String id;

  @JsonProperty("field_name")
  private String fieldName;

  @JsonProperty("type")
  private UserMetadataFieldTypeEnum type;

  @JsonProperty("friendly_name")
  private String friendlyName;

  @JsonProperty("registration")
  private boolean registration;

  @JsonProperty("profile")
  private boolean profile;

  /**
   * Get the ID of the user metadata field.
   *
   * @return The ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the ID of the user metadata field.
   *
   * @param id The ID to set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the field name of the user metadata field.
   *
   * @return The field name.
   */
  public String getFieldName() {
    return fieldName;
  }

  /**
   * Set the field name of the user metadata field.
   *
   * @param fieldName The field name to set.
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /**
   * Get the type of the user metadata field.
   *
   * @return The type.
   */
  public UserMetadataFieldTypeEnum getType() {
    return type;
  }

  /**
   * Set the type of the user metadata field.
   *
   * @param type The type to set.
   */
  public void setType(UserMetadataFieldTypeEnum type) {
    this.type = type;
  }

  /**
   * Get the friendly name of the user metadata field.
   *
   * @return The friendly name.
   */
  public String getFriendlyName() {
    return friendlyName;
  }

  /**
   * Set the friendly name of the user metadata field.
   *
   * @param friendlyName The friendly name to set.
   */
  public void setFriendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
  }

  /**
   * Check if the user metadata field is used for registration.
   *
   * @return True if the field is used for registration, false otherwise.
   */
  public boolean isRegistration() {
    return registration;
  }

  /**
   * Set whether the user metadata field is used for registration.
   *
   * @param registration The registration flag to set.
   */
  public void setRegistration(boolean registration) {
    this.registration = registration;
  }

  /**
   * Check if the user metadata field is used for the user profile.
   *
   * @return True if the field is used for the user profile, false otherwise.
   */
  public boolean isProfile() {
    return profile;
  }

  /**
   * Set whether the user metadata field is used for the user profile.
   *
   * @param profile The profile flag to set.
   */
  public void setProfile(boolean profile) {
    this.profile = profile;
  }

  /**
   * Get a string representation of the UserMetadataFieldBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "UserMetadataFieldBean{" +
        "id='" + id + '\'' +
        ", fieldName='" + fieldName + '\'' +
        ", type=" + type +
        ", friendlyName='" + friendlyName + '\'' +
        ", registration=" + registration +
        ", profile=" + profile +
        '}';
  }
}

