package hello.servlet.web.frontcontroller.v3pratice.controller;

import hello.servlet.web.frontcontroller.ModelViewPratice;
import hello.servlet.web.frontcontroller.v3pratice.ControllerV31;

import java.util.Map;

public class MemberFormControllerV31 implements ControllerV31 {
    @Override
    public ModelViewPratice process(Map<String, String> paramMap) {
        return new ModelViewPratice("new-form");
    }
}
