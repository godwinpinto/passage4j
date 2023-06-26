package id.passageidentity.passage4j.core.app;

import id.passageidentity.passage4j.core.bean.CreateUserBodyBean;
import id.passageidentity.passage4j.core.bean.DeviceBean;
import id.passageidentity.passage4j.core.bean.UpdateBodyBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import java.util.List;

public interface User {

  UserBean getUser(String userID) throws PassageException;

  UserBean activateUser(String userID) throws PassageException;

  UserBean deactivateUser(String userID) throws PassageException;

  UserBean updateUser(String userID, UpdateBodyBean updateBody) throws PassageException;

  boolean deleteUser(String userID) throws PassageException;

  UserBean createUser(CreateUserBodyBean createUserBodyBean) throws PassageException;

  List<DeviceBean> listUserDevices(String userID) throws PassageException;

  boolean revokeUserDevice(String userID, String deviceID) throws PassageException;

  boolean signOut(String userID) throws PassageException;

}
