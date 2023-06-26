package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing the status of a user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum UserStatusEnum {
  ACTIVE("active"),     // The user is active
  INACTIVE("inactive"), // The user is inactive
  PENDING("pending");   // The user is pending

  private final String value;

  /**
   * Constructs a new UserStatusEnum with the specified value.
   *
   * @param value The value of the enum constant.
   */
  UserStatusEnum(String value) {
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
