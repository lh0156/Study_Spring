package aim.com.kr.jasypt;

import aim.com.kr.jasypt.PojoJavaUtil.EncryptUtilPojo;
import org.junit.jupiter.api.Test;

import java.security.Key;

import static aim.com.kr.jasypt.PojoJavaUtil.EncryptUtilPojo.decryptDES;

public class DESTest {

    @Test
    void DES() throws Exception {
        Key key = EncryptUtilPojo.getKey();

        String message = "암호화 할 메세지입니다.";
        String isEncrypt = decryptDES(key, message);

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);
    }

}
