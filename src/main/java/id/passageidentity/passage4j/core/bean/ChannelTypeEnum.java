package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing different channel types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ChannelTypeEnum {
  /**
   * Email channel type.
   */
  @JsonProperty("email")
  EMAIL("email"),

  /**
   * Phone channel type.
   */
  @JsonProperty("phone")
  PHONE("phone");

  private final String value;

  /**
   * Constructor for ChannelTypeEnum.
   *
   * @param value The value associated with the channel type.
   */
  ChannelTypeEnum(String value) {
    this.value = value;
  }

  /**
   * Get the value associated with the channel type.
   *
   * @return The channel type value.
   */
  public String getValue() {
    return value;
  }
}
