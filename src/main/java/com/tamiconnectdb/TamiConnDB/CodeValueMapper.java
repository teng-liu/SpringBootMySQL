package com.tamiconnectdb.TamiConnDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeValueMapper implements org.springframework.jdbc.core.RowMapper<CodeValue1>{
    @Override
    public CodeValue1 mapRow(ResultSet rs, int rowNum) throws SQLException {

        CodeValue1 cv = new CodeValue1();
        cv.setCodeValueId(rs.getInt("id_codevalue"));
        cv.setCodeTableId(rs.getInt("id_codetable"));
        cv.setCodeTableName(rs.getString("codetable_key"));
        cv.setCodeValue(rs.getString("code_value"));

        return cv;
    }
}
