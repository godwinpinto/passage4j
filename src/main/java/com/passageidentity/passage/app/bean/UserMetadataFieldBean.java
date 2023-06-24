package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
