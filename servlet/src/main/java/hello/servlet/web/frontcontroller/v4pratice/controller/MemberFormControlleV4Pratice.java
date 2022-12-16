package hello.servlet.web.frontcontroller.v4pratice.controller;

import hello.servlet.web.frontcontroller.v4pratice.ControllerV4Pratice;

import java.util.Map;

public class MemberFormControlleV4Pratice implements ControllerV4Pratice {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }

}
