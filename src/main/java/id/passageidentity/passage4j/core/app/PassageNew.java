package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.exception.PassageException;

public class PassageNew implements Passage {

  private final App app;

  private final User user;

  private final Auth auth;


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
   * @return
   */
  @Override
  public App app() {
    return app;
  }

  /**
   * @return
   */
  @Override
  public User user() {
    return user;
  }

  /**
   * @return
   */
  @Override
  public Auth auth() {
    return auth;
  }


}
