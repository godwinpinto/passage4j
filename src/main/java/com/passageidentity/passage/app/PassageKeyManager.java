package com.passageidentity.passage.app;

import com.nimbusds.jose.Header;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWT;
import com.passageidentity.passage.exception.PassageError;
import com.passageidentity.passage.util.PassageConstants;
import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public final class PassageKeyManager {

  private static final Map<String, JWKSet> passageJWKCache=new HashMap<String,JWKSet>();

  public static JWKSet fetchJWKS(String appID) throws PassageError {
    JWKSet cachedJWKS = passageJWKCache.get(appID);
    if (cachedJWKS != null) {
      return cachedJWKS;
    }
    try {
      URL jwksURL = new URL(String.format(PassageConstants.PASSAGE_JWKS_URL, appID));
      JWKSet jwkSet = JWKSet.load(jwksURL);
      passageJWKCache.put(appID, jwkSet);
      return jwkSet;
    }catch(IOException | ParseException exception){
      throw new PassageError("failed to fetch jwks");
    }
  }

  public static RSAPublicKey getPublicKey(String appID, JWT token) throws Exception {
    Header header = token.getHeader();
    if (!(header instanceof JWSHeader jse)) {
      throw new PassageError("Expecting JWS header");
    }
    JWSHeader jwsHeader = (JWSHeader) header;
    String keyID = jwsHeader.getKeyID();
    if (keyID == null) {
      throw new Exception("Expecting JWT header to have a 'kid' string");
    }

    JWKSet jwkSet = passageJWKCache.get(appID);
    JWK key = jwkSet.getKeyByKeyId(keyID);
    if (key == null) {
      // Fetch JWKS and try again
      fetchJWKS(appID);
      key = jwkSet.getKeyByKeyId(keyID);
      if (key == null) {
        throw new PassageError(String.format("Unable to find key '%s'", keyID));
      }
    }

    RSAPublicKey publicKey = ((RSAKey) key).toRSAPublicKey();
    return publicKey;
  }

}
