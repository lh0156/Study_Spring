package com.oraclejava.day3;

import com.oraclejava.day3.config.AppConfig;
import com.oraclejava.day3.dao.UserInfoDao;
import com.oraclejava.day3.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class JdbcTest {

    private GenericApplicationContext ac;
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
        ac.close();
    }

    @Test
    public void testFindUserByNo() {
        UserInfo user = userInfoDao.findUserByNo(2);

        System.out.println(user.getNo());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        ac.close();
    }
}
