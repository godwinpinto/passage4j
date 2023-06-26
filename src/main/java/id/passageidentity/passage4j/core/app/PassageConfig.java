package id.passageidentity.passage4j.core.app;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Configuration class for Passage.
 */
public class PassageConfig {

  @JsonProperty("api_key")
  private String apiKey;

  @JsonProperty("header_auth")
  private boolean headerAuth;

  /**
   * Retrieves the API key.
   *
   * @return the API key
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Sets the API key.
   *
   * @param apiKey the API key to set
   */
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  /**
   * Checks if header-based authentication is enabled.
   *
   * @return true if header-based authentication is enabled, false otherwise
   */
  public boolean isHeaderAuth() {
    return headerAuth;
  }

  /**
   * Enables or disables header-based authentication.
   *
   * @param headerAuth true to enable header-based authentication, false to disable it
   */
  public void setHeaderAuth(boolean headerAuth) {
    this.headerAuth = headerAuth;
  }
}
