package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public enum UserStatusEnum {
  @JsonProperty("active")
  ACTIVE("active"),
  @JsonProperty("inactive")
  INACTIVE("inactive"),
  @JsonProperty("pending")
  PENDING("pending");

  private final String value;

  UserStatusEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
