package com.tamiconnectdb.TamiConnDB;

import java.sql.ResultSet;
import java.sql.SQLException;
//import org.springframework.jdbc.core.RowMapper;

public class ApplicationMapper implements org.springframework.jdbc.core.RowMapper<Application> {

    @Override
    public Application mapRow(ResultSet rs, int rowNum) throws SQLException{
        Application app = new Application();
        app.setId(rs.getInt("id_application"));
        app.setName(rs.getString("application_key"));
        return app;
    }


}
