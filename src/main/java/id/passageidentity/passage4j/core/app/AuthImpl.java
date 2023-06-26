package id.passageidentity.passage4j.core.app;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import id.passageidentity.passage4j.core.exception.PassageException;
import id.passageidentity.passage4j.core.util.PassageConstants;

class AuthImpl implements Auth {

  private final AppBean appBean;

  public AuthImpl(AppBean appBean) {
    this.appBean = appBean;
  }

  @Override
  public String authenticateRequestWithAuthHeader(String authorizationToken) throws PassageException {
    if (authorizationToken == null || authorizationToken.trim().equals("") || !authorizationToken.startsWith(
        "Bearer")) {
      throw new PassageException("missing authentication token: expected \"Bearer\" header");
    }
    return validateAuthToken(authorizationToken.substring("Bearer".length()).trim());
  }

  @Override
  public String authenticateRequestWithCookie(String cookie_name_psg_auth_token) throws PassageException {
    if (cookie_name_psg_auth_token == null || cookie_name_psg_auth_token.equals("")) {
      throw new Error(
          "missing authentication token: expected \"" + PassageConstants.AUTH_TOKEN_COOKIE_NAME + "\" cookie");
    }
    return validateAuthToken(cookie_name_psg_auth_token.trim());

  }

  @Override
  public String validateAuthToken(String authToken) throws PassageException {
    try {
      // Parse the JWT token
      JWT jwtToken = JWTParser.parse(authToken);

      // Verify the token using the public key
      if (!(jwtToken instanceof SignedJWT signedJWT)) {
        throw new PassageException("Invalid signed JWT token");
      }
      JWSVerifier verifier = new RSASSAVerifier(PassageKeyManager.getPublicKey(appBean.getId(), jwtToken));
      boolean isTokenVerified = signedJWT.verify(verifier);

      if (!isTokenVerified) {
        throw new PassageException("JWT token verification failed");
      }
      // Extract claims from the JWT
      JWTClaimsSet claimsSet = jwtToken.getJWTClaimsSet();
      String userID = claimsSet.getSubject();
      if (userID == null) {
        throw new PassageException("Claim 'sub' is not present");
      }

      return userID;
    } catch (Exception e) {
      throw new PassageException(e.getMessage());
    }
  }
}
