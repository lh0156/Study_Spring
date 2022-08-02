package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
    매커니즘
    1. AutoAppConfig에 ComponentScan이 있네?
    2. Component로 되어있는거 다 뒤져
    3. 근데 Configuration에도 Component가 있음;; 그래서 excludeFilter로 걸러준 것
    4. 만약 의존관계가 있을 시에는 의존관계를 Autowired로 주입한다.

*/

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

/*
    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/
}