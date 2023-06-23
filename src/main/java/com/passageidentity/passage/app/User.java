package com.passageidentity.passage.app;

import com.passageidentity.passage.app.bean.CreateUserBodyBean;
import com.passageidentity.passage.app.bean.DeviceBean;
import com.passageidentity.passage.app.bean.UpdateBodyBean;
import com.passageidentity.passage.app.bean.UserBean;
import com.passageidentity.passage.exception.PassageError;
import java.util.ArrayList;

public interface User {

    public UserBean getUser(String userID) throws PassageError;
		public UserBean activateUser(String userID) throws PassageError;
		public UserBean deactivateUser(String userID) throws PassageError;
		public UserBean updateUser(String userID, UpdateBodyBean updateBody ) throws PassageError;
		public boolean deleteUser(String userID) throws PassageError;
		public UserBean createUser(CreateUserBodyBean createUserBodyBean) throws PassageError;
		public ArrayList<DeviceBean> listUserDevices(String userID) throws PassageError;
		public boolean revokeUserDevice(String userID, String deviceID) throws PassageError;
		public boolean signOut(String userID) throws PassageError;

}
