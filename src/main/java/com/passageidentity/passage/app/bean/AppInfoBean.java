package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
public class AppInfoBean {
  public String name;
  public String id;
  @JsonProperty("auth_origin")
  public String authOrigin;
  @JsonProperty("redirect_url")
  public String redirectUrl;
  @JsonProperty("login_url")
  public String loginUrl;
  @JsonProperty("rsa_public_key")
  public String publicKey;
  @JsonProperty("allowed_identifier")
  public String allowedIdentifier;
  @JsonProperty("require_identifier_verification")
  public boolean requireIdentifierVerification;
  @JsonProperty("session_timeout_length")
  public int sessionTimeoutLength;
  @JsonProperty("refresh_enabled")
  public boolean refreshEnabled;
  @JsonProperty("refresh_absolute_lifetime")
  public int refreshAbsoluteLifetime;
  @JsonProperty("refresh_inactivity_lifetime")
  public int refreshInactivityLifetime;
  @JsonProperty("user_metadata_schema")
  public UserMetadataFieldBean[] userMetadataSchemaResponse;
  public LayoutsBean layouts;
  @JsonProperty("default_language")
  public String defaultLanguage;
  @JsonProperty("auth_fallback_method")
  public String authFallbackMethod;
  @JsonProperty("auth_fallback_method_ttl")
  public int authFallbackMethodTTL;

}
