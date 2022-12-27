package spring.jdbctemplate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.jdbctemplate.repository.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@192.168.100.212:1521:orcl");
        ds.setUsername("SHARED");
        ds.setPassword("aim#2022");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;

    }

    @Bean(value = "memberDao")
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

}
