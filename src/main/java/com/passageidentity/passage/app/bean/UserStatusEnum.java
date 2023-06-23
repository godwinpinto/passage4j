package com.passageidentity.passage.app.bean;

public enum UserStatusEnum {
  ACTIVE("active"),
  INACTIVE("inactive"),
  PENDING("pending");

  private final String value;

  UserStatusEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
