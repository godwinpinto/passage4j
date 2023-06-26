package id.passageidentity.passage4j.core.http;


import id.passageidentity.passage4j.core.http.exception.HTTPException;

public class HTTPResponse<T> {

  private int statusCode;
  private String statusText;
  private T body;
  private HTTPException error;

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusText() {
    return statusText;
  }

  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }

  public T getBody() {
    return body;
  }

  public void setBody(T body) {
    this.body = body;
  }

  public HTTPException getError() {
    return error;
  }

  public void setError(HTTPException error) {
    this.error = error;
  }
}
