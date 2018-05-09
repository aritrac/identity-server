package org.blockchain.identity.rest;

import org.apache.commons.codec.digest.DigestUtils;
import org.blockchain.identity.feature.*;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public RegistrationResponse register(@RequestBody RegistrationInfo registrationInfo) {
        try {
            String id = Utils.generateRandomId();
            String hashedEmail = DigestUtils.sha256Hex(registrationInfo.getEmail());
            UserRegistry.getInstance().put(id, new RegistrationInfo(id, hashedEmail, registrationInfo.getPublicKey()));
            RegistrationResponse response = new RegistrationResponse(id, ServerKeys.getServerPublicKey());
            System.out.println("Returning: " + response.toString());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
