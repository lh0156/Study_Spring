package aim.com.kr.jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class JasyptApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(JasyptApplication.class, args);

		ApplicationContext ac = new AnnotationConfigApplicationContext(EncryptUtil.class);
		EncryptUtil bean = ac.getBean(EncryptUtil.class);

		bean.Encryptor("테스트");


	}

}

