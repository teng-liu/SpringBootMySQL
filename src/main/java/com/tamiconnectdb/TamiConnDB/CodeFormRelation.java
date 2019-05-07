package com.tamiconnectdb.TamiConnDB;

import javax.persistence.*;

@Entity
@Table(name = "application_codetable")
public class CodeFormRelation {

    @Id
    @Column(name = "id_application_codetable")
    int id;

    @Column(name = "id_application")
    int formID;

    @Column(name = "id_codetable")
    int codeID;

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setFormID(int formID) {this.formID = formID;}
    public int getFormID() {return formID;}

    public void setCodeId(int codeID) {this.codeID = codeID;}
    public int getCodeId() {return this.codeID;}

    public CodeFormRelation() {}

    public CodeFormRelation(int id) {
        this.setId(id);
    }

    public CodeFormRelation(int id, int formID) {
        this.setId(id);
        this.setFormID(formID);
    }

    public CodeFormRelation(int id, int formID, int codeID) {
        this.setId(id);
        this.setFormID(formID);
        this.setCodeId(codeID);
    }

}
