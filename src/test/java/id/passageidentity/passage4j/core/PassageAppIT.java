package id.passageidentity.passage4j.core;

import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
import id.passageidentity.passage4j.core.bean.*;
import id.passageidentity.passage4j.core.constants.PassageTestConstants;
import id.passageidentity.passage4j.core.exception.PassageException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PassageAppIT {

  @BeforeAll
  static void setup(){
  }


  @Test
  void testAppInfoWithoutApiKey()  throws PassageException{
    PassageConfig config=new PassageConfig();
    Passage passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
    assertDoesNotThrow(()->{
      AppInfoBean appInfoBean=passage.app().getInfo();
      assertEquals(appInfoBean.getId(),System.getenv("PASSAGE_APP_ID"));
    });
  }

  @Test
  void testAppInfoWithApiKey()  throws PassageException{
    PassageConfig config=new PassageConfig();
    config.setApiKey(System.getenv("PASSAGE_API_KEY"));
    Passage passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
    assertDoesNotThrow(()->{
      AppInfoBean appInfoBean=passage.app().getInfo();
      assertEquals(appInfoBean.getId(),System.getenv("PASSAGE_APP_ID"));
    });
  }

  @Test
  void testCreateMagicLinkWithoutApiKey() throws PassageException{
    PassageConfig config=new PassageConfig();
    Passage passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);

    CreateMagicLinkBodyBean inputBean=new CreateMagicLinkBodyBean();
    inputBean.setChannel(ChannelTypeEnum.EMAIL);
    inputBean.setEmail(System.getenv(PassageTestConstants.DUMMY_EMAIL_FOR_MAGIC_LINK));
    inputBean.setTtl(30);
    PassageException exception = assertThrows(PassageException.class,()->{
      MagicLinkBean outputBean=passage.app().createMagicLink(inputBean);
    });
   assertEquals(401,exception.getStatusCode());
  }
  @Test
  void testCreateMagicLinkWithApiKey() throws PassageException{
    PassageConfig config=new PassageConfig();
    config.setApiKey(System.getenv("PASSAGE_API_KEY"));
    Passage passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
    CreateMagicLinkBodyBean inputBean=new CreateMagicLinkBodyBean();
    inputBean.setChannel(ChannelTypeEnum.EMAIL);
    inputBean.setEmail(System.getenv(PassageTestConstants.DUMMY_EMAIL_FOR_MAGIC_LINK));
    inputBean.setTtl(30);
    assertDoesNotThrow(()->{
      MagicLinkBean outputBean=passage.app().createMagicLink(inputBean);
      assertEquals(outputBean.getIdentifier(),inputBean.getEmail());
      assertEquals(outputBean.getTtl(),inputBean.getTtl());
      assertNotNull(outputBean.getUrl());
      assertNotNull(outputBean.getSecret());
      assertNotNull(outputBean.getUserId());
    });
  }
}
