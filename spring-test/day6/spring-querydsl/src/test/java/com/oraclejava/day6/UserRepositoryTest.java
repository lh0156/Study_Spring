package com.oraclejava.day6;

import com.oraclejava.day6.entity.BlogPost;
import com.oraclejava.day6.entity.User;
import com.oraclejava.day6.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository dao;

    @Test
    public void testSave() {
        User user = new User();
        user.setDisabled(false);
        user.setLogin("hyunjung");
//      윤섭(1) 이 글을 쓴다

//        User user = dao.findById(5L).get();
//
//        BlogPost blogPost = new BlogPost();
//        blogPost.setTitle("he is genius?");
//        blogPost.setBody("He is perfect boy!");
//        blogPost.setUser(user);
//
//        Set<BlogPost> blogPostSet = new HashSet<>();
//        blogPostSet.add(blogPost);
//
//        user.setBlogPosts(blogPostSet);

        dao.save(user);
    }

    @Test
    public void testFindUserByUserName() {
        
    }
}
