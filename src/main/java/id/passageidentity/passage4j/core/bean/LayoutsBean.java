package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/**
 * Bean class representing layouts.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayoutsBean {

  @JsonProperty("registration")
  private LayoutConfigBean[] registration;

  @JsonProperty("profile")
  private LayoutConfigBean[] profile;

  /**
   * Get the registration layouts.
   *
   * @return The registration layouts.
   */
  public LayoutConfigBean[] getRegistration() {
    return registration;
  }

  /**
   * Set the registration layouts.
   *
   * @param registration The registration layouts to set.
   */
  public void setRegistration(LayoutConfigBean[] registration) {
    this.registration = registration;
  }

  /**
   * Get the profile layouts.
   *
   * @return The profile layouts.
   */
  public LayoutConfigBean[] getProfile() {
    return profile;
  }

  /**
   * Set the profile layouts.
   *
   * @param profile The profile layouts to set.
   */
  public void setProfile(LayoutConfigBean[] profile) {
    this.profile = profile;
  }

  /**
   * Get a string representation of the LayoutsBean object.
   *
   * @return The string representation.
   */
  @Override
  public String toString() {
    return "LayoutsBean{" +
        "registration=" + Arrays.toString(registration) +
        ", profile=" + Arrays.toString(profile) +
        '}';
  }
}
