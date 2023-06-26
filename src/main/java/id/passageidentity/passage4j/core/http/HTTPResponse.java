package id.passageidentity.passage4j.core.http;


import id.passageidentity.passage4j.core.http.exception.HTTPException;

/**
 * Represents an HTTP response.
 *
 * @param <T> The type of the response body.
 */
public class HTTPResponse<T> {

  private int statusCode;
  private String statusText;
  private T body;
  private HTTPException error;

  /**
   * Returns the HTTP status code of the response.
   *
   * @return The status code.
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Sets the HTTP status code of the response.
   *
   * @param statusCode The status code to set.
   */
  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * Returns the HTTP status text of the response.
   *
   * @return The status text.
   */
  public String getStatusText() {
    return statusText;
  }

  /**
   * Sets the HTTP status text of the response.
   *
   * @param statusText The status text to set.
   */
  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }

  /**
   * Returns the body of the response.
   *
   * @return The response body.
   */
  public T getBody() {
    return body;
  }

  /**
   * Sets the body of the response.
   *
   * @param body The response body to set.
   */
  public void setBody(T body) {
    this.body = body;
  }

  /**
   * Returns the HTTP exception associated with the response, if any.
   *
   * @return The HTTP exception, or null if no exception occurred.
   */
  public HTTPException getError() {
    return error;
  }

  /**
   * Sets the HTTP exception for the response.
   *
   * @param error The HTTP exception to set.
   */
  public void setError(HTTPException error) {
    this.error = error;
  }
}
