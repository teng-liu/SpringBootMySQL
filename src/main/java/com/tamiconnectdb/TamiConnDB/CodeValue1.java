package com.tamiconnectdb.TamiConnDB;

public class CodeValue1 {

    int id, codetableId;
    String value;

    public int getId() {return id; }
    public void setId(int id) {this.id = id; }

    public String getValue() {return value; }
    public void setValue(String value) {this.value = value; }

    public int getCodetableId() {return codetableId; }
    public void setCodetableId(int codetableId) {this.codetableId = codetableId; }


    public CodeValue1(){}
    public CodeValue1(int codeValueID){
        this.setId(codeValueID);
    }
    public CodeValue1(int codeValueID, String codeValueName){
        this.setId(codeValueID);
        this.setValue(codeValueName);
    }
    public CodeValue1(int codeValueID, String codeValueName, int codeID){
        this.setId(codeValueID);
        this.setValue(codeValueName);
        this.setCodetableId(codeID);
    }
}
