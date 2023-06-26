package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Arrays;

/**
 * This class represents an application information bean.
 */
@JsonRootName("app")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInfoBean {

  // Array of additional authentication origins
  @JsonProperty("additional_auth_origins")
  private String[] additional_auth_origins;

  // Name of the application
  @JsonProperty("name")
  private String name;

  // ID of the application
  @JsonProperty("id")
  private String id;

  // Authentication origin of the application
  @JsonProperty("auth_origin")
  private String authOrigin;

  // Redirect URL of the application
  @JsonProperty("redirect_url")
  private String redirectUrl;

  // Login URL of the application
  @JsonProperty("login_url")
  private String loginUrl;

  // RSA private key of the application
  @JsonProperty("rsa_private_key")
  private String privateKey;

  // Allowed identifier of the application
  @JsonProperty("allowed_identifier")
  private String allowedIdentifier;

  // Flag indicating whether identifier verification is required
  @JsonProperty("require_identifier_verification")
  private boolean requireIdentifierVerification;

  // Session timeout length in seconds
  @JsonProperty("session_timeout_length")
  private int sessionTimeoutLength;

  // Flag indicating whether refresh is enabled
  @JsonProperty("refresh_enabled")
  private boolean refreshEnabled;

  // Refresh absolute lifetime in seconds
  @JsonProperty("refresh_absolute_lifetime")
  private int refreshAbsoluteLifetime;

  // Refresh inactivity lifetime in seconds
  @JsonProperty("refresh_inactivity_lifetime")
  private int refreshInactivityLifetime;

  // Array of user metadata fields
  @JsonProperty("user_metadata_schema")
  private UserMetadataFieldBean[] userMetadataSchemaResponse;

  // Layouts bean representing application layouts
  @JsonProperty("layouts")
  private LayoutsBean layouts;

  // Default language of the application
  @JsonProperty("default_language")
  private String defaultLanguage;

  // Authentication fallback method of the application
  @JsonProperty("auth_fallback_method")
  private String authFallbackMethod;

  // Authentication fallback method time-to-live in seconds
  @JsonProperty("auth_fallback_method_ttl")
  private int authFallbackMethodTTL;

  /**
   * Get the name of the application.
   * @return The application name.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the application.
   * @param name The application name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the ID of the application.
   * @return The application ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the ID of the application.
   * @param id The application ID.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the authentication origin of the application.
   * @return The authentication origin.
   */
  public String getAuthOrigin() {
    return authOrigin;
  }

  /**
   * Set the authentication origin of the application.
   * @param authOrigin The authentication origin.
   */
  public void setAuthOrigin(String authOrigin) {
    this.authOrigin = authOrigin;
  }

  /**
   * Get the redirect URL of the application.
   * @return The redirect URL.
   */
  public String getRedirectUrl() {
    return redirectUrl;
  }

  /**
   * Set the redirect URL of the application.
   * @param redirectUrl The redirect URL.
   */
  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  /**
   * Get the login URL of the application.
   * @return The login URL.
   */
  public String getLoginUrl() {
    return loginUrl;
  }

  /**
   * Set the login URL of the application.
   * @param loginUrl The login URL.
   */
  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }

  /**
   * Get the RSA private key of the application.
   * @return The RSA private key.
   */
  public String getPrivateKey() {
    return privateKey;
  }

  /**
   * Set the RSA private key of the application.
   * @param privateKey The RSA private key.
   */
  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  /**
   * Get the allowed identifier of the application.
   * @return The allowed identifier.
   */
  public String getAllowedIdentifier() {
    return allowedIdentifier;
  }

  /**
   * Set the allowed identifier of the application.
   * @param allowedIdentifier The allowed identifier.
   */
  public void setAllowedIdentifier(String allowedIdentifier) {
    this.allowedIdentifier = allowedIdentifier;
  }

  /**
   * Check if identifier verification is required for the application.
   * @return True if identifier verification is required, false otherwise.
   */
  public boolean isRequireIdentifierVerification() {
    return requireIdentifierVerification;
  }

  /**
   * Set whether identifier verification is required for the application.
   * @param requireIdentifierVerification True if identifier verification is required, false otherwise.
   */
  public void setRequireIdentifierVerification(boolean requireIdentifierVerification) {
    this.requireIdentifierVerification = requireIdentifierVerification;
  }

  /**
   * Get the session timeout length in seconds for the application.
   * @return The session timeout length.
   */
  public int getSessionTimeoutLength() {
    return sessionTimeoutLength;
  }

  /**
   * Set the session timeout length in seconds for the application.
   * @param sessionTimeoutLength The session timeout length.
   */
  public void setSessionTimeoutLength(int sessionTimeoutLength) {
    this.sessionTimeoutLength = sessionTimeoutLength;
  }

  /**
   * Check if refresh is enabled for the application.
   * @return True if refresh is enabled, false otherwise.
   */
  public boolean isRefreshEnabled() {
    return refreshEnabled;
  }

  /**
   * Set whether refresh is enabled for the application.
   * @param refreshEnabled True if refresh is enabled, false otherwise.
   */
  public void setRefreshEnabled(boolean refreshEnabled) {
    this.refreshEnabled = refreshEnabled;
  }

  /**
   * Get the refresh absolute lifetime in seconds for the application.
   * @return The refresh absolute lifetime.
   */
  public int getRefreshAbsoluteLifetime() {
    return refreshAbsoluteLifetime;
  }

  /**
   * Set the refresh absolute lifetime in seconds for the application.
   * @param refreshAbsoluteLifetime The refresh absolute lifetime.
   */
  public void setRefreshAbsoluteLifetime(int refreshAbsoluteLifetime) {
    this.refreshAbsoluteLifetime = refreshAbsoluteLifetime;
  }

  /**
   * Get the refresh inactivity lifetime in seconds for the application.
   * @return The refresh inactivity lifetime.
   */
  public int getRefreshInactivityLifetime() {
    return refreshInactivityLifetime;
  }

  /**
   * Set the refresh inactivity lifetime in seconds for the application.
   * @param refreshInactivityLifetime The refresh inactivity lifetime.
   */
  public void setRefreshInactivityLifetime(int refreshInactivityLifetime) {
    this.refreshInactivityLifetime = refreshInactivityLifetime;
  }

  /**
   * Get the user metadata schema response for the application.
   * @return The user metadata schema response.
   */
  public UserMetadataFieldBean[] getUserMetadataSchemaResponse() {
    return userMetadataSchemaResponse;
  }

  /**
   * Set the user metadata schema response for the application.
   * @param userMetadataSchemaResponse The user metadata schema response.
   */
  public void setUserMetadataSchemaResponse(UserMetadataFieldBean[] userMetadataSchemaResponse) {
    this.userMetadataSchemaResponse = userMetadataSchemaResponse;
  }

  /**
   * Get the layouts bean representing application layouts.
   * @return The layouts bean.
   */
  public LayoutsBean getLayouts() {
    return layouts;
  }

  /**
   * Set the layouts bean representing application layouts.
   * @param layouts The layouts bean.
   */
  public void setLayouts(LayoutsBean layouts) {
    this.layouts = layouts;
  }

  /**
   * Get the default language of the application.
   * @return The default language.
   */
  public String getDefaultLanguage() {
    return defaultLanguage;
  }

  /**
   * Set the default language of the application.
   * @param defaultLanguage The default language.
   */
  public void setDefaultLanguage(String defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
  }

  /**
   * Get the authentication fallback method of the application.
   * @return The authentication fallback method.
   */
  public String getAuthFallbackMethod() {
    return authFallbackMethod;
  }

  /**
   * Set the authentication fallback method of the application.
   * @param authFallbackMethod The authentication fallback method.
   */
  public void setAuthFallbackMethod(String authFallbackMethod) {
    this.authFallbackMethod = authFallbackMethod;
  }

  /**
   * Get the authentication fallback method time-to-live in seconds for the application.
   * @return The authentication fallback method time-to-live.
   */
  public int getAuthFallbackMethodTTL() {
    return authFallbackMethodTTL;
  }

  /**
   * Set the authentication fallback method time-to-live in seconds for the application.
   * @param authFallbackMethodTTL The authentication fallback method time-to-live.
   */
  public void setAuthFallbackMethodTTL(int authFallbackMethodTTL) {
    this.authFallbackMethodTTL = authFallbackMethodTTL;
  }

  /**
   * Get a string representation of the AppInfoBean object.
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "AppInfoBean{" +
        "additional_auth_origins=" + Arrays.toString(additional_auth_origins) +
        ", name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", authOrigin='" + authOrigin + '\'' +
        ", redirectUrl='" + redirectUrl + '\'' +
        ", loginUrl='" + loginUrl + '\'' +
        ", privateKey='" + privateKey + '\'' +
        ", allowedIdentifier='" + allowedIdentifier + '\'' +
        ", requireIdentifierVerification=" + requireIdentifierVerification +
        ", sessionTimeoutLength=" + sessionTimeoutLength +
        ", refreshEnabled=" + refreshEnabled +
        ", refreshAbsoluteLifetime=" + refreshAbsoluteLifetime +
        ", refreshInactivityLifetime=" + refreshInactivityLifetime +
        ", userMetadataSchemaResponse=" + Arrays.toString(userMetadataSchemaResponse) +
        ", layouts=" + layouts +
        ", defaultLanguage='" + defaultLanguage + '\'' +
        ", authFallbackMethod='" + authFallbackMethod + '\'' +
        ", authFallbackMethodTTL=" + authFallbackMethodTTL +
        '}';
  }
}
