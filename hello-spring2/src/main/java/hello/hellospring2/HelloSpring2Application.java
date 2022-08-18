package hello.hellospring2;

import hello.hellospring2.controller.TestTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HelloSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpring2Application.class, args);
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		TestTest bean = ac.getBean("testTest", TestTest.class);
		bean.console();
	}

}
