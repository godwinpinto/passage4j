package com.passageidentity.passage.example;

import com.passageidentity.passage.app.Passage;
import com.passageidentity.passage.app.PassageConfig;
import com.passageidentity.passage.app.PassageNew;
import com.passageidentity.passage.app.bean.AppInfoBean;
import com.passageidentity.passage.app.bean.ChannelTypeEnum;
import com.passageidentity.passage.app.bean.CreateMagicLinkBodyBean;
import com.passageidentity.passage.app.bean.CreateUserBodyBean;
import com.passageidentity.passage.app.bean.DeviceBean;
import com.passageidentity.passage.app.bean.MagicLinkBean;
import com.passageidentity.passage.app.bean.UpdateBodyBean;
import com.passageidentity.passage.app.bean.UserBean;
import com.passageidentity.passage.exception.PassageError;
import java.util.ArrayList;
import java.util.List;

public class PassageRunExample {

  public static void main(String[] args) {
    PassageConfig config=new PassageConfig();
    config.setHeaderAuth(false);
    config.setApiKey(System.getenv("PASSAGE_API_KEY"));

    try {
      Passage psg = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);

/*
      AppInfoBean appInfoBean=psg.app().getInfo();
      System.out.println("-----------App Info------------");
      System.out.println(appInfoBean.toString());
      System.out.println("-----------Create Magic link------------");

      CreateMagicLinkBodyBean createMagicLinkBodyBean=new CreateMagicLinkBodyBean();
      createMagicLinkBodyBean.setChannel(ChannelTypeEnum.EMAIL);
      createMagicLinkBodyBean.setLanguage("en");
      createMagicLinkBodyBean.setMagicLinkPath("http://localhost:8080");
      createMagicLinkBodyBean.setEmail("godwin.pinto86@gmail.com");
      createMagicLinkBodyBean.setTtl(300);
      createMagicLinkBodyBean.setRedirectUrl("http://localhost:8080/hello");
      MagicLinkBean magicLinkBean=psg.app().createMagicLink(createMagicLinkBodyBean);
      System.out.println(magicLinkBean.toString());
      System.out.println("-----------Create User------------");
      CreateUserBodyBean createUserBodyBean=new CreateUserBodyBean();
      createUserBodyBean.setEmail("godwin.pinto3@cmss.in");
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
      UserBean userBean4=psg.user().getUser("hLq1SpDYFNI6GOMWVjFiDo3f");
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
      System.out.println("-----------List Devices------------");
      List<DeviceBean> listUserDevices=psg.user().listUserDevices("hLq1SpDYFNI6GOMWVjFiDo3f");
      System.out.println("listUserDevices:"+listUserDevices);

/*      System.out.println("-----------Revoke Devices------------");
      boolean deviceRovokedStatus=psg.user().revokeUserDevice("hLq1SpDYFNI6GOMWVjFiDo3f","6768");
      System.out.println("deviceRovokedStatus:"+deviceRovokedStatus);*/

      System.out.println("-----------Signout------------");
      boolean signOutStatus=psg.user().signOut("hLq1SpDYFNI6GOMWVjFiDo3f");
      System.out.println("signOutStatus:"+signOutStatus);

    }catch(PassageError pe){
      System.out.println(pe.getMessage());
      pe.printStackTrace();
    }

  }

}
