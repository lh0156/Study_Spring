package encrypt.demo.service;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.util.Base64;

@Service
public class EncryptorUtils {

    public static String Encryptor(String message, String passcode, String algorithm) throws Exception {

        PooledPBEStringEncryptor encryptor = null;

        switch (algorithm) {
            case "algorithm1": {
                //PBEWithMD5AndDES 알고리즘 사용

                encryptor = new PooledPBEStringEncryptor();

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
                return encryptor.encrypt(message);

            }
            case "algorithm2": {
                //PBEWithSHA256And128BitAES 알고리즘

                encryptor = new PooledPBEStringEncryptor();

                encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC"); // 사용 알고리즘

                encryptor.setProvider(new BouncyCastleProvider());
                encryptor.setPoolSize(2); // 암호화 요청의 pool 크기. 2를 권장

                encryptor.setPassword(passcode); // 암호화 키


                return encryptor.encrypt(message);

            }
            default:
                return "yml 내의 값이 유효하지 않습니다.";
        }
    }

}
