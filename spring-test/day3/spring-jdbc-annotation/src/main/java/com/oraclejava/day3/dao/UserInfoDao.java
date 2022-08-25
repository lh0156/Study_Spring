package com.oraclejava.day3.dao;

import com.oraclejava.day3.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    List<UserInfo> findAll();
    UserInfo findUserByNo(int no);
}
