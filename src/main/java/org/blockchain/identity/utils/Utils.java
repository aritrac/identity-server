package org.blockchain.identity.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class Utils {

    public static String generateRandomId() {
        return RandomStringUtils.randomAlphabetic(32);
    }

    public static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
