package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Entity representing a user in the database.
 */
@Entity
public class User {

  private int id;
  private String name;
  private String password;
  private String mail;
  private List<Registration> registration;

  /**
   * Default constructor
   */
  public User() {
  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param name the username
   * @param password the user's password
   * @param mail the user's mail
   * @param registration the list of the user's registrations to activities
   */
  public User(String name, String password, String mail, List<Registration> registration) {
    this.name = name;

    this.password = password;
    this.mail = mail;
    this.registration = registration;
  }

  /**
   * Getter of the ID.
   * @return the user's ID in the database
   */
  @Id
  @NotNull
  @GeneratedValue
  public int getId() {
    return this.id;
  }

  /**
   * Setter of the ID.
   * @param id the user's ID in the database
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter of the username.
   * @return the username
   */
  @NotNull
  public String getName() {
    return this.name;
  }

  /**
   * Setter of the username.
   * @param name the username
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter of the password.
   * @return the user's password
   */
  @NotNull
  public String getPassword() {
    return this.password;
  }

  /**
   * Setter of the password.
   * @param password the user's password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter of the mail address.
   * @return the user's mail address
   */
  @NotNull
  public String getMail() {
    return this.mail;
  }

  /**
   * Setter of the mail address.
   * @param mail the user's mail address
   */
  public void setMail(String mail) {
    this.mail = mail;
  }

  /**
   * Getter of the registration list.
   * @return the user's registration list in the database
   */
  @OneToMany(mappedBy="user")
  @JsonBackReference
  public List<Registration> getRegistration() {
    return registration;
  }

  /**
   * Setter of the registration list.
   * @param registration the user's registration list in the database
   */
  public void setRegistration(List<Registration> registration) {
    this.registration = registration;
  }
}
