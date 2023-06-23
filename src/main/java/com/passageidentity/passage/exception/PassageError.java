package com.passageidentity.passage.exception;

import java.util.StringJoiner;

public class PassageError extends Exception {
  private final String message;
  private int statusCode=0;
  private String statusText="";
  private String errorText="";

  public PassageError(String message, int statusCode, String statusText, String errorText) {
    this.message = message;
    this.statusCode = statusCode;
    this.statusText = statusText;
    this.errorText = errorText;
  }

  public PassageError(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return formatErrorMessage();
  }

  private String formatErrorMessage() {
    StringJoiner joiner = new StringJoiner(", ");
    joiner.add("Passage Error - ");

    if (message != null && !message.isEmpty()) {
      joiner.add("message: " + message);
    }
    if (statusCode != 0) {
      joiner.add("status_code: " + statusCode);
    }
    if (statusText != null && !statusText.isEmpty()) {
      joiner.add("status_text: " + statusText);
    }
    if (errorText != null && !errorText.isEmpty()) {
      joiner.add("error: " + errorText);
    }

    return joiner.toString();
  }
}
