package com.tamiconnectdb.TamiConnDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "codevalue")
public class CodeValue {

    @Id
    @Column(name = "id_codevalue")
    int id;

    @Column(name = "code_value")
    String value;

    @Column(name = "id_codetable")
    int codetableId;

    public int getId() {return id; }
    public void setId(int id) {this.id = id; }

    public String getValue() {return value; }
    public void setValue(String value) {this.value = value; }

    public int getCodetableId() {return codetableId; }
    public void setCodetableId(int codetableId) {this.codetableId = codetableId; }


    public CodeValue(){}
    public CodeValue(int codeValueID){
        this.setId(codeValueID);
    }
    public CodeValue(int codeValueID, String codeValueName){
        this.setId(codeValueID);
        this.setValue(codeValueName);
    }
    public CodeValue(int codeValueID, String codeValueName, int codeID){
        this.setId(codeValueID);
        this.setValue(codeValueName);
        this.setCodetableId(codeID);
    }

}
