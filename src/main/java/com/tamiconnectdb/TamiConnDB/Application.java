package com.tamiconnectdb.TamiConnDB;

public class Application {

    private int id;
    private String name;

    public int getId(){return this.id;}
    public void setId(int i) {this.id = i;}

    public String getName(){return this.name;}
    public void setName(String n) {this.name = n;}

    public Application(){}

    public Application(int id){this.setId(id);}

    public Application(String name){
        this.setName(name);
    }

    public Application(int id, String name){
        this.setId(id);
        this.setName(name);
    }


}
