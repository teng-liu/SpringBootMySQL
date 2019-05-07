package com.tamiconnectdb.TamiConnDB;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public interface ApplicationDAO {
    //Data Access Object interface

    void setDataSource(DataSource ds, JdbcTemplate template);
    List<Application> getAllApplications();
    Application getApplicationByID(int id);
    List<CodeValue1> getCodeValueByCodeID(int codeTableId);
    List<CodeTableFormRel> getCodeListByFormId(int appId);
}
