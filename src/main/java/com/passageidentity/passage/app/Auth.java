package com.passageidentity.passage.app;

import com.passageidentity.passage.exception.PassageError;

public interface Auth {

  public String authenticateRequest();

  public String authenticateRequestWithAuthHeader(String authorizationToken) throws PassageError;

  public String authenticateRequestWithCookie(String cookie_name_psg_auth_token) throws PassageError;
  public String validateAuthToken(String authToken) throws PassageError;
}
