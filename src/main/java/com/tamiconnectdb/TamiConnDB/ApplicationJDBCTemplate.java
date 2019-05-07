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

    public List<CodeValue1> getCodeValueByCodeID(int ctid) {
        String query = "select ct.id_codetable, ct.codetable_key, cv.id_codevalue, cv.code_value\n" +
                "    from codetable ct\n" +
                "    inner join codevalue cv on ct.id_codetable=cv.id_codetable\n" +
                "    where ct.id_codetable=?;";

        RowMapper<CodeValue1> mapper = new CodeValueMapper();
        List<CodeValue1> codeValues = jdbcTemplate.query(
                query, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, ctid);
                    }
                },
                mapper);

        return codeValues;
    }

    public List<CodeTableFormRel> getCodeListByFormId(int appId){
        String query = "select m.id_application_codetable, m.id_application, m.id_codetable, ct.codetable_key\n" +
                "    from application_codetable m \n" +
                "    inner join codetable ct on m.id_codetable=ct.id_codetable\n" +
                "    where m.id_application = ?;";
        RowMapper<CodeTableFormRel> mapper = new CodeTableFormRelMapper();
        List<CodeTableFormRel> list = jdbcTemplate.query(
                query, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, appId);
                    }
                },
                mapper);

        return list;
    }
}
