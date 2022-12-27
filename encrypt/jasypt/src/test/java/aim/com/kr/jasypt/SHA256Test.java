package aim.com.kr.jasypt;

import aim.com.kr.jasypt.PojoJavaUtil.EncryptUtilPojo;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class SHA256Test {

    @Test
    void SHA256() throws NoSuchAlgorithmException {
        String message = "암호화 할 메세지입니다.";
        String isEncrypt = EncryptUtilPojo.decryptSHA256(message);

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);
    }
}
