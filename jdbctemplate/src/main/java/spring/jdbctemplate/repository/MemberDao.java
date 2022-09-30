package spring.jdbctemplate.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.RowMapper;
import spring.jdbctemplate.domain.MemberDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<MemberDto> selectAll() {
        List<MemberDto> results = jdbcTemplate.query(
                "select * from TBLMEMBER",
                new RowMapper<MemberDto>() {
                    @Override
                    public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        MemberDto member = new MemberDto(
                                rs.getString("MEMBERNAME"),
                                rs.getString("MEMBERADDRESS"),
                                rs.getString("MEMBERGENDER")
                        );

                        return member;
                    }
                });

        return results;
    }

}
