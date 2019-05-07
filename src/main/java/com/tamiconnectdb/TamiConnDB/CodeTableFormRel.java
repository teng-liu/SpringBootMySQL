package com.tamiconnectdb.TamiConnDB;


public class CodeTableFormRel {

    int id;
    int formID;
    int codeID;
    String codeName;

    public int getId() {
        return id;
    }

    public int getFormID() {
        return formID;
    }

    public int getCodeId() {
        return codeID;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public void setCodeId(int codeID) {
        this.codeID = codeID;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public CodeTableFormRel(){}

    public CodeTableFormRel(int id, int formid, int codeID, String codename){
        this.setId(id);
        this.setFormID(formid);
        this.setCodeId(codeID);
        this.setCodeName(codename);
    }
}
