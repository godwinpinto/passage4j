package id.passageidentity.passage4j.core.app;

import com.fasterxml.jackson.core.type.TypeReference;
import id.passageidentity.passage4j.core.bean.CreateUserBodyBean;
import id.passageidentity.passage4j.core.bean.DeviceBean;
import id.passageidentity.passage4j.core.bean.DeviceListBean;
import id.passageidentity.passage4j.core.bean.UpdateBodyBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import id.passageidentity.passage4j.core.http.HTTPResponse;
import id.passageidentity.passage4j.core.http.PassageHttpClient;
import id.passageidentity.passage4j.core.http.PassageHttpClientImpl;
import id.passageidentity.passage4j.core.http.exception.HTTPException;
import id.passageidentity.passage4j.core.util.PassageConstants;
import java.util.ArrayList;
import java.util.List;

class UserImpl implements User {

  final AppBean appBean;


  public UserImpl(AppBean appBean) {
    this.appBean = appBean;
  }

  /**
   * @param userID
   */
  @Override
  public UserBean getUser(String userID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_GET_USER_INFO_URL, appBean.getId(), userID);
    HTTPResponse<UserBean> response = null;
    try {
      response = passageHttpClient.get(
          url, new TypeReference<UserBean>() {
          });
    } catch (Exception e) {
      throw new PassageException("network error: failed to get Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID));
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("Failed to get Passage User: " + response.getStatusCode());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public UserBean activateUser(String userID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_ACTIVATE_USER_URL, appBean.getId(), userID);
    HTTPException httpException = new HTTPException();
    HTTPResponse<UserBean> response;
    try {
      response = passageHttpClient.patch(url, httpException, new TypeReference<UserBean>() {
      });
    } catch (Exception e) {
      throw new PassageException("network error: failed to activate Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID), response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to activate Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public UserBean deactivateUser(String userID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_DEACTIVATE_USER_URL, appBean.getId(), userID);
    HTTPException httpException = new HTTPException();
    HTTPResponse<UserBean> response;
    try {
      response = passageHttpClient.patch(url, httpException, new TypeReference<UserBean>() {
      });
    } catch (Exception e) {
      throw new PassageException("network error: failed to deactivate Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID), response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to deactivate Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @param updateBodyBean
   * @return
   */
  @Override
  public UserBean updateUser(String userID, UpdateBodyBean updateBodyBean) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_UPDATE_USER_URL, appBean.getId(), userID);
    HTTPResponse<UserBean> response;
    try {
      response = passageHttpClient.patch(url, updateBodyBean, new TypeReference<UserBean>() {
      });
    } catch (Exception e) {
      throw new PassageException("network error: failed to update Passage User attributes");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID), response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to update Passage User's attributes", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public boolean deleteUser(String userID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_DELETE_USER_URL, appBean.getId(), userID);
    HTTPResponse<ArrayList<DeviceBean>> response = null;
    try {
      response = passageHttpClient.delete(
          url, null);
    } catch (Exception e) {
      throw new PassageException("network error: could not delete Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID), response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to delete a device for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return true;
  }

  /**
   * @param createUserBodyBean
   * @return
   */
  @Override
  public UserBean createUser(CreateUserBodyBean createUserBodyBean) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_CREATE_USER_URL, appBean.getId());
    HTTPResponse<UserBean> response = null;
    try {
      response = passageHttpClient.post(url, createUserBodyBean, new TypeReference<UserBean>() {
      });
    } catch (Exception e) {
      throw new PassageException("network error: failed to get Passage User");
    }
    if (response.getStatusCode() != 201) {
      throw new PassageException("failed to create Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public List<DeviceBean> listUserDevices(String userID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_GET_USER_DEVICES_URL, appBean.getId(), userID);
    HTTPResponse<DeviceListBean> response = null;
    try {
      response = passageHttpClient.get(
          url, new TypeReference<DeviceListBean>() {
          });
    } catch (Exception e) {
      e.printStackTrace();
      throw new PassageException("network error: failed to list devices for a Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID));
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to list devices for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody().getDevices();

  }

  /**
   * @param userID
   * @param deviceID
   * @return
   */
  @Override
  public boolean revokeUserDevice(String userID, String deviceID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_REVOKE_USER_DEVICE_URL, appBean.getId(), userID, deviceID);
    HTTPResponse<ArrayList<DeviceBean>> response = null;
    try {
      response = passageHttpClient.delete(
          url, null);
    } catch (Exception e) {
      throw new PassageException("network error: failed to delete a device for a Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(
          String.format("passage User with ID \"%s\" does not exist or Devices with ID \"%s\" does not exist", userID,
              deviceID), response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to delete a device for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return true;

  }

  /**
   * @param userID
   * @return
   */
  @Override
  public boolean signOut(String userID) throws PassageException {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_SIGNOUT_USER_URL, appBean.getId(), userID);
    HTTPResponse<HTTPException> response = null;
    try {
      response = passageHttpClient.delete(
          url, new TypeReference<HTTPException>() {
          });
    } catch (Exception e) {
      e.printStackTrace();
      throw new PassageException("network error: failed to revoke all refresh tokens for a Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageException(String.format(UserBean.UserIDDoesNotExist, userID), response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageException("failed to revoke all refresh tokens for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return true;
  }
}
