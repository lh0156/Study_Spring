package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyView2 {

    private String viewPath;

    MyView2(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(ModelViewPratice modelView2, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setModel(modelView2, request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }

    private static void setModel(ModelViewPratice modelView2, HttpServletRequest request) {
        modelView2.getModelView().forEach(request::setAttribute);
    }

}
