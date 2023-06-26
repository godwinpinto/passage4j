package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing the type of a user metadata field.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum UserMetadataFieldTypeEnum {
  // Represents a string value
  @JsonProperty("string")
  STRING("string"),
  // Represents a boolean value
  @JsonProperty("boolean")
  BOOLEAN("boolean"),
  // Represents an integer value
  @JsonProperty("integer")
  NUMBER("integer"),
  // Represents a date value
  @JsonProperty("date")
  DATE("date"),
  // Represents a phone number value
  @JsonProperty("phone")
  PHONE("phone"),
  // Represents an email address value
  @JsonProperty("email")
  EMAIL("email");

  private final String value;

  /**
   * Constructs a new UserMetadataFieldTypeEnum with the specified value.
   *
   * @param value The value of the enum constant.
   */
  UserMetadataFieldTypeEnum(String value) {
    this.value = value;
  }

  /**
   * Get the value of the enum constant.
   *
   * @return The value of the enum constant.
   */
  public String getValue() {
    return value;
  }
}
