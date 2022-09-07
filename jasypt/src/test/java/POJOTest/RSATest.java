package POJOTest;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import static PojoJavaUtil.EncryptUtil.*;

public class RSATest {

    @Test
    void RSA() throws Exception {
        //Key를 얻는다
        KeyPair keyPair = getRSAKeyPair();

        String message = "암호화 할 메세지입니다.";
        String isEncrypt = encryptRSA(message, keyPair.getPublic());
        String isDecrypt = decryptRSA(isEncrypt, keyPair.getPrivate());

        System.out.println("원문 메세지: " + message);
        System.out.println("암호화 메세지: " + isEncrypt);
        System.out.println("복호화 메세지: " + isDecrypt);
    }

}
