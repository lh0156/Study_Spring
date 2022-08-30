package com.oraclejava.day6;

import com.oraclejava.day6.entity.BlogPost;
import com.oraclejava.day6.entity.QUser;
import com.oraclejava.day6.entity.User;
import com.oraclejava.day6.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository dao;

    @Test
    public void testSave() {
//        User user = new User();
//        user.setDisabled(false);
//        user.setLogin("yunseop");
//      윤섭(1) 이 글을 쓴다

        User user = dao.findById(13L).get();

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("hanesome");
        blogPost.setBody("chanchan hanesome he is my friend");
        blogPost.setUser(user);

        Set<BlogPost> blogPostSet = new HashSet<>();
        blogPostSet.add(blogPost);

        user.setBlogPosts(blogPostSet);

        dao.save(user);
    }

    @Test
    public void testFindUserByUserName() {
        QUser quser = QUser.user;
        Predicate predicate = quser.login.eq("changyu");
        User user = dao.findOne(predicate).get();
        //System.out.println(user.getLogin());
    }
}
