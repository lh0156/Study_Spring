package aim.com.kr.jasypt;

import jasypt.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(Config.class)
public class JasyptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasyptApplication.class, args);




	}



}

