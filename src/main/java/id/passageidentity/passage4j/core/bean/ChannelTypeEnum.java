package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public enum ChannelTypeEnum {
  @JsonProperty("email")
  EMAIL("email"),
  @JsonProperty("phone")
  PHONE("phone");
  private final String value;

  ChannelTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
