package fr.istic.m2;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {

    private int id;
    private String name;
    private String password;
    private String mail;

    public User() {
    }

    public User(int id, String name, String password, String mail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
