package com.oraclejava.day3;

import com.oraclejava.day3.entity.UserInfo;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectUserByNo extends MappingSqlQuery<UserInfo> {

    private static final String SQL_FIND_BY_NO = "select `s.no` as no, username, password from user_info\n" +
            "where `s.no` = :no";

    public SelectUserByNo(DataSource ds) {
        super(ds, SQL_FIND_BY_NO);
        super.declareParameter(new SqlParameter("no", Types.INTEGER));
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
