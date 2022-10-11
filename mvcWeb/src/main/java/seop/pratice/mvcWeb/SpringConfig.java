package seop.pratice.mvcWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seop.pratice.mvcWeb.repository.JdbcMemberRepository;
import seop.pratice.mvcWeb.repository.MemberRepository;
import seop.pratice.mvcWeb.repository.MemoryMemberRepository;
import seop.pratice.mvcWeb.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}