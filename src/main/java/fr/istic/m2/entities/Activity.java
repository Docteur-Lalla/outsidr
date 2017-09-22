package fr.istic.m2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class representing an activity in the database.
 */
@Entity
public class Activity {
  private int id;
  private String name;
  private List<Location> location;
  private List<Registration> registration;

  /**
   * Default constructor.
   */
  public Activity() {

  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param name the activity name
   * @param location the list of locations where the activity takes place
   * @param registration the list of registrations in which this activity occurs
   */
  public Activity(String name, List<Location> location, List<Registration> registration) {
    this.name = name;
    this.location = location;
    this.registration = registration;
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
   * Getter of the list of locations where the activity takes place.
   * @return the list of locations
   */
  @OneToMany(mappedBy="activity")
  public List<Location> getLocation() {
    return location;
  }

  /**
   * Setter of the list of locations where the activity takes place.
   * @param location the list of locations
   */
  public void setLocation(List<Location> location) {
    this.location = location;
  }

  /**
   * Getter of the list of registrations in which the activity occurs.
   * @return the list of registrations
   */
  @OneToMany(mappedBy="activity")
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
}
