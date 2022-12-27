package hello.servlet.web.frontcontroller.v4pratice;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4pratice.controller.MemberFormControlleV4Pratice;
import hello.servlet.web.frontcontroller.v4pratice.controller.MemberSaveControllerV4Pratice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV4Pratice", urlPatterns = "/front-controller/v4pratice/*")
public class FrontControllerV4Pratice extends HttpServlet {

    Map<String, ControllerV4Pratice> controllerMap = new HashMap<>();

    FrontControllerV4Pratice() {
        controllerMap.put("/front-controller/v4pratice/members", new MemberFormControlleV4Pratice());
        controllerMap.put("/front-controller/v4pratice/members/new-form", new MemberFormControlleV4Pratice());
        controllerMap.put("/front-controller/v4pratice/members/save-result", new MemberSaveControllerV4Pratice());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        System.out.println(requestURI);

        ControllerV4Pratice controllerV4Pratice = controllerMap.get(requestURI);

        if (controllerV4Pratice == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        String viewName = controllerV4Pratice.process(paramMap, model);

        MyView myView = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        myView.render(model, request, response);


    }
}
