package id.passageidentity.passage4j.core;

import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
import id.passageidentity.passage4j.core.bean.AppInfoBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class PassageTest {


  static Passage passage;

  @BeforeAll
  static void setup() throws PassageException {
    PassageConfig config=new PassageConfig();
    config.setHeaderAuth(false);
    config.setApiKey(System.getenv("PASSAGE_API_KEY"));
    passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
  }

  @Test
  void testFlow() {

    try {


      AppInfoBean appInfoBean=passage.app().getInfo();
      System.out.println("-----------App Info------------");
      System.out.println(appInfoBean.toString());
/*    System.out.println("-----------Create Magic link------------");

      CreateMagicLinkBodyBean createMagicLinkBodyBean=new CreateMagicLinkBodyBean();
      createMagicLinkBodyBean.setChannel(ChannelTypeEnum.EMAIL);
      createMagicLinkBodyBean.setLanguage("en");
      createMagicLinkBodyBean.setMagicLinkPath("http://localhost:8080");
      createMagicLinkBodyBean.setEmail("passage@passage.com");
      createMagicLinkBodyBean.setTtl(300);
      createMagicLinkBodyBean.setRedirectUrl("http://localhost:8080/hello");
      MagicLinkBean magicLinkBean=psg.app().createMagicLink(createMagicLinkBodyBean);
      System.out.println(magicLinkBean.toString());
      System.out.println("-----------Create User------------");
      CreateUserBodyBean createUserBodyBean=new CreateUserBodyBean();
      createUserBodyBean.setEmail("passage@passage.com");
      createUserBodyBean.setPhone("+919999999997");
      UserBean userBean=psg.user().createUser(createUserBodyBean);
      System.out.println(userBean.toString());
      System.out.println("-----------Activate User------------");
      UserBean userBean2=psg.user().activateUser(userBean.getID());
      System.out.println(userBean2.toString());
      System.out.println("-----------Deactivate User------------");
      UserBean userBean3=psg.user().deactivateUser(userBean.getID());
      System.out.println(userBean3.toString());
*/
      System.out.println("-----------Get User------------");
      UserBean userBean4=passage.user().getInfo("1hp7aqZFFbHU6cws4cU8yoHO");
      System.out.println(userBean4.toString());
      /*
      System.out.println("-----------Update User------------");
      UpdateBodyBean updateBodyBean=new UpdateBodyBean();
      updateBodyBean.setPhone("+919999999990");
      UserBean userBean5=psg.user().updateUser(userBean.getID(),updateBodyBean);
      System.out.println(userBean5.toString());
      System.out.println("-----------Delete User------------");
      boolean status=psg.user().deleteUser(userBean.getID());
      System.out.println("user deleted request status:"+status);
*/
/*
      System.out.println("-----------List Devices------------");
      List<DeviceBean> listUserDevices=psg.user().listUserDevices("hLq1SpDYFNI6GOMWVjFiDo3f");
      System.out.println("listUserDevices:"+listUserDevices);
*/

/*      System.out.println("-----------Revoke Devices------------");
      boolean deviceRovokedStatus=psg.user().revokeUserDevice("hLq1SpDYFNI6GOMWVjFiDo3f","6768");
      System.out.println("deviceRovokedStatus:"+deviceRovokedStatus);*/

/*
      System.out.println("-----------Signout------------");
      boolean signOutStatus=psg.user().signOut("hLq1SpDYFNI6GOMWVjFiDo3f");
      System.out.println("signOutStatus:"+signOutStatus);
*/

    }catch(PassageException pe){
      System.out.println(pe.getMessage());
      pe.printStackTrace();
    }

  }

}
