package id.passageidentity.passage4j.core.app;

import com.nimbusds.jose.Header;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWT;
import id.passageidentity.passage4j.core.exception.PassageException;
import id.passageidentity.passage4j.core.util.PassageConstants;
import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manager class for Passage JWT key operations.
 */
final class PassageKeyManager {

  private static final Map<String, JWKSet> passageJWKCache = new HashMap<>();

  /**
   * Fetches the JWKS (JSON Web Key Set) for the specified app ID.
   *
   * @param appID the ID of the app
   * @throws PassageException if an error occurs while fetching the JWKS
   */
  public static void fetchJWKS(String appID) throws PassageException {
    JWKSet cachedJWKS = passageJWKCache.get(appID);
    if (cachedJWKS != null) {
      return;
    }
    try {
      URL jwksURL = new URL(String.format(PassageConstants.PASSAGE_JWKS_URL, appID));
      JWKSet jwkSet = JWKSet.load(jwksURL);
      passageJWKCache.put(appID, jwkSet);
    } catch (IOException | ParseException exception) {
      throw new PassageException("Failed to fetch JWKS");
    }
  }

  /**
   * Retrieves the public key for the specified app ID and JWT token.
   *
   * @param appID the ID of the app
   * @param token the JWT token
   * @return the RSA public key
   * @throws Exception if an error occurs while retrieving the public key
   */
  public static RSAPublicKey getPublicKey(String appID, JWT token) throws Exception {
    Header header = token.getHeader();
    if (!(header instanceof JWSHeader jse)) {
      throw new PassageException("Expecting JWS header");
    }
    String keyID = jse.getKeyID();
    if (keyID == null) {
      throw new Exception("Expecting JWT header to have a 'kid' string");
    }

    JWKSet jwkSet = passageJWKCache.get(appID);
    JWK key = jwkSet.getKeyByKeyId(keyID);
    if (key == null) {
      // Fetch JWKS and try again
      fetchJWKS(appID);
      jwkSet = passageJWKCache.get(appID);
      key = jwkSet.getKeyByKeyId(keyID);
      if (key == null) {
        throw new PassageException(String.format("Unable to find key '%s'", keyID));
      }
    }

    return ((RSAKey) key).toRSAPublicKey();
  }
}

