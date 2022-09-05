import jasypt.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest(classes = YmlReadTest.class)
public class YmlReadTest {



    @Test
    void Test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Config bean = ac.getBean(Config.class);
        String environment = bean.environment;
        String algorithm = bean.algorithm;

        System.out.println(environment);
        System.out.println(algorithm);

    }

}
