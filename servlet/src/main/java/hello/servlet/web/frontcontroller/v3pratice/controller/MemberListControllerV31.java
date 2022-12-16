package hello.servlet.web.frontcontroller.v3pratice.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelViewPratice;
import hello.servlet.web.frontcontroller.v3pratice.ControllerV31;

import java.util.List;
import java.util.Map;

public class MemberListControllerV31 implements ControllerV31 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelViewPratice process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();

        ModelViewPratice mv = new ModelViewPratice("members");
        mv.getModelView().put("members", members);
        return mv;

    }
}
