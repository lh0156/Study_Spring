package hello.servlet.web.frontcontroller.v3pratice.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelViewPratice;
import hello.servlet.web.frontcontroller.v3pratice.ControllerV31;

import java.util.Map;

public class MemberSaveControllerV31 implements ControllerV31 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelViewPratice process(Map<String, String> paramMap) {

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelViewPratice mv = new ModelViewPratice("save-result");
        mv.getModelView().put("member", member);

        return mv;


    }
}
