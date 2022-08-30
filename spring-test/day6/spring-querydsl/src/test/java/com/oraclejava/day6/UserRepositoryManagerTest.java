package com.oraclejava.day6;

import com.oraclejava.day6.entity.BlogPost;
import com.oraclejava.day6.entity.QBlogPost;
import com.oraclejava.day6.entity.QUser;
import com.oraclejava.day6.entity.User;
import com.oraclejava.day6.repository.UserRepositoryManagerDsl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class UserRepositoryManagerTest {

    @Autowired
    private UserRepositoryManagerDsl mgr;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    private JPAQueryFactory jpaQueryFactory;

    @Test
    public void testFindUserByUserName() {
        User user = mgr.findUserByUserName("yunseop");
        System.out.println(user.getLogin());
    }

    //왜안될까?
    @Test
    public void findAllTest() {
        List<User> all = mgr.findAll();

        for (User user : all) {
            System.out.println("ID Sequence: " + user.getId());
            System.out.println("ID : " + user.getLogin());
        }
    }

    //자바코드 버전
    @Test
    public void findAllTestByJavaCode() {
        QUser qUser = QUser.user;
        List<User> all = jpaQueryFactory.selectFrom(qUser).fetch();

        for (User user : all) {
            System.out.println(user.getId());
            System.out.println(user.getLogin());
//            System.out.println(user.getBlogPosts());
        }
    }

    @Test
    public void findById() {
        QUser qUser = QUser.user;

        User yunseop = jpaQueryFactory.selectFrom(qUser).where(qUser.login.eq("yunseop")).fetchOne();

        System.out.println(yunseop.getLogin());

    }

    @Test
    public void findAllByDisabled() {
        QUser qUser = QUser.user;

        List<User> aFalse = jpaQueryFactory.selectFrom(qUser).where(qUser.disabled.eq(false)).fetch();

        for (User user : aFalse) {
            System.out.println(user.getId());
        }
    }

    @Test
    public void findInnerJoinTest() {
        QBlogPost qBlogPost = QBlogPost.blogPost;
        QUser qUser = QUser.user;

        List<BlogPost> fetch = jpaQueryFactory.selectFrom(qBlogPost)
                .innerJoin(qUser)
                .on(qBlogPost.user.eq(qUser))
                .fetch();

        for (BlogPost blogPost : fetch) {
            blogPost.getUser();
        }

    }

    //질문 1
    @Test
    public void updateTest() {
        User user = new User();
        user.setLogin("manseop");
        user.setDisabled(false);

        mgr.updateUser(user, "yunseop");

    }

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

}
