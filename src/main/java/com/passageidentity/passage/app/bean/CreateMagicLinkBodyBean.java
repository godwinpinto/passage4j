package com.passageidentity.passage.app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMagicLinkBodyBean {
  @JsonProperty("user_id")
  public String userId;
  public String email;
  public String phone;
  public ChannelTypeEnum channel;
  public boolean send;
  @JsonProperty("magic_link_path")
  public String magicLinkPath;
  @JsonProperty("redirect_url")
  public String redirectUrl;
  public int ttl;
  public String language;

}
