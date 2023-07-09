package com.unasat.repository.entity;

import java.util.Date;

public class Person {

    private String userName;
    private String password;
    private int pointsPerGame;
    private Date birthDate;


    //Constructors
    public Person(String userName) {
        this.userName = userName;
    }

    public Person() {
    }

    //Getters
    public String getUserName() {
        return userName;
    }



}
