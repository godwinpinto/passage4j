package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MagicLinkBean {
  public String id;
  public String secret;
  public boolean activated;
  @JsonProperty("user_id")
  public String userId;
  @JsonProperty("app_id")
  public String appId;
  public String identifier;
  public String type;
  @JsonProperty("redirect_url")
  public String redirectUrl;
  public int ttl;
  public String url;
}
