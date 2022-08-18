package hello.hellospring2;

import hello.hellospring2.controller.TestTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TestTest testTest() {
        return new TestTest();
    }


}
