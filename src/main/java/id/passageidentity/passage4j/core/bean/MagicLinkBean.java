package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  public int getTtl() {
    return ttl;
  }

  public void setTtl(int ttl) {
    this.ttl = ttl;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

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
