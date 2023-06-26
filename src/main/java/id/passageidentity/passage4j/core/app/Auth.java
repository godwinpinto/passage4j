package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.exception.PassageException;

/**
 * The Auth interface provides methods for authentication and authorization.
 */
public interface Auth {

  /**
   * Authenticates a request using the authorization header token.
   *
   * @param authorizationToken The authorization token provided in the request header.
   * @return The authenticated user's information.
   * @throws PassageException If there is an error during the authentication process.
   */
  String authenticateRequestWithAuthHeader(String authorizationToken) throws PassageException;

  /**
   * Authenticates a request using a cookie.
   *
   * @param cookie_name_psg_auth_token The name of the cookie containing the authentication token.
   * @return The authenticated user's information.
   * @throws PassageException If there is an error during the authentication process.
   */
  String authenticateRequestWithCookie(String cookie_name_psg_auth_token) throws PassageException;

  /**
   * Validates an authentication token.
   *
   * @param authToken The authentication token to be validated.
   * @return The validated user's information.
   * @throws PassageException If the authentication token is invalid or expired.
   */
  String validateAuthToken(String authToken) throws PassageException;
}
