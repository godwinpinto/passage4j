package id.passageidentity.passage4j.core.app;


/**
 * Represents an app in Passage.
 */
class AppBean {

  private String id;
  private PassageConfig config;

  /**
   * Gets the ID of the app.
   *
   * @return the app ID
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the ID of the app.
   *
   * @param id the app ID to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the configuration of the app.
   *
   * @return the {@link PassageConfig} object representing the app configuration
   */
  public PassageConfig getConfig() {
    return config;
  }

  /**
   * Sets the configuration of the app.
   *
   * @param config the {@link PassageConfig} object representing the app configuration to set
   */
  public void setConfig(PassageConfig config) {
    this.config = config;
  }

}
