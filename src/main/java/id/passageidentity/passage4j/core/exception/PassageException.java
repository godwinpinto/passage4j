package id.passageidentity.passage4j.core.exception;

import java.util.StringJoiner;


/**
 * Custom exception class for Passage exceptions.
 */
public class PassageException extends Exception {

  private final String message;

  public int getStatusCode() {
    return statusCode;
  }

  public String getStatusText() {
    return statusText;
  }

  public String getErrorText() {
    return errorText;
  }

  private int statusCode = 0;
  private String statusText = "";
  private String errorText = "";

  /**
   * Constructs a new PassageException with the specified message, status code, status text, and error text.
   *
   * @param message     The detailed error message.
   * @param statusCode  The HTTP status code associated with the exception.
   * @param statusText  The HTTP status text associated with the exception.
   * @param errorText   The error text associated with the exception.
   */
  public PassageException(String message, int statusCode, String statusText, String errorText) {
    this.message = message;
    this.statusCode = statusCode;
    this.statusText = statusText;
    this.errorText = errorText;
  }

  /**
   * Constructs a new PassageException with the specified message.
   *
   * @param message The detailed error message.
   */
  public PassageException(String message) {
    this.message = message;
  }

  /**
   * Returns the formatted error message.
   *
   * @return The formatted error message.
   */
  @Override
  public String getMessage() {
    return formatErrorMessage();
  }

  /**
   * Formats the error message with the relevant information.
   *
   * @return The formatted error message.
   */
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
