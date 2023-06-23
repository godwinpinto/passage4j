package com.passageidentity.passage.http.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HTTPError {
  @JsonProperty("error_text")
  private String errorText;

  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }
}