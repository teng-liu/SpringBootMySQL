package com.tamiconnectdb.TamiConnDB;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Application")
public class Form {         // application form
    @Id
    @Column(name = "id_application")
    int id;

    @Column(name="application_key")
    String formName;

    public int getId(){return this.id;}
    public void setId(int i) {this.id = i;}

    public String getName(){return this.formName;}
    public void setName(String n) {this.formName = n;}

    public Form(){}

    public Form(int id){this.setId(id);}

    public Form(String name){
        this.setName(name);
       // this.setCodeTableList(list);
    }

    public Form(int id, String name){
        this.setId(id);
        this.setName(name);
        //this.setCodeTableList(list);
    }


}
