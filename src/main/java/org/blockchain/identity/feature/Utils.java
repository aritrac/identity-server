package org.blockchain.identity.feature;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String generateRandomId() {
        return RandomStringUtils.randomAlphabetic(32);
    }
}
