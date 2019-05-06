package com.tamiconnectdb.TamiConnDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class ApplicationJDBCTemplate implements ApplicationDAO {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds, JdbcTemplate template) {
        this.dataSource = ds;
        this.jdbcTemplate = template;
    }


    // source: https://www.concretepage.com/spring-boot/spring-boot-jdbc-example
    public Application getApplicationByID(int id) {

        String sql = "select * from Application where id_application=?";

        RowMapper<Application> mapper = new ApplicationMapper();
        List<Application> apps = jdbcTemplate.query(
                sql, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, id);
                    }
                },
                mapper);
        return apps.get(0);
    }

    public List<Application> getAllApplications(){
        String sql = "select * from Application";
        RowMapper<Application> mapper = new ApplicationMapper();
        List<Application> apps = jdbcTemplate.query(sql, mapper);
        return apps;
    }

    public List<CodeValue1> getCodeValueByCodeID(int appId) {

        String sql = "select  a.id_application, a.application_key, ct.codetable_key, cv.code_value\n" +
                "    from codevalue cv\n" +
                "    inner join codetable ct on cv.id_codetable=ct.id_codetable\n" +
                "    inner join application_codetable m on ct.id_codetable=m.id_codetable\n" +
                "    inner join application a on m.id_application=a.id_application\n" +
                "    where a.id_application=?;";

        RowMapper<CodeValue1> mapper = new CodeValueMapper();
        List<CodeValue1> codeValues = jdbcTemplate.query(
                sql, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, appId);
                    }
                },
                mapper);

        return codeValues;
    }
}
