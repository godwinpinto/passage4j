package com.passageidentity.passage.app;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.passageidentity.passage.exception.PassageError;
import com.passageidentity.passage.util.PassageConstants;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class PassageNew implements Passage{

  AppBean appBean;



  public PassageNew(String appID, PassageConfig config) throws PassageError {
    appBean=new AppBean();
    appBean.setId(appID);
    appBean.setConfig(config);
  }

  /**
   * @return 
   */
  @Override
  public App app() {
    return null;
  }

  /**
   * @return 
   */
  @Override
  public User user() {
    return null;
  }

  /**
   * @return 
   */
  @Override
  public Auth auth() {
    return null;
  }



}
