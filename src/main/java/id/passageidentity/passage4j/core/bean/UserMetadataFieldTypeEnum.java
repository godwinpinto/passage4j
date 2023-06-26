package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public enum UserMetadataFieldTypeEnum {
  @JsonProperty("string")
  STRING("string"),
  @JsonProperty("boolean")
  BOOLEAN("boolean"),
  @JsonProperty("integer")
  NUMBER("integer"),
  @JsonProperty("date")
  DATE("date"),
  @JsonProperty("phone")
  PHONE("phone"),
  @JsonProperty("email")
  EMAIL("email");

  private final String value;

  UserMetadataFieldTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
