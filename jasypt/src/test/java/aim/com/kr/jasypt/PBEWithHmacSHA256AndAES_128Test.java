package aim.com.kr.jasypt;

import org.junit.jupiter.api.Test;

import static aim.com.kr.jasypt.PojoJavaUtil.EncryptUtilPojo.decryptPBE;

public class PBEWithHmacSHA256AndAES_128Test {

    @Test
    void PEB() throws Exception {
        /*
            PBEWithHmacSHA256AndAES_128 알고리즘 사용
        */
        String message = "암호화 할 메세지입니다.";
        String isEncrypt = decryptPBE(message);

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);

    }

}
