package com.oraclejava.day3;

import com.oraclejava.day3.config.AppConfig;
import com.oraclejava.day3.dao.JdbcUserInfoDao;
import com.oraclejava.day3.dao.UserInfoDao;
import com.oraclejava.day3.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JdbcTest {

    private ApplicationContext ac;
    private UserInfoDao userInfoDao;

    @Before
    public void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        userInfoDao = ac.getBean(UserInfoDao.class);
    }

    @Test
    public void testFindAll() {
        List<UserInfo> users = userInfoDao.findAll();

        for (UserInfo user : users) {
            System.out.print(user.getNo().TYPE);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }

    }
}
