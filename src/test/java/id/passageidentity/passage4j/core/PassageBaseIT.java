package id.passageidentity.passage4j.core;

import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
import id.passageidentity.passage4j.core.bean.AppInfoBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PassageBaseIT {


  static Passage passage;

/*  @BeforeAll
  static void setup() throws PassageException {
    PassageConfig config=new PassageConfig();
    config.setHeaderAuth(false);
    config.setApiKey(System.getenv("PASSAGE_API_KEY"));
    passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
  }*/

  @Test
  void testEmptyAppIdAndConfig()  {
    Exception exception = assertThrows(PassageException.class, () -> {
      new PassageNew(null, null);
    });
    String expectedMessage = "Passage Error - , message: Failed to fetch JWKS";
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  void testInvalidAppId()  {
    Exception exception = assertThrows(PassageException.class, () -> {
      new PassageNew("HELLO", null);
    });
    String expectedMessage = "Passage Error - , message: Failed to fetch JWKS";
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);
  }
  @Test
  void testValidAppIdAndEmptyConfig()  {
    assertDoesNotThrow(() -> {
      new PassageNew(System.getenv("PASSAGE_APP_ID"), null);
    });
  }

  @Test
  void testValidAppIdAndWrongApiKey()  {
    PassageConfig config=new PassageConfig();
    config.setHeaderAuth(false);
    assertDoesNotThrow(() -> {
      new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
    });
  }
  @Test
  void testValidAppIdAndCorrectApiKey()  {
    PassageConfig config=new PassageConfig();
    config.setHeaderAuth(false);
    config.setApiKey(System.getenv("PASSAGE_API_KEY"));
    assertDoesNotThrow(() -> {
      new PassageNew(System.getenv("PASSAGE_APP_ID"), config);
    });
  }
}
