package id.passageidentity.passage4j.core.http.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an HTTP exception with an error text.
 */
public class HTTPException {

  @JsonProperty("error_text")
  private String errorText;

  /**
   * Returns the error text associated with the HTTP exception.
   *
   * @return The error text.
   */
  public String getErrorText() {
    return errorText;
  }

  /**
   * Sets the error text for the HTTP exception.
   *
   * @param errorText The error text to set.
   */
  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }
}
