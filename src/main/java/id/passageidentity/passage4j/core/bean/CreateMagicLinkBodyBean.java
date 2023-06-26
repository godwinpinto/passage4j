package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateMagicLinkBodyBean {

  @JsonProperty("user_id")
  private String userId;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("channel")
  private ChannelTypeEnum channel;
  @JsonProperty("send")
  private boolean send;
  @JsonProperty("magic_link_path")
  private String magicLinkPath;
  @JsonProperty("redirect_url")
  private String redirectUrl;
  @JsonProperty("ttl")
  private int ttl;
  @JsonProperty("language")
  private String language;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ChannelTypeEnum getChannel() {
    return channel;
  }

  public void setChannel(ChannelTypeEnum channel) {
    this.channel = channel;
  }

  public boolean isSend() {
    return send;
  }

  public void setSend(boolean send) {
    this.send = send;
  }

  public String getMagicLinkPath() {
    return magicLinkPath;
  }

  public void setMagicLinkPath(String magicLinkPath) {
    this.magicLinkPath = magicLinkPath;
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

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return "CreateMagicLinkBodyBean{" +
        "userId='" + userId + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", channel=" + channel +
        ", send=" + send +
        ", magicLinkPath='" + magicLinkPath + '\'' +
        ", redirectUrl='" + redirectUrl + '\'' +
        ", ttl=" + ttl +
        ", language='" + language + '\'' +
        '}';
  }
}
