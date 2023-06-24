package com.passageidentity.passage.app;

import com.passageidentity.passage.exception.PassageError;

public interface Auth {

  String authenticateRequestWithAuthHeader(String authorizationToken) throws PassageError;

  String authenticateRequestWithCookie(String cookie_name_psg_auth_token) throws PassageError;
  String validateAuthToken(String authToken) throws PassageError;
}
