package org.blockchain.identity.rest;

public class RegistrationResponse {

    private String id;
    private String serverPublicKey;

    public RegistrationResponse(String id, String serverPublicKey) {
        this.id = id;
        this.serverPublicKey = serverPublicKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerPublicKey() {
        return serverPublicKey;
    }

    public void setServerPublicKey(String serverPublicKey) {
        this.serverPublicKey = serverPublicKey;
    }
}
