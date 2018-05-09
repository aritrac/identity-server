package org.blockchain.identity;

import org.blockchain.identity.feature.KeyUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdentityApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IdentityApplication.class, args);
		KeyUtils.StringKeyPair keyPair = KeyUtils.generateRSASHA256Certs();
		System.out.println(keyPair.getPrivateKey());
		System.out.println(keyPair.getPublicKey());
	}
}
