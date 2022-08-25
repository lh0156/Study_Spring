package com.oraclejava.day3;

import com.oraclejava.day3.entity.UserInfo;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SelectAllUsers extends MappingSqlQuery<UserInfo> {

    private static final String SQL_SELECT_ALL_USERS = "select `s.no` as no, username, password from user_info";
    public SelectAllUsers(DataSource ds) {
        super(ds, SQL_SELECT_ALL_USERS);
    }

    @Override
    protected UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setNo(rs.getLong("no"));
        userInfo.setUsername(rs.getString("username"));
        userInfo.setPassword(rs.getString("password"));
        return userInfo;
    }
}
