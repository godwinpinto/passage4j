package id.passageidentity.passage4j.core.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassageConfig {

  @JsonProperty("api_key")
  private String apiKey;
  @JsonProperty("header_auth")
  private boolean headerAuth;

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public boolean isHeaderAuth() {
    return headerAuth;
  }

  public void setHeaderAuth(boolean headerAuth) {
    this.headerAuth = headerAuth;
  }
}
