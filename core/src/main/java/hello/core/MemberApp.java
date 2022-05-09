package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        //멤버 객체를 만든다
        Member member = new Member(1L, "엄윤섭", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
        System.out.println(findMember.equals(member));

        //이렇게 순수 자바 코드로 만들면 눈으로 하나하나 다 확인해야하는 단점이 있다.
        //그래서 Junit이라는걸 사용함!
        //부트가 알아서 셋팅을 해준다.

    }

}
