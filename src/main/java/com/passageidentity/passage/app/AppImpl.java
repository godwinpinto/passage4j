package com.passageidentity.passage.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.passageidentity.passage.app.bean.AppInfoBean;
import com.passageidentity.passage.app.bean.CreateMagicLinkBodyBean;
import com.passageidentity.passage.app.bean.MagicLinkBean;
import com.passageidentity.passage.exception.PassageError;
import com.passageidentity.passage.http.HTTPResponse;
import com.passageidentity.passage.http.PassageHttpClient;
import com.passageidentity.passage.http.PassageHttpClientImpl;
import com.passageidentity.passage.util.PassageConstants;

public class AppImpl implements App {

  private final AppBean appBean;

  public AppImpl(AppBean appBean) {
    this.appBean = appBean;
  }

  /**
   * @return
   */
  @Override
  public AppInfoBean getInfo() throws PassageError {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl();
    HTTPResponse<AppInfoBean> response;
    try {
      response = passageHttpClient.get(PassageConstants.PASSAGE_BASE_URL + "/apps/" + appBean.getId(),
          new TypeReference<AppInfoBean>() {
          });
    } catch (Exception e) {
      e.printStackTrace();
      throw new PassageError("network error: failed to get Passage App Info");
    }

    if (response.getStatusCode() != 200) {
      throw new PassageError("Failed to get Passage App Info", response.getStatusCode(), response.getStatusText(),
          response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @return
   */
  @Override
  public MagicLinkBean createMagicLink(CreateMagicLinkBodyBean createMagicLinkBodyBean) throws PassageError {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    HTTPResponse<MagicLinkBean> response;
    try {
      response = passageHttpClient.post(
          PassageConstants.PASSAGE_BASE_URL + "/apps/" + appBean.getId() + "/magic-links/", createMagicLinkBodyBean,
          new TypeReference<MagicLinkBean>() {
          });
    } catch (Exception e) {
      throw new PassageError("network error: failed to create Passage Magic Link");
    }

    if (response.getStatusCode() != 201) {
      throw new PassageError("Failed to create Passage Magic Link", response.getStatusCode(), response.getStatusText(),
          response.getError().getErrorText());
    }

    return response.getBody();
  }
}
