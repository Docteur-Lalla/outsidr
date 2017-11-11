package fr.istic.m2.entities;

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
  private Meteo meteo;
  private List<Registration> registration;

  /**
   * Default constructor.
   */
  public Activity() {

  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param name the activity name
   * @param meteo the list of meteo where the activity takes place
   * @param registration the list of registrations in which this activity occurs
   */
  public Activity(String name, Meteo meteo, List<Registration> registration) {
    this.name = name;
    this.meteo = meteo;
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
   * Getter of the meteo where the activity takes place.
   * @return the meteo
   */
  @ManyToOne
  public Meteo getMeteo() {
    return meteo;
  }

  /**
   * Setter of the meteo where the activity takes place.
   * @param meteo the meteo
   */
  public void setMeteo(Meteo meteo) {
    this.meteo = meteo;
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
