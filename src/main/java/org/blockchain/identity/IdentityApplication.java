package org.blockchain.identity;

import org.blockchain.identity.utils.KeyUtils;
import org.blockchain.identity.utils.QRCodeGenerator;
import org.blockchain.identity.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityApplication.class, args);
		/*System.out.println(QRCodeGenerator.generateQRCodeImage("appId=" + Utils.generateRandomId() + "&txId=" + Utils
				.generateTransactionId()));*/
	}
}
