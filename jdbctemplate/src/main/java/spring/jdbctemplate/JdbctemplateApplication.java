package spring.jdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.jdbctemplate.configuration.AppConfig;
import spring.jdbctemplate.domain.MemberDto;
import spring.jdbctemplate.repository.MemberDao;

import java.util.List;

@SpringBootApplication
public class JdbctemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbctemplateApplication.class, args);
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberDao memberDao = ac.getBean("memberDao", MemberDao.class);

		List<MemberDto> members = memberDao.selectAll();

		for (MemberDto member : members) {

			System.out.println("이름 컬럼 = " + member.getMemberName());

		}
	}

}
