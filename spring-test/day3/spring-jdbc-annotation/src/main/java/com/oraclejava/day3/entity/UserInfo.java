package com.oraclejava.day3.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private Long no;
    private String username;
    private String password;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
