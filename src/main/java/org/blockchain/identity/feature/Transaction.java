package org.blockchain.identity.feature;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String txId;
    private String userId;
    private String partnerId;
    private boolean completed;

    public Transaction(String txId, String partnerId) {
        this.txId = txId;
        this.partnerId = partnerId;
    }

    public String getTxId() {
        return txId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
