package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChannelTypeEnum {
  @JsonProperty("email")
  EMAIL,
  @JsonProperty("phone")
  PHONE
}
