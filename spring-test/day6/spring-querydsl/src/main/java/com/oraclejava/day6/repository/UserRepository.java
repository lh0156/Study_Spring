package com.oraclejava.day6.repository;

import com.oraclejava.day6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User> {

}
