package org.blockchain.identity.feature;

import org.blockchain.identity.rest.RegistrationInfo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRegistry {

    private Map<String, RegistrationInfo> userRegistry = new ConcurrentHashMap<>();

    private UserRegistry() {}

    private static class UserRegistryHelper {
        private static UserRegistry INSTANCE = new UserRegistry();
    }

    public static UserRegistry getInstance() {
        return UserRegistryHelper.INSTANCE;
    }

    public void put(String id, RegistrationInfo registrationInfo) {
        userRegistry.put(id, registrationInfo);
    }

    public RegistrationInfo get(String id) {
        return userRegistry.get(id);
    }
}
