package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

        /*
            memberService1 = hello.core.member.MemberServiceImpl@22555ebf
            memberService2 = hello.core.member.MemberServiceImpl@36ebc363
            AppConfig에게 memberService를 달라고 할때마다 새로운 객체(서로 다른 객체가)가 생성된다.
            이를 해결하기 위한 방안 = 객체를 하나만 만들고 공유하도록 하면 된다!
        */

    }
}
