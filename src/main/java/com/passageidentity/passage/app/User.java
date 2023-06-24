package com.passageidentity.passage.app;

import com.passageidentity.passage.app.bean.CreateUserBodyBean;
import com.passageidentity.passage.app.bean.DeviceBean;
import com.passageidentity.passage.app.bean.UpdateBodyBean;
import com.passageidentity.passage.app.bean.UserBean;
import com.passageidentity.passage.exception.PassageError;
import java.util.ArrayList;
import java.util.List;

public interface User {

    UserBean getUser(String userID) throws PassageError;
		UserBean activateUser(String userID) throws PassageError;
		UserBean deactivateUser(String userID) throws PassageError;
		UserBean updateUser(String userID, UpdateBodyBean updateBody ) throws PassageError;
		boolean deleteUser(String userID) throws PassageError;
		UserBean createUser(CreateUserBodyBean createUserBodyBean) throws PassageError;
		List<DeviceBean> listUserDevices(String userID) throws PassageError;
		boolean revokeUserDevice(String userID, String deviceID) throws PassageError;
		boolean signOut(String userID) throws PassageError;

}
