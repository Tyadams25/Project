package com.example.cpshome.navagationbar.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public int getId()      {
       return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    // Creates the strings for the details that can be inputted.

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail(){ return email;}
}






