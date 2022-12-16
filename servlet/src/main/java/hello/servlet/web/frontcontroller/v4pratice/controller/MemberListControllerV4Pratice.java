package hello.servlet.web.frontcontroller.v4pratice.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4pratice.ControllerV4Pratice;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4Pratice implements ControllerV4Pratice {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        List<Member> members = memberRepository.findAll();
        model.put("members", members);

        return "members";
    }
}
