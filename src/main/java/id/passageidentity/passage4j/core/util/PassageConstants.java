package id.passageidentity.passage4j.core.util;

public class PassageConstants {

  public static final String PASSAGE_BASE_URL = "https://api.passage.id/v1";
  public static final String AUTH_TOKEN_COOKIE_NAME = "psg_auth_token";
  public static final String PASSAGE_JWKS_URL = "https://auth.passage.id/v1/apps/%s/.well-known/jwks.json";
  public static final String PASSAGE_VERSION = "1.0";
  public static final String PASSAGE_APP_INFO_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/";
  public static final String PASSAGE_CREATE_MAGIC_LINK_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/magic-links/";
  public static final String PASSAGE_GET_USER_INFO_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s";
  public static final String PASSAGE_ACTIVATE_USER_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/activate";
  public static final String PASSAGE_DEACTIVATE_USER_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/deactivate";
  public static final String PASSAGE_UPDATE_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s";
  public static final String PASSAGE_DELETE_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s";
  public static final String PASSAGE_CREATE_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/";
  public static final String PASSAGE_GET_USER_DEVICES_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/devices";
  public static final String PASSAGE_REVOKE_USER_DEVICE_URL =
      PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/devices/%s";
  public static final String PASSAGE_SIGNOUT_USER_URL = PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/token/";
}
