import aim.com.kr.jasypt.EncryptUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {EncryptUtils.class})
public class ConnectionErrorTest {

    @Value("${util.encrypt.passcode}")
    private String passcode;

    @Value("${util.encrypt.algorithm}")
    private String algorithm;

    @Test
    public void ValueTest() {
        System.out.println(passcode);
        System.out.println(algorithm);
    }

    @Test
    public void test() {
        System.out.println("ㄴㅁ아ㅣㅓㅁ니아ㅓㅁㄴㅇ");
    }

}
