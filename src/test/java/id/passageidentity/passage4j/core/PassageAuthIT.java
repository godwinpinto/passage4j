package id.passageidentity.passage4j.core;

import id.passageidentity.passage4j.core.app.Passage;
import id.passageidentity.passage4j.core.app.PassageConfig;
import id.passageidentity.passage4j.core.app.PassageNew;
import id.passageidentity.passage4j.core.bean.AppInfoBean;
import id.passageidentity.passage4j.core.bean.UserBean;
import id.passageidentity.passage4j.core.exception.PassageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PassageAuthIT {


  static Passage passage;

  @BeforeAll
  static void setup() throws PassageException {
    passage = new PassageNew(System.getenv("PASSAGE_APP_ID"), null);
  }

  @Test
  void testAuthenticateHeaderInvalidToken() throws PassageException {
    PassageException passageException= Assertions.assertThrows(PassageException.class,()->{
      passage.auth().authenticateRequestWithAuthHeader("Bearer XXXXX");
    });
    assertEquals(401,passageException.getStatusCode());
  }

  @Test
  void testAuthenticateHeaderNoBearer() throws PassageException {
    PassageException passageException= Assertions.assertThrows(PassageException.class,()->{
      passage.auth().authenticateRequestWithAuthHeader("");
    });
    assertEquals(401,passageException.getStatusCode());
  }

  @Test
  void testAuthenticateNoCookie() throws PassageException {
    PassageException passageException= Assertions.assertThrows(PassageException.class,()->{
      passage.auth().authenticateRequestWithCookie("");
    });
    assertEquals(401,passageException.getStatusCode());
  }

  @Test
  void testAuthenticateWrongCookie() throws PassageException {
    PassageException passageException= Assertions.assertThrows(PassageException.class,()->{
      passage.auth().authenticateRequestWithCookie("XXXXX");
    });
    assertEquals(401,passageException.getStatusCode());
  }
  @Test
  void testAuthenticateValidCookieToken() throws PassageException {
    assertDoesNotThrow(()->{
      String userID=passage.auth().authenticateRequestWithCookie(System.getenv("PASSAGE_USER_TOKEN"));
    });
  }
  @Test
  void testAuthenticateValidHeaderToken() throws PassageException {
    assertDoesNotThrow(()->{
      String userID=passage.auth().authenticateRequestWithAuthHeader("Bearer "+System.getenv("PASSAGE_USER_TOKEN"));
    });
  }
}
