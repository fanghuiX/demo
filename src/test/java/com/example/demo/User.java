package com.example.demo;

import java.io.Serializable;

public class User implements Serializable {
    private String e_mail;

    private String name;

    public User(String eMail, String name) {
        this.e_mail = eMail;
        this.name = name;
    }
}
