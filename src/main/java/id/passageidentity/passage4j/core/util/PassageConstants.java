package id.passageidentity.passage4j.core.util;

/**
 * Constants for Passage4J
 */
public class PassageConstants {

  /**
   * Base URL for Passage API.
   */
  public static final String PASSAGE_BASE_URL = "https://api.passage.id/v1";

  /**
   * Name of the authentication token cookie.
   */
  public static final String AUTH_TOKEN_COOKIE_NAME = "psg_auth_token";

  /**
   * URL for JWKS (JSON Web Key Set) endpoint.
   * Replace "%s" with the app ID.
   */
  public static final String PASSAGE_JWKS_URL = "https://auth.passage.id/v1/apps/%s/.well-known/jwks.json";

  /**
   * Passage API version.
   */
  public static final String PASSAGE_VERSION = "1.0";

  /**
   * URL for retrieving app information.
   */
  public static final String PASSAGE_APP_INFO_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/";

  /**
   * URL for creating a magic link.
   * Replace "%s" with the app ID.
   */
  public static final String PASSAGE_CREATE_MAGIC_LINK_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/magic-links/";

  /**
   * URL for retrieving user information.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_GET_USER_INFO_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s";

  /**
   * URL for activating a user.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_ACTIVATE_USER_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/activate";

  /**
   * URL for deactivating a user.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_DEACTIVATE_USER_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/deactivate";

  /**
   * URL for updating a user.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_UPDATE_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s";

  /**
   * URL for deleting a user.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_DELETE_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s";

  /**
   * URL for creating a user.
   * Replace "%s" with the app ID.
   */
  public static final String PASSAGE_CREATE_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/";

  /**
   * URL for retrieving user devices.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_GET_USER_DEVICES_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/devices";

  /**
   * URL for revoking a user device.
   * Replace "%s" with the app ID, user ID, and device ID.
   */
  public static final String PASSAGE_REVOKE_USER_DEVICE_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/devices/%s";

  /**
   * URL for signing out a user.
   * Replace "%s" with the app ID and user ID.
   */
  public static final String PASSAGE_SIGNOUT_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/tokens/";
}
