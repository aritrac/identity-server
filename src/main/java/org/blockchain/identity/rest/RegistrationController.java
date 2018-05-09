package org.blockchain.identity.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public RegistrationResponse register(@RequestBody RegistrationInfo registrationInfo) {
        return new RegistrationResponse("randoimid", "vuberywceyufvybuevcuywefctevtewcvwetcvwyevwevuwc");
    }
}
