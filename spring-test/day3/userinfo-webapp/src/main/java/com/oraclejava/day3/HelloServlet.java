package com.oraclejava.day3;

import com.oraclejava.day3.config.AppConfig;
import com.oraclejava.day3.dao.UserInfoDao;
import com.oraclejava.day3.entity.UserInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {

    private GenericApplicationContext ac;
    private UserInfoDao userInfoDao;

    @Override
    public void init() throws ServletException {
        super.init();

        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        userInfoDao = ac.getBean(UserInfoDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfo> users = userInfoDao.findAll();

        request.setAttribute("users", users);
        request.setAttribute("msg", "안녕하세요!!!!ASDASD");
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
