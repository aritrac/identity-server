package org.blockchain.identity.utils;

import org.blockchain.identity.feature.UserRegistry;
import org.blockchain.identity.rest.RegistrationInfo;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.lang.JoseException;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

public class JwtUtils {

    public static String createJwtToken(String sub, Map<String, String> data, PrivateKey serverPrivateKey) {
        try {
            JwtClaims claims = new JwtClaims();
            claims.setIssuer("CA");;
            claims.setExpirationTimeMinutesInTheFuture(10);
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            claims.setNotBeforeMinutesInThePast(2);
            claims.setSubject(sub);

            data.forEach((key, value) -> claims.setStringClaim(key, value));

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

    public static JwtClaims verifyJwt(String jwt, String exceptedIssuer, PublicKey partnerPublicKey) {
        try {
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime() // the JWT must have an expiration time
                    .setAllowedClockSkewInSeconds(30) // allow some leeway in validating time based claims to account for clock skew
                    .setRequireSubject() // the JWT must have a subject claim
                    .setSkipDefaultAudienceValidation()
                    .setExpectedIssuer(exceptedIssuer) // whom the JWT needs to have been issued by
                    .setVerificationKey(partnerPublicKey) // verify the signature with the public key
                    .setJwsAlgorithmConstraints( // only allow the expected signature algorithm(s) in the given context
                            new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST, // which is only RS256 here
                                    AlgorithmIdentifiers.RSA_USING_SHA256))
                    .build(); // create the JwtConsumer instance
            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            return jwtClaims;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
