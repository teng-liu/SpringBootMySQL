package com.tamiconnectdb.TamiConnDB;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public interface ApplicationDAO {
    //Data Access Object interface

    public void setDataSource(DataSource ds, JdbcTemplate template);
    public List<Application> getAllApplications();
    Application getApplicationByID(int id);
    public List<CodeValue1> getCodeValueByCodeID(int codeTableId);
}
