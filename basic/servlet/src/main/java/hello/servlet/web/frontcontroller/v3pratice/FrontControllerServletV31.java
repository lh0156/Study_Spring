package hello.servlet.web.frontcontroller.v3pratice;

import hello.servlet.web.frontcontroller.ModelViewPratice;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3pratice.controller.MemberFormControllerV31;
import hello.servlet.web.frontcontroller.v3pratice.controller.MemberListControllerV31;
import hello.servlet.web.frontcontroller.v3pratice.controller.MemberSaveControllerV31;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV31", urlPatterns = "/front-controller/v31/*")
public class FrontControllerServletV31 extends HttpServlet {

    private Map<String, ControllerV31> controllerMap = new HashMap();

    public FrontControllerServletV31() {
        controllerMap.put("/front-controller/v31/members/new-form", new MemberFormControllerV31());
        controllerMap.put("/front-controller/v31/members/save", new MemberSaveControllerV31());
        controllerMap.put("/front-controller/v31/members", new MemberListControllerV31());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        System.out.println("requestURI: " + requestURI);
        ControllerV31 controllerV31 = controllerMap.get(requestURI);

        System.out.println("ControllerV31: " + controllerV31);

        if (controllerV31 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

        ModelViewPratice mv = controllerV31.process(paramMap);
        String viewName = mv.getViewName();

        System.out.println("viewName: " + viewName);

        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        view.render(request, response);
//        myView.render();

    }
}
