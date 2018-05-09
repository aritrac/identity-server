package org.blockchain.identity.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @RequestMapping(value = "/initiate", method = RequestMethod.POST)
    public String initiate(@RequestBody String payload) {
        return null;
    }
}
