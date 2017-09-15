package fr.istic.m2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

  private int id;
  private String name;
  private String password;
  private String mail;
  private List<Registration> registration;

  public User() {
  }

  public User(String name, String password, String mail, List<Registration> registration) {
    this.name = name;

    this.password = password;
    this.mail = mail;
    this.registration = registration;
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

  @OneToMany
  public List<Registration> getRegistration() {
    return registration;
  }

  public void setRegistration(List<Registration> registration) {
    this.registration = registration;
  }
}
