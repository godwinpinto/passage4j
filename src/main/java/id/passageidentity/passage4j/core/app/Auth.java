package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.exception.PassageException;

public interface Auth {

  String authenticateRequestWithAuthHeader(String authorizationToken) throws PassageException;

  String authenticateRequestWithCookie(String cookie_name_psg_auth_token) throws PassageException;

  String validateAuthToken(String authToken) throws PassageException;
}
