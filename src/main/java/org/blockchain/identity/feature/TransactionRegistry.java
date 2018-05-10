package org.blockchain.identity.feature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionRegistry {

    private Map<String, Transaction> registry = new ConcurrentHashMap<>();

    private TransactionRegistry() {}

    private static class TransactionRegistryHelper {
        private static final TransactionRegistry INSTANCE = new TransactionRegistry();
    }

    public static TransactionRegistry getInstance() {
        return TransactionRegistryHelper.INSTANCE;
    }

    public void put(String txId, Transaction transaction) {
        registry.put(txId, transaction);
    }

    public Transaction get(String txId) {
        return registry.get(txId);
    }
}
