package id.passageidentity.passage4j.core;

import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
import id.passageidentity.passage4j.core.bean.CreateUserBodyBean;
import id.passageidentity.passage4j.core.bean.DeviceBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.bean.UserStatusEnum;
import id.passageidentity.passage4j.core.constants.PassageTestConstants;
import id.passageidentity.passage4j.core.exception.PassageException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PassageUserIT {

    static Passage passage;

    @BeforeAll
    static void setup() throws PassageException {
        PassageConfig config = new PassageConfig();
        config.setHeaderAuth(false);
        config.setApiKey(System.getenv("PASSAGE_API_KEY"));
        passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
    }

    @Test
    void testUserInfoWithoutApiKey() throws PassageException {
        PassageConfig config = new PassageConfig();
        Passage passage1 = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
        PassageException passageException = assertThrows(PassageException.class, () -> {
            UserBean userBean = passage1.user().getInfo(System.getenv("PASSAGE_APP_USER_ID"));
        });
        assertEquals(401, passageException.getStatusCode());
    }

    @Test
    void testUserInfoWithApiKey() throws PassageException {
        PassageConfig config = new PassageConfig();
        config.setApiKey(System.getenv("PASSAGE_API_KEY"));
        Passage passage1 = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
        assertDoesNotThrow(() -> {
            UserBean userBean = passage1.user().getInfo(System.getenv("PASSAGE_APP_USER_ID"));
            assertEquals(userBean.getID(), System.getenv("PASSAGE_APP_USER_ID"));
        });
    }

    @Test
    void testUserOperations() throws PassageException {
        CreateUserBodyBean bean = new CreateUserBodyBean();
        bean.setEmail(System.getenv(PassageTestConstants.DUMMY_EMAIL_FOR_FULL_CYCLE));
//    bean.setPhone(PassageTestConstants.DUMMY_PHONE);
/*    Map<String,Object> mapMetaData=new HashMap<String,Object>();
    mapMetaData.put("address",PassageTestConstants.DUMMY_ADDRESS);
    bean.setUserMetadata(mapMetaData);*/
        UserBean userBean = passage.user().create(bean);
        assertEquals(userBean.getEmail(), System.getenv(PassageTestConstants.DUMMY_EMAIL_FOR_FULL_CYCLE));
        assertEquals(userBean.getStatus(), UserStatusEnum.PENDING);
        UserBean userBeanActivate = passage.user().activate(userBean.getID());
        assertEquals(userBean.getID(), userBeanActivate.getID());
        assertEquals(userBeanActivate.getStatus(), UserStatusEnum.ACTIVE);
        UserBean userBeanDeactivate = passage.user().deactivate(userBean.getID());
        assertEquals(userBean.getID(), userBeanDeactivate.getID());
        assertEquals(userBeanDeactivate.getStatus(), UserStatusEnum.INACTIVE);
        assertDoesNotThrow(()->{
            List<DeviceBean> deviceBeanList=passage.user().listDevices(userBean.getID());
            assertEquals(0,deviceBeanList.size());
        });

        boolean deleteStatus = passage.user().delete(userBean.getID());
        assertTrue(deleteStatus);
        PassageException passageException = assertThrows(PassageException.class, () -> {
            UserBean userBeanDeleted = passage.user().getInfo(userBean.getID());
        });
        assertEquals(404, passageException.getStatusCode());
    }

    @Test
    void testDeactivateUnknownUser() throws PassageException {
        PassageException passageException=assertThrows(PassageException.class,() -> {
            UserBean userBean = passage.user().deactivate(PassageTestConstants.DUMMY_NOT_VALID_USER_ID);
        });
        assertEquals(404,passageException.getStatusCode());
    }
    @Test
    void testActivateUnknownUser() throws PassageException {
        PassageException passageException=assertThrows(PassageException.class,() -> {
            UserBean userBean = passage.user().activate(PassageTestConstants.DUMMY_NOT_VALID_USER_ID);
        });
        assertEquals(404,passageException.getStatusCode());
    }
    @Test
    void testDeleteUnknownUser() throws PassageException {
        PassageException passageException=assertThrows(PassageException.class,() -> {
            boolean status  = passage.user().delete(PassageTestConstants.DUMMY_NOT_VALID_USER_ID);
        });
        assertEquals(404,passageException.getStatusCode());
    }

    @Test
    void testCreateFailure() throws PassageException {
        CreateUserBodyBean bean = new CreateUserBodyBean();
        bean.setEmail("");
        PassageException passageException=assertThrows(PassageException.class,() -> {
            UserBean userBean = passage.user().create(bean);
        });
        assertEquals(400,passageException.getStatusCode());
    }
    @Test
    void testCreateUserExists() throws PassageException {
        CreateUserBodyBean bean = new CreateUserBodyBean();
        bean.setEmail(System.getenv(PassageTestConstants.DUMMY_EMAIL_EXISTS));
        PassageException passageException=assertThrows(PassageException.class,() -> {
            UserBean userBean = passage.user().create(bean);
        });
        assertEquals(400, passageException.getStatusCode());
    }
    @Test
    void testUserInfoEmptyUserID() throws PassageException {
        PassageException passageException = assertThrows(PassageException.class, () -> {
            UserBean userBean = passage.user().getInfo("");
        });
        assertEquals(400, passageException.getStatusCode());
    }
    @Test
    void testRevokeUnknownDevice() throws PassageException {
        PassageException passageException = assertThrows(PassageException.class, () -> {
                    boolean revokeStatus = passage.user().revokeDevice(System.getenv("PASSAGE_APP_USER_ID"), "XXXXX");
                });
        assertEquals(404,passageException.getStatusCode());
    }

    @Test
    void testDeviceRevokeSuccess() throws PassageException {
        List<DeviceBean> deviceBeanList=passage.user().listDevices(System.getenv("PASSAGE_APP_USER_ID"));
        if(deviceBeanList!=null && deviceBeanList.size()!=0) {
            assertDoesNotThrow(()->{
                boolean revokeDeviceStatus = passage.user().revokeDevice(System.getenv("PASSAGE_APP_USER_ID"),deviceBeanList.get(0).getID());
                assertTrue(revokeDeviceStatus);
            });
        }
    }

    @Test
    void testSignOutUnknownUser() throws PassageException{
        PassageException passageException = assertThrows(PassageException.class, () -> {
            passage.user().signOut("XXXXX");
        });
        assertEquals(404,passageException.getStatusCode());
    }
    @Test
    void testSignOutUserExists() throws PassageException{
        boolean isSignOut=passage.user().signOut(System.getenv("PASSAGE_APP_USER_ID"));
        assertTrue(isSignOut);
    }
}
