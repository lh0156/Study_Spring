package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        int price = statefulService1.order("userA", 10000);
        //ThreadB : B사용자 20000원 주문
        int price2 = statefulService2.order("userA", 20000);

        //ThreadA: 사용자A 주문 금액 조회

        System.out.println("price = " + price);

        System.out.println("price2 = " + price2);


        //왜 pricesms 20000원이 나오냐?;;;
        //instance를 같은 애를 써서 이런 문제가 나옴

        Assertions.assertThat(price).isNotEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }
}