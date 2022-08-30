package com.oraclejava.day6.repository;

import com.oraclejava.day6.entity.BlogPost;
import com.oraclejava.day6.entity.QBlogPost;
import com.oraclejava.day6.entity.QUser;
import com.oraclejava.day6.entity.User;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//JPA QueryDSL

@Component
@Transactional
public class UserRepositoryManagerDsl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    private JPAQueryFactory queryFactory;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    public User findUserByUserName (final String userName) {
        QUser qUser = QUser.user;
        Predicate predicate = qUser.login.eq(userName);
        return userRepository.findOne(predicate).get();
    }

    //Select All
    public List<User> findAll() {
        QUser quser = QUser.user;
        return queryFactory.selectFrom(quser).fetch();
    }

    //Detail
    public User findOneByUserName(final String username) {
        QUser qUser = QUser.user;
        return queryFactory.selectFrom(qUser)
                .where(qUser.login.eq(username))
                .fetchOne();
    }

    public User findOneByUserNameAndDisabled(final String userName, final Boolean disabled) {
        QUser qUser = QUser.user;
        return queryFactory.selectFrom(qUser)
                .where(qUser.login.eq(userName).and(
                        qUser.disabled.eq(disabled)
                )).fetchOne();
    }

    public List<BlogPost> findBlogListByJoin(final String userName) {
        QBlogPost qBlogPost = QBlogPost.blogPost;
        QUser qUser = QUser.user;

        return queryFactory.selectFrom(qBlogPost)
                .innerJoin(qUser)
                .on(qBlogPost.user.eq(qUser))
                .fetch();
    }

    //Delete
    public long deleteUser(final String userName) {
        QUser qUser = QUser.user;
        return queryFactory.delete(qUser)
                .where(qUser.login.eq(userName))
                .execute();
    }

    //Update
    public long updateUser(final User user, final String userName) {
        QUser qUser = QUser.user;
        return queryFactory.update(qUser)
                .where(qUser.login.eq(userName))
                .set(qUser.login, user.getLogin())
                .set(qUser.disabled, user.getDisabled())
                .execute();
    }

    //Paging
    //@Param1 = 페이지 당 수
    //@param2 = 페이지 수
    public Page<User> findAllAndPager (final int offset, final int pageSize) {
        Predicate predicate = QUser.user.login.contains("s");

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));

        PageRequest pr = PageRequest.of(offset, pageSize, sort);
        return userRepository.findAll(predicate, pr);
    }
}



