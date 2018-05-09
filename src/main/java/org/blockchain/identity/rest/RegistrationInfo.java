package org.blockchain.identity.rest;

import java.io.Serializable;

public class RegistrationInfo implements Serializable {
    private String id;
    private String email;
    private String publicKey;

    public RegistrationInfo() {}

    public RegistrationInfo(String id, String email, String publicKey) {
        this.id = id;
        this.email = email;
        this.publicKey = publicKey;
    }

    public String getEmail() {
        return email;
    }

    public String getPublicKey() {
        return publicKey;
    }
}
