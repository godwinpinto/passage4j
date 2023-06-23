package com.passageidentity.passage.http;


import com.passageidentity.passage.http.exception.HTTPError;

public class HTTPResponse<T> {
  private int statusCode;
  private String statusText;
  private T body;
  private HTTPError error;

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

  public HTTPError getError() {
    return error;
  }

  public void setError(HTTPError error) {
    this.error = error;
  }
}
