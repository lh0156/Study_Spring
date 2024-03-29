package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        System.out.println("find prototypeBean1");
        prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);

        System.out.println("find prototypeBean2");
        prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

    }

    @Scope("prototype")
    static class prototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("prototypeBean.destory");
        }

    }

}
