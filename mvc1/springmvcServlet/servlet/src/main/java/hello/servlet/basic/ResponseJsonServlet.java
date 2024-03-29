package hello.servlet.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Content-Type: application/json
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setName("kim");
        helloData.setAge(20);

//        {"username":"kim", "age":20}
        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);



    }
}
