package hello.core.Component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentConfig.class);

        ComponentClass bean = ac.getBean(ComponentClass.class);

        bean.save();
    }

}
