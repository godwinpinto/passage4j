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

/**
 * UserImpl is an implementation of the User interface.
 */
class UserImpl implements User {

  final AppBean appBean;


  /**
   * Constructor for UserImpl class.
   *
   * @param appBean The AppBean object.
   */
  public UserImpl(AppBean appBean) {
    this.appBean = appBean;
  }

  /**
   * Retrieves the user information for the given userID.
   *
   * @param userID The ID of the user.
   * @return The UserBean object containing the user information.
   * @throws PassageException If there is an error retrieving the user info.
   */
  @Override
  public UserBean getInfo(String userID) throws PassageException {
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
   * Activates the user with the given userID.
   *
   * @param userID The ID of the user.
   * @return The UserBean object of the activated user.
   * @throws PassageException If there is an error activating the user.
   */
  @Override
  public UserBean activate(String userID) throws PassageException {
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
   * Deactivates the user with the given userID.
   *
   * @param userID The ID of the user.
   * @return The UserBean object of the deactivated user.
   * @throws PassageException If there is an error deactivating the user.
   */
  @Override
  public UserBean deactivate(String userID) throws PassageException {
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
   * Updates the user with the given userID using the provided updateBodyBean.
   *
   * @param userID          The ID of the user.
   * @param updateBodyBean  The UpdateBodyBean object containing the updated user attributes.
   * @return The UserBean object of the updated user.
   * @throws PassageException If there is an error updating the user attributes.
   */
  @Override
  public UserBean update(String userID, UpdateBodyBean updateBodyBean) throws PassageException {
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
   * Deletes the user with the given userID.
   *
   * @param userID The ID of the user.
   * @return True if the user is successfully deleted, false otherwise.
   * @throws PassageException If there is an error deleting the user.
   */
  @Override
  public boolean delete(String userID) throws PassageException {
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
   * Creates a new user using the provided createUserBodyBean.
   *
   * @param createUserBodyBean The CreateUserBodyBean object containing the user details.
   * @return The UserBean object of the created user.
   * @throws PassageException If there is an error creating the user.
   */
  @Override
  public UserBean create(CreateUserBodyBean createUserBodyBean) throws PassageException {
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
   * Retrieves the list of devices for the user with the given userID.
   *
   * @param userID The ID of the user.
   * @return The list of DeviceBean objects representing the user's devices.
   * @throws PassageException If there is an error retrieving the user's devices.
   */
  @Override
  public List<DeviceBean> listDevices(String userID) throws PassageException {
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
   * Revokes the device with the given deviceID for the user with the given userID.
   *
   * @param userID   The ID of the user.
   * @param deviceID The ID of the device to be revoked.
   * @return True if the device is successfully revoked, false otherwise.
   * @throws PassageException If there is an error revoking the device.
   */
  @Override
  public boolean revokeDevice(String userID, String deviceID) throws PassageException {
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
   * Signs out the user with the given userID by revoking all refresh tokens.
   *
   * @param userID The ID of the user.
   * @return True if all refresh tokens are successfully revoked, false otherwise.
   * @throws PassageException If there is an error revoking the refresh tokens.
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
