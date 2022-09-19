package test.spring.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 추가
@Slf4j
public class SchedulerApplication {



	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
		log.info("테스트");
		methodSample();

	}

	public static void methodSample() {
		log.info("샘플 메소드 시행");
	}

}
