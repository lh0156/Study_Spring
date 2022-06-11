package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 @Configuration
public class AppConfig {

    /*
    * 이렇게 변환해주면 역할(관심사)이 완벽히 분리된다는 장점이 있다!
    * 설계에 대한 그림이 구성 정보에 그대로 드러남!
    * 역할과 구현 클래스가 한눈에 들어온다 ㅋㅋ 짱임
    */

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call Appconfig.orderService
    //call AppConfig.memberRepository

    /*우리 의도와는 다르게
    call AppConfig.memberService
    call AppConfig.memberRepository
    call Appconfig.orderService
    으로 끝난다.
    스프링이 싱글턴을 보장해주고 있는 것!
    */

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
