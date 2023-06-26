package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Bean class representing a magic link.
 */
@JsonRootName("magic_link")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MagicLinkBean {

  @JsonProperty("id")
  private String id;

  @JsonProperty("secret")
  private String secret;

  @JsonProperty("activated")
  private boolean activated;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("app_id")
  private String appId;

  @JsonProperty("identifier")
  private String identifier;

  @JsonProperty("type")
  private String type;

  @JsonProperty("redirectUrl")
  private String redirectUrl;

  @JsonProperty("ttl")
  private int ttl;

  @JsonProperty("url")
  private String url;

  /**
   * Get the ID of the magic link.
   *
   * @return The ID of the magic link.
   */
  public String getId() {
    return id;
  }

  /**
   * Set the ID of the magic link.
   *
   * @param id The ID of the magic link to set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get the secret of the magic link.
   *
   * @return The secret of the magic link.
   */
  public String getSecret() {
    return secret;
  }

  /**
   * Set the secret of the magic link.
   *
   * @param secret The secret of the magic link to set.
   */
  public void setSecret(String secret) {
    this.secret = secret;
  }

  /**
   * Check if the magic link is activated.
   *
   * @return True if the magic link is activated, false otherwise.
   */
  public boolean isActivated() {
    return activated;
  }

  /**
   * Set the activated status of the magic link.
   *
   * @param activated The activated status of the magic link to set.
   */
  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  /**
   * Get the user ID associated with the magic link.
   *
   * @return The user ID associated with the magic link.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Set the user ID associated with the magic link.
   *
   * @param userId The user ID associated with the magic link to set.
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Get the app ID associated with the magic link.
   *
   * @return The app ID associated with the magic link.
   */
  public String getAppId() {
    return appId;
  }

  /**
   * Set the app ID associated with the magic link.
   *
   * @param appId The app ID associated with the magic link to set.
   */
  public void setAppId(String appId) {
    this.appId = appId;
  }

  /**
   * Get the identifier of the magic link.
   *
   * @return The identifier of the magic link.
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Set the identifier of the magic link.
   *
   * @param identifier The identifier of the magic link to set.
   */
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Get the type of the magic link.
   *
   * @return The type of the magic link.
   */
  public String getType() {
    return type;
  }

  /**
   * Set the type of the magic link.
   *
   * @param type The type of the magic link to set.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Get the redirect URL of the magic link.
   *
   * @return The redirect URL of the magic link.
   */
  public String getRedirectUrl() {
    return redirectUrl;
  }

  /**
   * Set the redirect URL of the magic link.
   *
   * @param redirectUrl The redirect URL of the magic link to set.
   */
  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  /**
   * Get the time-to-live (TTL) of the magic link.
   *
   * @return The TTL of the magic link.
   */
  public int getTtl() {
    return ttl;
  }

  /**
   * Set the time-to-live (TTL) of the magic link.
   *
   * @param ttl The TTL of the magic link to set.
   */
  public void setTtl(int ttl) {
    this.ttl = ttl;
  }

  /**
   * Get the URL of the magic link.
   *
   * @return The URL of the magic link.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Set the URL of the magic link.
   *
   * @param url The URL of the magic link to set.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Get a string representation of the MagicLinkBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "MagicLinkBean{" +
        "id='" + id + '\'' +
        ", secret='" + secret + '\'' +
        ", activated=" + activated +
        ", userId='" + userId + '\'' +
        ", appId='" + appId + '\'' +
        ", identifier='" + identifier + '\'' +
        ", type='" + type + '\'' +
        ", redirectUrl='" + redirectUrl + '\'' +
        ", ttl=" + ttl +
        ", url='" + url + '\'' +
        '}';
  }
}

