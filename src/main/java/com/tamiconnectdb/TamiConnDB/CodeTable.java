package com.tamiconnectdb.TamiConnDB;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "codetable")
public class CodeTable {
    @Id
    @Column(name = "id_codetable")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "codetable_key")
    String name;
    //List<String> codeValue;

    public int getId(){return this.id;}
    public void setId(int i){this.id = i;}

    public String getName(){return this.name;}
    public void setName(String n){this.name = n;}

//    public List<String> getCodeValue(){return this.codeValue;}
//    public void setCodeValueList(List<String> list){this.codeValue = list;}

    public CodeTable() {}

    public CodeTable(String name){
        this.setName(name);
       // this.setCodeValueList(list);
    }
    public CodeTable(int id, String name){
        this.setId(id);
        this.setName(name);
       // this.setCodeValueList(list);
    }

}
