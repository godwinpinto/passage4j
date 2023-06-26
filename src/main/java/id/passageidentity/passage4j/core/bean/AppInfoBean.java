package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Arrays;

@JsonRootName("app")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInfoBean {

  @JsonProperty("additional_auth_origins")
  private String[] additional_auth_origins;


  @JsonProperty("name")

  private String name;
  @JsonProperty("id")
  private String id;
  @JsonProperty("auth_origin")
  private String authOrigin;
  @JsonProperty("redirect_url")
  private String redirectUrl;
  @JsonProperty("login_url")
  private String loginUrl;
  @JsonProperty("rsa_private_key")
  private String privateKey;
  @JsonProperty("allowed_identifier")
  private String allowedIdentifier;
  @JsonProperty("require_identifier_verification")
  private boolean requireIdentifierVerification;
  @JsonProperty("session_timeout_length")
  private int sessionTimeoutLength;
  @JsonProperty("refresh_enabled")
  private boolean refreshEnabled;
  @JsonProperty("refresh_absolute_lifetime")
  private int refreshAbsoluteLifetime;
  @JsonProperty("refresh_inactivity_lifetime")
  private int refreshInactivityLifetime;
  @JsonProperty("user_metadata_schema")
  private UserMetadataFieldBean[] userMetadataSchemaResponse;
  @JsonProperty("layouts")
  private LayoutsBean layouts;
  @JsonProperty("default_language")
  private String defaultLanguage;
  @JsonProperty("auth_fallback_method")
  private String authFallbackMethod;
  @JsonProperty("auth_fallback_method_ttl")
  private int authFallbackMethodTTL;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAuthOrigin() {
    return authOrigin;
  }

  public void setAuthOrigin(String authOrigin) {
    this.authOrigin = authOrigin;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  public String getLoginUrl() {
    return loginUrl;
  }

  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public String getAllowedIdentifier() {
    return allowedIdentifier;
  }

  public void setAllowedIdentifier(String allowedIdentifier) {
    this.allowedIdentifier = allowedIdentifier;
  }

  public boolean isRequireIdentifierVerification() {
    return requireIdentifierVerification;
  }

  public void setRequireIdentifierVerification(boolean requireIdentifierVerification) {
    this.requireIdentifierVerification = requireIdentifierVerification;
  }

  public int getSessionTimeoutLength() {
    return sessionTimeoutLength;
  }

  public void setSessionTimeoutLength(int sessionTimeoutLength) {
    this.sessionTimeoutLength = sessionTimeoutLength;
  }

  public boolean isRefreshEnabled() {
    return refreshEnabled;
  }

  public void setRefreshEnabled(boolean refreshEnabled) {
    this.refreshEnabled = refreshEnabled;
  }

  public int getRefreshAbsoluteLifetime() {
    return refreshAbsoluteLifetime;
  }

  public void setRefreshAbsoluteLifetime(int refreshAbsoluteLifetime) {
    this.refreshAbsoluteLifetime = refreshAbsoluteLifetime;
  }

  public int getRefreshInactivityLifetime() {
    return refreshInactivityLifetime;
  }

  public void setRefreshInactivityLifetime(int refreshInactivityLifetime) {
    this.refreshInactivityLifetime = refreshInactivityLifetime;
  }

  public UserMetadataFieldBean[] getUserMetadataSchemaResponse() {
    return userMetadataSchemaResponse;
  }

  public void setUserMetadataSchemaResponse(
      UserMetadataFieldBean[] userMetadataSchemaResponse) {
    this.userMetadataSchemaResponse = userMetadataSchemaResponse;
  }

  public LayoutsBean getLayouts() {
    return layouts;
  }

  public void setLayouts(LayoutsBean layouts) {
    this.layouts = layouts;
  }

  public String getDefaultLanguage() {
    return defaultLanguage;
  }

  public void setDefaultLanguage(String defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
  }

  public String getAuthFallbackMethod() {
    return authFallbackMethod;
  }

  public void setAuthFallbackMethod(String authFallbackMethod) {
    this.authFallbackMethod = authFallbackMethod;
  }

  public int getAuthFallbackMethodTTL() {
    return authFallbackMethodTTL;
  }

  public void setAuthFallbackMethodTTL(int authFallbackMethodTTL) {
    this.authFallbackMethodTTL = authFallbackMethodTTL;
  }

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
