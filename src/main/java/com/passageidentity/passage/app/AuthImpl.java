package com.passageidentity.passage.app;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.passageidentity.passage.app.AppBean;
import com.passageidentity.passage.app.Auth;
import com.passageidentity.passage.exception.PassageError;
import com.passageidentity.passage.util.PassageConstants;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException;

public class AuthImpl implements Auth {

  AppBean appBean;

  public AuthImpl(AppBean appBean) {
    this.appBean = appBean;
  }
  @Override
  public String authenticateRequest() {

    return "";
  }

  @Override
  public String authenticateRequestWithAuthHeader(String authorizationToken) throws PassageError{
    if (authorizationToken == null || authorizationToken.trim().equals("")) {
      throw new PassageError("missing authentication token: expected \"Bearer\" header");
    }
    return validateAuthToken(authorizationToken.trim());

  }

  @Override
  public String authenticateRequestWithCookie(String cookie_name_psg_auth_token) throws PassageError{
    if (cookie_name_psg_auth_token == null || cookie_name_psg_auth_token.equals("")) {
      throw new Error("missing authentication token: expected \"" + PassageConstants.AUTH_TOKEN_COOKIE_NAME + "\" cookie");
    }
    return validateAuthToken(cookie_name_psg_auth_token.trim());

  }

  @Override
  public String validateAuthToken(String authToken) throws PassageError{
    try {
      // Parse the JWT token
      JWT jwtToken = JWTParser.parse(authToken);

      // Verify the token using the public key
      if (!(jwtToken instanceof SignedJWT signedJWT)) {
        throw new PassageError("Invalid signed JWT token");
      }
      JWSVerifier verifier = new RSASSAVerifier(PassageKeyManager.getPublicKey(appBean.getId(), jwtToken));
      boolean isTokenVerified = signedJWT.verify(verifier);

      if (!isTokenVerified) {
        throw new PassageError("JWT token verification failed");
      }
      // Extract claims from the JWT
      JWTClaimsSet claimsSet = jwtToken.getJWTClaimsSet();
      String userID = claimsSet.getSubject();
      if (userID == null) {
        throw new PassageError("Claim 'sub' is not present");
      }

      return "";
    } catch (Exception e) {
      throw new PassageError(e.getMessage());
    }
  }
}
