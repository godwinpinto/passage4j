package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.bean.CreateUserBodyBean;
import id.passageidentity.passage4j.core.bean.DeviceBean;
import id.passageidentity.passage4j.core.bean.UpdateBodyBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import java.util.List;

/**
 * Interface representing user-related operations.
 */
public interface User {

  /**
   * Retrieves information about a user with the specified ID.
   *
   * @param userID the ID of the user
   * @return the UserBean containing the user information
   * @throws PassageException if an error occurs during the operation
   */
  UserBean getInfo(String userID) throws PassageException;

  /**
   * Activates a user with the specified ID.
   *
   * @param userID the ID of the user to activate
   * @return the UserBean containing the updated user information
   * @throws PassageException if an error occurs during the operation
   */
  UserBean activate(String userID) throws PassageException;

  /**
   * Deactivates a user with the specified ID.
   *
   * @param userID the ID of the user to deactivate
   * @return the UserBean containing the updated user information
   * @throws PassageException if an error occurs during the operation
   */
  UserBean deactivate(String userID) throws PassageException;

  /**
   * Updates a user with the specified ID using the provided update body.
   *
   * @param userID      the ID of the user to update
   * @param updateBody  the update body containing the new user information
   * @return the UserBean containing the updated user information
   * @throws PassageException if an error occurs during the operation
   */
  UserBean update(String userID, UpdateBodyBean updateBody) throws PassageException;

  /**
   * Deletes a user with the specified ID.
   *
   * @param userID the ID of the user to delete
   * @return true if the user is successfully deleted, false otherwise
   * @throws PassageException if an error occurs during the operation
   */
  boolean delete(String userID) throws PassageException;

  /**
   * Creates a new user using the provided create user body.
   *
   * @param createUserBodyBean the create user body containing the user information
   * @return the UserBean containing the created user information
   * @throws PassageException if an error occurs during the operation
   */
  UserBean create(CreateUserBodyBean createUserBodyBean) throws PassageException;

  /**
   * Retrieves the list of devices associated with the user with the specified ID.
   *
   * @param userID the ID of the user
   * @return the list of DeviceBean objects representing the user's devices
   * @throws PassageException if an error occurs during the operation
   */
  List<DeviceBean> listDevices(String userID) throws PassageException;

  /**
   * Revokes the device with the specified ID for the user with the specified ID.
   *
   * @param userID   the ID of the user
   * @param deviceID the ID of the device to revoke
   * @return true if the device is successfully revoked, false otherwise
   * @throws PassageException if an error occurs during the operation
   */
  boolean revokeDevice(String userID, String deviceID) throws PassageException;

  /**
   * Signs out the user with the specified ID.
   *
   * @param userID the ID of the user to sign out
   * @return true if the user is successfully signed out, false otherwise
   * @throws PassageException if an error occurs during the operation
   */
  boolean signOut(String userID) throws PassageException;
}
