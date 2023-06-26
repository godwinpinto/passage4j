package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.exception.PassageException;

/**
 * Implementation of the Passage interface.
 */
public class PassageNew implements Passage {

  private final App app;
  private final User user;
  private final Auth auth;

  /**
   * Constructs a new Passage instance with the specified app ID and configuration.
   *
   * @param appID  the ID of the app
   * @param config the Passage configuration
   * @throws PassageException if an error occurs during initialization
   */
  public PassageNew(String appID, PassageConfig config) throws PassageException {
    AppBean appBean = new AppBean();
    appBean.setId(appID);
    appBean.setConfig(config);
    PassageKeyManager.fetchJWKS(appID);
    this.app = new AppImpl(appBean);
    this.auth = new AuthImpl(appBean);
    this.user = new UserImpl(appBean);
  }

  /**
   * Returns the implementation of the App interface.
   *
   * @return the App implementation
   */
  @Override
  public App app() {
    return app;
  }

  /**
   * Returns the implementation of the User interface.
   *
   * @return the User implementation
   */
  @Override
  public User user() {
    return user;
  }

  /**
   * Returns the implementation of the Auth interface.
   *
   * @return the Auth implementation
   */
  @Override
  public Auth auth() {
    return auth;
  }
}
