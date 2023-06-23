package com.passageidentity.passage.app;


class AppBean {
  private String id;
/*
  private JWKSet jwkSet;
*/
  private PassageConfig config;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

/*
  public JWKSet getJwkSet() {
    return jwkSet;
  }

  public void setJwkSet(JWKSet jwkSet) {
    this.jwkSet = jwkSet;
  }
*/

  public PassageConfig getConfig() {
    return config;
  }

  public void setConfig(PassageConfig config) {
    this.config = config;
  }

}
