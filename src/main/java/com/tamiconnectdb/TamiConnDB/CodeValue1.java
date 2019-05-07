package com.tamiconnectdb.TamiConnDB;

public class CodeValue1 {

//    select ct.id_codetable, ct.codetable_key, cv.id_codevalue, cv.code_value
//    from codetable ct
//    inner join codevalue cv on ct.id_codetable=cv.id_codetable
//    where ct.id_codetable=1;

    int codeValueId;
    int codeTableId;
    String codeTableName;
    String codeValue;

    public void setCodeValueId(int codeValueId) {
        this.codeValueId = codeValueId;
    }

    public void setCodeTableId(int codeTableId) {
        this.codeTableId = codeTableId;
    }

    public void setCodeTableName(String codeTableName) {
        this.codeTableName = codeTableName;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public int getCodeValueId() {
        return codeValueId;
    }

    public int getCodeTableId() {
        return codeTableId;
    }

    public String getCodeTableName() {
        return codeTableName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public CodeValue1(){ }

    public CodeValue1(int codeValueId,
                      int codeTableId,
                      String codeTableName,
                      String codeValue){

        this.setCodeValueId(codeValueId);
        this.setCodeTableId(codeTableId);
        this.setCodeTableName(codeTableName);
        this.setCodeValue(codeValue);

    }
}
