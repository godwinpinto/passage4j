package id.passageidentity.passage4j.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LayoutsBean {

  @JsonProperty("registration")

  private LayoutConfigBean[] registration;
  @JsonProperty("profile")
  private LayoutConfigBean[] profile;

  public LayoutConfigBean[] getRegistration() {
    return registration;
  }

  public void setRegistration(LayoutConfigBean[] registration) {
    this.registration = registration;
  }

  public LayoutConfigBean[] getProfile() {
    return profile;
  }

  public void setProfile(LayoutConfigBean[] profile) {
    this.profile = profile;
  }


  @Override
  public String toString() {
    return "LayoutsBean{" +
        "registration=" + Arrays.toString(registration) +
        ", profile=" + Arrays.toString(profile) +
        '}';
  }
}
