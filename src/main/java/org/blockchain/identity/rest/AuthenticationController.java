package org.blockchain.identity.rest;

import org.blockchain.identity.feature.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @RequestMapping(value = "/initiate", method = RequestMethod.POST)
    public String initiate(@RequestBody String payload) {
        return service.getQrCodeForPartner(payload);
    }

    @RequestMapping(value = "/verify-transaction", method = RequestMethod.POST)
    public String verifyTransaction(@RequestBody String payload) {
        return service.verifyTransaction(payload);
    }

    @RequestMapping(value = "/verify-user", method = RequestMethod.POST)
    public String verifyUser(@RequestBody String payload) {
        return service.verifyUser(payload);
    }
}
