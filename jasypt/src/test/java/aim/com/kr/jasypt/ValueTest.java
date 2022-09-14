package aim.com.kr.jasypt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValueTest {

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
    public void generalTest() {
        System.out.println("테스트");
    }

}
