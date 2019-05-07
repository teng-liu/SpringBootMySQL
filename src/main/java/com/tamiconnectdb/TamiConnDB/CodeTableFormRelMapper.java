package com.tamiconnectdb.TamiConnDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeTableFormRelMapper implements org.springframework.jdbc.core.RowMapper<CodeTableFormRel> {

    @Override
    public CodeTableFormRel mapRow(ResultSet rs, int rowNum) throws SQLException {

        CodeTableFormRel rel = new CodeTableFormRel();
        rel.setId(rs.getInt("id_application_codetable"));
        rel.setFormID(rs.getInt("id_application"));
        rel.setCodeId(rs.getInt("id_codetable"));
        rel.setCodeName(rs.getString("codetable_key"));

        return rel;
    }
}
