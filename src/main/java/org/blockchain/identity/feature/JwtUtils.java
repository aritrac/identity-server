package org.blockchain.identity.feature;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;

import java.security.PrivateKey;

public class JwtUtils {

    public static String createJwtToken(String userId, String serverPublicKey, PrivateKey serverPrivateKey) {
        try {
            JwtClaims claims = new JwtClaims();
            claims.setIssuer("CA");
            claims.setAudience(userId);
            claims.setExpirationTimeMinutesInTheFuture(10);
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            claims.setNotBeforeMinutesInThePast(2);
            claims.setSubject(userId);
            claims.setStringClaim("id", userId);
            claims.setStringClaim("serverPublicKey", serverPublicKey);

            JsonWebSignature jws = new JsonWebSignature();
            jws.setPayload(claims.toJson());
            jws.setKey(serverPrivateKey);

            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

            String jwt = jws.getCompactSerialization();
            return jwt;
        } catch (JoseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
