package aim.com.kr.jasypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppConfig {

    @Autowired
    Config config;

    @Bean
    public void test() {
        System.out.println(config.algorithm);

    }
}
