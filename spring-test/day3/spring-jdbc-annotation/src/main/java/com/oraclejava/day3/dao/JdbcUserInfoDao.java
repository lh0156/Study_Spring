    package com.oraclejava.day3.dao;

    import com.oraclejava.day3.SelectAllUsers;
    import com.oraclejava.day3.entity.UserInfo;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.stereotype.Repository;

    import javax.sql.DataSource;
    import java.util.List;

    @Repository("userInfoDao")
    public class JdbcUserInfoDao implements UserInfoDao{

        private static Logger logger = LoggerFactory.getLogger(JdbcUserInfoDao.class);
        private DataSource dataSource;
        private SelectAllUsers selectAllUsers;

        @Override
        public List<UserInfo> findAll() {
            return selectAllUsers.execute();
        }

        @Autowired
        @Qualifier("dataSource")
        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            this.selectAllUsers = new SelectAllUsers(dataSource);
        }

    }
