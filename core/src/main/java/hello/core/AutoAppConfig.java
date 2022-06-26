package hello.core;

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
    /*
        이렇게 했을 시 member만 Component Scan의 대상이된다.
        이게 없으면 라이브러리를 포함해서 모든 자바 파일들을 다 뒤져야 하기 때문에 유용하기 쓰임
    */
        basePackages = "hello.core.member",
    /*
        지정하지 않을 시 ComponentScan을 시작 위치로 하위 패키지를 다 뒤진다.
        관례상 최상단에 두고 basePackageClasses를 두지 않는다.
        또 이 녀석이 프로젝트를 대표하는 정보이기 때문에 시작 루트 위치에 두는것이 좋다고 생각한다고 하심.
        그리고 SpringBoot에 ComponentScan이 있기 때문에 사실 AppConfig를 쓸 필요도 없어짐 ㅋ ㅋ
    */
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))

    /*
        @ComonentScan은 @Component뿐만 아니라 다음의 내용도 추가로 대상에 포함한다

        @Component: 컴포넌트 스캔에서 사용
        @Controller: 스프링 MVC 컨트롤러에서 사용
        @Service: 스프링 비즈니스 로직에서 사용
        @Repository: 스프링 데이터 접근 계층에서 사용
        @Configuration: 스프링 설정 정보에서 사용
    */

public class AutoAppConfig {

}
