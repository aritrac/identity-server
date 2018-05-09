package org.blockchain.identity.feature;

import org.blockchain.identity.rest.RegistrationInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserRegistry {

    private Map<String, RegistrationInfo> userRegistry = new LinkedHashMap<>();

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
}
