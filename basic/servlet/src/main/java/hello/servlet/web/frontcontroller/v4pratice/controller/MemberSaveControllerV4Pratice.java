package hello.servlet.web.frontcontroller.v4pratice.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4pratice.ControllerV4Pratice;

import java.util.Map;

public class MemberSaveControllerV4Pratice implements ControllerV4Pratice {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);

        memberRepository.save(member);
        model.put("member", member);

        return "save-result";
    }
}
