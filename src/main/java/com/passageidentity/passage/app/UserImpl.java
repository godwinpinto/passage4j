package com.passageidentity.passage.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.passageidentity.passage.app.bean.CreateUserBodyBean;
import com.passageidentity.passage.app.bean.DeviceBean;
import com.passageidentity.passage.app.bean.DeviceListBean;
import com.passageidentity.passage.app.bean.UpdateBodyBean;
import com.passageidentity.passage.app.bean.UserBean;
import com.passageidentity.passage.exception.PassageError;
import com.passageidentity.passage.http.HTTPResponse;
import com.passageidentity.passage.http.PassageHttpClient;
import com.passageidentity.passage.http.PassageHttpClientImpl;
import com.passageidentity.passage.http.exception.HTTPError;
import com.passageidentity.passage.util.PassageConstants;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements User {

  final AppBean appBean;


  public UserImpl(AppBean appBean) {
    this.appBean = appBean;
  }

  /**
   * @param userID
   */
  @Override
  public UserBean getUser(String userID) throws PassageError {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s", appBean.getId(), userID);
    HTTPResponse<UserBean> response = null;
    try {
      response = passageHttpClient.get(
          url, new TypeReference<UserBean>(){});
    } catch (Exception e) {
      throw new PassageError("network error: failed to get Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID));
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("Failed to get Passage User: " + response.getStatusCode());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public UserBean activateUser(String userID) throws PassageError{
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/activate", appBean.getId(),userID);
    HTTPError httpError=new HTTPError();
    HTTPResponse<UserBean> response;
    try {
      response = passageHttpClient.patch(url, httpError, new TypeReference<UserBean>(){});
    } catch (Exception e) {
      throw new PassageError("network error: failed to activate Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID),response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to activate Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public UserBean deactivateUser(String userID) throws PassageError {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/deactivate", appBean.getId(),userID);
    HTTPError httpError=new HTTPError();
    HTTPResponse<UserBean> response;
    try {
      response = passageHttpClient.patch(url, httpError, new TypeReference<UserBean>(){});
    } catch (Exception e) {
      throw new PassageError("network error: failed to deactivate Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID),response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to deactivate Passage User", response.getStatusCode(),
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
  public UserBean updateUser(String userID, UpdateBodyBean updateBodyBean) throws PassageError{
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s", appBean.getId(),userID);
    HTTPResponse<UserBean> response;
    try {
      response = passageHttpClient.patch(url, updateBodyBean, new TypeReference<UserBean>(){});
    } catch (Exception e) {
      throw new PassageError("network error: failed to update Passage User attributes");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID),response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to update Passage User's attributes", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public boolean deleteUser(String userID) throws PassageError{
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s", appBean.getId(), userID);
    HTTPResponse<ArrayList<DeviceBean>> response = null;
    try {
      response = passageHttpClient.delete(
          url, null);
    } catch (Exception e) {
      throw new PassageError("network error: could not delete Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID),response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to delete a device for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return true;
  }

  /**
   * @param createUserBodyBean
   * @return
   */
  @Override
  public UserBean createUser(CreateUserBodyBean createUserBodyBean) throws PassageError {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/", appBean.getId());
    HTTPResponse<UserBean> response = null;
    try {
      response = passageHttpClient.post(url, createUserBodyBean, new TypeReference<UserBean>(){});
    } catch (Exception e) {
      throw new PassageError("network error: failed to get Passage User");
    }
    if (response.getStatusCode() != 201) {
      throw new PassageError("failed to create Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return response.getBody();
  }

  /**
   * @param userID
   * @return
   */
  @Override
  public List<DeviceBean> listUserDevices(String userID) throws PassageError{
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/devices", appBean.getId(), userID);
    HTTPResponse<DeviceListBean> response = null;
    try {
      response = passageHttpClient.get(
          url, new TypeReference<DeviceListBean>(){});
    } catch (Exception e) {
      e.printStackTrace();
      throw new PassageError("network error: failed to list devices for a Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID));
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to list devices for a Passage User", response.getStatusCode(),
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
  public boolean revokeUserDevice(String userID, String deviceID) throws PassageError{
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/devices/%s", appBean.getId(), userID,deviceID);
    HTTPResponse<ArrayList<DeviceBean>> response = null;
    try {
      response = passageHttpClient.delete(
          url, null);
    } catch (Exception e) {
      throw new PassageError("network error: failed to delete a device for a Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format("passage User with ID \"%s\" does not exist or Devices with ID \"%s\" does not exist", userID,deviceID),response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to delete a device for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return true;

  }

  /**
   * @param userID
   * @return
   */
  @Override
  public boolean signOut(String userID) throws PassageError {
    PassageHttpClient passageHttpClient = new PassageHttpClientImpl(appBean.getConfig().getApiKey());
    String url = String.format(PassageConstants.PASSAGE_BASE_URL + "/apps/%s/users/%s/token/", appBean.getId(), userID);
    HTTPResponse<HTTPError> response = null;
    try {
      response = passageHttpClient.delete(
          url, new TypeReference<HTTPError>(){});
    } catch (Exception e) {
      e.printStackTrace();
      throw new PassageError("network error: failed to revoke all refresh tokens for a Passage User");
    }
    if (response.getStatusCode() == 404) {
      throw new PassageError(String.format(UserBean.UserIDDoesNotExist, userID),response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    } else if (response.getStatusCode() != 200) {
      throw new PassageError("failed to revoke all refresh tokens for a Passage User", response.getStatusCode(),
          response.getStatusText(), response.getError().getErrorText());
    }
    return true;
  }
}
