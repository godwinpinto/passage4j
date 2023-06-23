package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserMetadataFieldTypeEnum {
  @JsonProperty("string")
  STRING,
  @JsonProperty("boolean")
  BOOLEAN,
  @JsonProperty("integer")
  NUMBER,
  @JsonProperty("date")
  DATE,
  @JsonProperty("phone")
  PHONE,
  @JsonProperty("email")
  EMAIL
}
