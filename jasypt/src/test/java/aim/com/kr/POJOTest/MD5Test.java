package aim.com.kr.POJOTest;

import org.junit.jupiter.api.Test;

import static aim.com.kr.jasypt.PojoJavaUtil.EncryptUtilPojo.decryptMD5;

public class MD5Test {

    @Test
    void MD5() {
        String message = "암호화 할 메세지입니다.";
        String isEncrypt = decryptMD5(message);

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);
    }

}
