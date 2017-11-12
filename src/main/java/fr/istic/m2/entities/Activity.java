package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class representing an activity in the database.
 */
@Entity
public class Activity {
  private int id;
  private String name;
  private City city;
  private List<Registration> registration;

  /**
   * Default constructor.
   */
  public Activity() {

  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param name the activity name
   * @param registration the list of registrations in which this activity occurs
   */
  public Activity(String name, List<Registration> registration, City city) {
    this.name = name;
    this.registration = registration;
    this.city = city;
  }

  /**
   * Getter of the ID.
   * @return the ID of the activity
   */
  @Id
  @NotNull
  @GeneratedValue
  public int getId() {
    return id;
  }

  /**
   * Setter of the ID
   * @param id the ID of the activity
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter of the name.
   * @return the name of the activity
   */
  @NotNull
  public String getName() {
    return name;
  }

  /**
   * Setter of the name.
   * @param name the name of the activity
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter of the list of registrations in which the activity occurs.
   * @return the list of registrations
   */
  @OneToMany(mappedBy="activity")
  @JsonBackReference
  public List<Registration> getRegistration() {
    return registration;
  }

  /**
   * Setter of the list of registrations in which the activity occurs.
   * @param registration the list of registrations
   */
  public void setRegistration(List<Registration> registration) {
    this.registration = registration;
  }

  @ManyToOne
  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }
}
