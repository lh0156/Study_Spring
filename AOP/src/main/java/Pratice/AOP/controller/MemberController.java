package Pratice.AOP.controller;

import Pratice.AOP.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("test", "testtest");
        return "test";
    }


}
