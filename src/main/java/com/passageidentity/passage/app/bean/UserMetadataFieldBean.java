package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMetadataFieldBean {
  public String id;
  @JsonProperty("field_name")
  public String fieldName;
  public UserMetadataFieldTypeEnum type;
  @JsonProperty("friendly_name")
  public String friendlyName;
  public boolean registration;
  public boolean profile;
}
