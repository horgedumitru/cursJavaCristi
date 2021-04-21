package com.model;

import java.sql.Date;

public class Person {

    private String name, email;
    private int age;
    private Date dataAngajare;


    public Person(String name, String email, int age, Date dataAngajare) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dataAngajare = dataAngajare;
    }

    public Person (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
    }


}
