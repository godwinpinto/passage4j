package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bean class representing the body of a create magic link request.
 */
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

  /**
   * Get the user ID associated with the create magic link request.
   *
   * @return The user ID.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Set the user ID for the create magic link request.
   *
   * @param userId The user ID to set.
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Get the email associated with the create magic link request.
   *
   * @return The email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email for the create magic link request.
   *
   * @param email The email to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the phone number associated with the create magic link request.
   *
   * @return The phone number.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set the phone number for the create magic link request.
   *
   * @param phone The phone number to set.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Get the channel type associated with the create magic link request.
   *
   * @return The channel type.
   */
  public ChannelTypeEnum getChannel() {
    return channel;
  }

  /**
   * Set the channel type for the create magic link request.
   *
   * @param channel The channel type to set.
   */
  public void setChannel(ChannelTypeEnum channel) {
    this.channel = channel;
  }

  /**
   * Check if the create magic link request should be sent.
   *
   * @return True if the request should be sent, false otherwise.
   */
  public boolean isSend() {
    return send;
  }

  /**
   * Set whether the create magic link request should be sent.
   *
   * @param send True to send the request, false otherwise.
   */
  public void setSend(boolean send) {
    this.send = send;
  }

  /**
   * Get the magic link path associated with the create magic link request.
   *
   * @return The magic link path.
   */
  public String getMagicLinkPath() {
    return magicLinkPath;
  }

  /**
   * Set the magic link path for the create magic link request.
   *
   * @param magicLinkPath The magic link path to set.
   */
  public void setMagicLinkPath(String magicLinkPath) {
    this.magicLinkPath = magicLinkPath;
  }

  /**
   * Get the redirect URL associated with the create magic link request.
   *
   * @return The redirect URL.
   */
  public String getRedirectUrl() {
    return redirectUrl;
  }

  /**
   * Set the redirect URL for the create magic link request.
   *
   * @param redirectUrl The redirect URL to set.
   */
  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  /**
   * Get the time-to-live (TTL) value associated with the create magic link request.
   *
   * @return The TTL value.
   */
  public int getTtl() {
    return ttl;
  }

  /**
   * Set the time-to-live (TTL) value for the create magic link request.
   *
   * @param ttl The TTL value to set.
   */
  public void setTtl(int ttl) {
    this.ttl = ttl;
  }

  /**
   * Get the language associated with the create magic link request.
   *
   * @return The language.
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Set the language for the create magic link request.
   *
   * @param language The language to set.
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Get a string representation of the create magic link request body.
   *
   * @return A string representation of the object.
   */
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
