package org.blockchain.identity.feature;

import org.blockchain.identity.blockchain.agent.AgentManager;
import org.blockchain.identity.rest.RegistrationInfo;
import org.blockchain.identity.utils.JwtUtils;
import org.blockchain.identity.utils.KeyUtils;
import org.blockchain.identity.utils.QRCodeGenerator;
import org.blockchain.identity.utils.Utils;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private AgentManager agentManager;

    public String getQrCodeForPartner(String jwtRequest) {
        try {
            JwtUtils.verifyJwt(jwtRequest, "PA", KeyUtils.getPublicKey(ServerKeys.getPartnerAppPublicKey()));
            String txId = Utils.generateTransactionId();
            TransactionRegistry.getInstance().put(txId, new Transaction(txId, ServerKeys.getPartnerId()));
            String qr = QRCodeGenerator.generateQRCodeImage("appId=" + ServerKeys.getPartnerId() + "&txId=" + txId);
            Map<String, String> claims = new HashMap<>();
            claims.put("qr", qr);
            claims.put("txId", txId);
            return JwtUtils.createJwtToken(ServerKeys.getPartnerId(), claims, KeyUtils
                    .getPrivateKey(ServerKeys.getServerPrivateKey()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String verifyTransaction(String jwtRequest) {
        try {
            JwtConsumer firstPassJwtConsumer = new JwtConsumerBuilder()
                    .setSkipAllValidators()
                    .setDisableRequireSignature()
                    .setSkipSignatureVerification()
                    .build();
            JwtContext jwtContext = firstPassJwtConsumer.process(jwtRequest);

            String userId = jwtContext.getJwtClaims().getSubject();
            RegistrationInfo info = UserRegistry.getInstance().get(userId);
            if(info != null) {
                JwtClaims claims = JwtUtils.verifyJwt(jwtRequest, "MO", KeyUtils.getPublicKey(info.getPublicKey()));

                String txId = claims.getStringClaimValue("txId");
                String appId = claims.getStringClaimValue("appId");

                Transaction transaction = TransactionRegistry.getInstance().get(txId);
                if(transaction != null) {
                    transaction.setUserId(userId);
                    TransactionRegistry.getInstance().put(txId, transaction);

                    Map<String, String> data = new HashMap<>();
                    data.put("partnerName", "Partner Application");
                    data.put("partnerUrl", "http://10.134.117.38:9000/receive");
                    data.put("requestedClaims", "email");
                    return JwtUtils.createJwtToken(userId, data, KeyUtils.getPrivateKey(ServerKeys.getServerPrivateKey()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String verifyUser(String jwtRequest) {
        try {
            JwtClaims claims = JwtUtils.verifyJwt(jwtRequest, "PA", KeyUtils.getPublicKey(ServerKeys
                    .getPartnerAppPublicKey()));
            String txId = claims.getStringClaimValue("txId");
            Transaction transaction = TransactionRegistry.getInstance().get(txId);
            if(transaction != null) {
                //RegistrationInfo info = UserRegistry.getInstance().get(transaction.getUserId());
                Map<String, String> data = new HashMap<>();
                String hash = claims.getStringClaimValue("hash");
                if(agentManager.verifyTransaction(hash)) {
                    data.put("verified", "true");
                }  else {
                    data.put("verified", "false");
                }
                return JwtUtils.createJwtToken(ServerKeys.getPartnerId(), data, KeyUtils.getPrivateKey(ServerKeys
                        .getServerPrivateKey()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
