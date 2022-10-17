package encrypt.demo.service;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryptorUtils {

    public static String Encryptor(String message, String passcode, String algorithm) throws Exception {

        PooledPBEStringEncryptor encryptor = null;

        if (algorithm.equals("algorithm1")) {
            //PBEWithMD5AndDES 알고리즘 사용

            if (encryptor == null) {
                encryptor = new PooledPBEStringEncryptor();
            }

            SimpleStringPBEConfig config = new SimpleStringPBEConfig();
            config.setPassword(passcode);
            config.setAlgorithm("PBEWithMD5AndDES");
            config.setKeyObtentionIterations("1000");
            config.setPoolSize("1");
            config.setProviderName("SunJCE");
            config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
            config.setStringOutputType("base64");
            encryptor.setConfig(config);
            //test
            String isEncrypt = encryptor.encrypt(message);
            return isEncrypt;

        } else if (algorithm.equals("algorithm2")) {
            //PBEWithSHA256And128BitAES 알고리즘

            if (encryptor == null) {
                encryptor = new PooledPBEStringEncryptor();
            }

            encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC"); // 사용 알고리즘
            encryptor.setProvider(new BouncyCastleProvider());
            encryptor.setPoolSize(2); // 암호화 요청의 pool 크기. 2를 권장
            encryptor.setPassword(passcode); // 암호화 키

            String isEncrypt = encryptor.encrypt(message);
            return isEncrypt;

        } else if (algorithm.equals("algorithm3")){
            DESKeySpec desKeySpec = new DESKeySpec(passcode.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key key = keyFactory.generateSecret(desKeySpec);

            //그냥 Des인지 Triple Des 인지 에 따라 분기  passcode값이 24비트인경우 트리플 des로 앤크립트
            String instance = (passcode.length() == 24) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";

            Cipher cipher = Cipher.getInstance(instance);

            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] inputBytes = message.getBytes("UTF8");
            byte[] outputBytes = cipher.doFinal(inputBytes);

            String isEncrypt = Base64.getEncoder().encodeToString(outputBytes);
            return isEncrypt;

        } else {
            return "yml 내의 값이 유효하지 않습니다.";
        }
    }

}
