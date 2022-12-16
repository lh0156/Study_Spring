package hello.servlet.web.frontcontroller.v3pratice;

import hello.servlet.web.frontcontroller.ModelViewPratice;

import java.util.Map;

public interface ControllerV31 {

    ModelViewPratice process(Map<String, String> paramMap);

}
