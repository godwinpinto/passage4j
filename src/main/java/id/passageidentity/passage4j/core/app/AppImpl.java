package id.passageidentity.passage4j.core.app;

import com.fasterxml.jackson.core.type.TypeReference;
import id.passageidentity.passage4j.core.bean.AppInfoBean;
import id.passageidentity.passage4j.core.bean.CreateMagicLinkBodyBean;
import id.passageidentity.passage4j.core.bean.MagicLinkBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import id.passageidentity.passage4j.core.http.HTTPResponse;
import id.passageidentity.passage4j.core.http.PassageHttpClient;
import id.passageidentity.passage4j.core.http.PassageHttpClientImpl;
import id.passageidentity.passage4j.core.util.PassageConstants;

/**
 * Implementation of the {@link App} interface.
 */
class AppImpl implements App {

  private final AppBean appBean;

  /**
   * Constructs an instance of {@link AppImpl} with the specified {@link AppBean}.
   *
   * @param appBean the {@link AppBean} representing the app
   */
  public AppImpl(AppBean appBean) {
    this.appBean = appBean;
  }

  /**
   * Retrieves information about the app.
   *
   * @return the {@link AppInfoBean} containing the app information
   * @throws PassageException if there is an error retrieving the app information
   */
  @Override
  public AppInfoBean getInfo() throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl();
    HTTPResponse<AppInfoBean> response;
    try {
      response = passageHttpClient.get(
          PassageConstants.PASSAGE_APP_INFO_URL + appBean.getId(),
          new TypeReference<AppInfoBean>() {
          }
      );
    } catch (Exception e) {
      e.printStackTrace();
      throw new PassageException("network error: failed to get Passage App Info");
    }

    if (response.getStatusCode() != 200) {
      throw new PassageException(
          "Failed to get Passage App Info",
          response.getStatusCode(),
          response.getStatusText(),
          response.getError().getErrorText()
      );
    }

    return response.getBody();
  }

  /**
   * Creates a magic link for the specified body.
   *
   * @param createMagicLinkBodyBean the body for creating the magic link
   * @return the {@link MagicLinkBean} representing the created magic link
   * @throws PassageException if there is an error creating the magic link
   */
  @Override
  public MagicLinkBean createMagicLink(CreateMagicLinkBodyBean createMagicLinkBodyBean) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    HTTPResponse<MagicLinkBean> response;
    String url = String.format(PassageConstants.PASSAGE_CREATE_MAGIC_LINK_URL, appBean.getId());
    try {
      response = passageHttpClient.post(
          url,
          createMagicLinkBodyBean,
          new TypeReference<MagicLinkBean>() {
          }
      );
    } catch (Exception e) {
      throw new PassageException("network error: failed to create Passage Magic Link");
    }

    if (response.getStatusCode() != 201) {
      throw new PassageException(
          "Failed to create Passage Magic Link",
          response.getStatusCode(),
          response.getStatusText(),
          response.getError().getErrorText()
      );
    }

    return response.getBody();
  }
}
