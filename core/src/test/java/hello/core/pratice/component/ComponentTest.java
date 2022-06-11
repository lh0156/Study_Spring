package hello.core.pratice.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    @Autowired
    private Autowired autoInstance;

    public static void main(String[] args) {


        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentConfig.class);

        ComponentClass bean = ac.getBean(ComponentClass.class);

        bean.save();
        bean.join();
    }

}
