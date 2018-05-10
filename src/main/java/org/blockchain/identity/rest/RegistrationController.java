package org.blockchain.identity.rest;

import org.apache.commons.codec.digest.DigestUtils;
import org.blockchain.identity.blockchain.agent.AgentManager;
import org.blockchain.identity.feature.*;
import org.blockchain.identity.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private AgentManager agentManager;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public RegistrationResponse register(@RequestBody RegistrationInfo registrationInfo) {
        try {
            String id = Utils.generateRandomId();
            String hashedEmail = DigestUtils.sha256Hex(registrationInfo.getEmail());
            agentManager.createBlock(agentManager.getAnyAgent().getName(), hashedEmail);
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
