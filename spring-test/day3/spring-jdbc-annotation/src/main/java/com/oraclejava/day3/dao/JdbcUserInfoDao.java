    package com.oraclejava.day3.dao;

    import com.oraclejava.day3.SelectAllUsers;
    import com.oraclejava.day3.SelectUserByNo;
    import com.oraclejava.day3.entity.UserInfo;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.stereotype.Repository;

    import javax.sql.DataSource;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    @Repository("userInfoDao")
    public class JdbcUserInfoDao implements UserInfoDao{

        private static Logger logger = LoggerFactory.getLogger(JdbcUserInfoDao.class);
        private DataSource dataSource;
        private SelectAllUsers selectAllUsers;
        private SelectUserByNo selectUserByNo;

        @Override
        public List<UserInfo> findAll() {
            return selectAllUsers.execute();
        }

        @Override
        public UserInfo findUserByNo(int no) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("no", no);
            return selectUserByNo.executeByNamedParam(paramMap).get(0);
        }


        @Autowired
        @Qualifier("dataSource")
        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            this.selectAllUsers = new SelectAllUsers(dataSource);
            this.selectUserByNo = new SelectUserByNo(dataSource);
        }

    }
