package com.oraclejava.day6;

import com.oraclejava.day6.entity.User;
import com.oraclejava.day6.repository.UserRepositoryManagerDsl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryManagerTest {

    @Autowired
    private UserRepositoryManagerDsl mgr;

    @Test
    public void testFindUserByUserName() {
        User user = mgr.findUserByUserName("yunseop");
        System.out.println(user.getLogin());
    }
    
}
