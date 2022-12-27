package encrypt.demo;

import encrypt.demo.service.EncryptorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static encrypt.demo.service.EncryptorUtils.Encryptor;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EncryptorUtils encryptorUtils;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		try {
//			String temp = Encryptor("asdasdasd", "assdasda", "algorithm3");
//			System.out.println(temp);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}


	}

}
