package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Class representing locations where the activities can take place in the database.
 * @see Activity
 */
@Entity
public class Location {
  private int id;
  private String name;
  private String address;
  private Activity activity;
  private Meteo meteo;

  /**
   * Default constructor.
   */
  public Location() {

  }

  /**
   * Constructor with a parameter for each field in the class.
   * @param name the name given to the location
   * @param address the address
   * @param activity the activity associated with the location
   * @param meteo the meteo expected during the next week-end
   */
  public Location(String name, String address, Activity activity, Meteo meteo) {
    this.name = name;
    this.address = address;
    this.activity = activity;
    this.meteo = meteo;
  }

  /**
   * Getter of the ID.
   * @return the ID of the location in the database
   */
  @Id
  @NotNull
  @GeneratedValue
  public int getId() {
    return id;
  }

  /**
   * Setter of the ID.
   * @param id the ID of the location in the database
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter of the name.
   * @return the name given to the location
   */
  @NotNull
  public String getName() {
    return name;
  }

  /**
   * Setter of the name.
   * @param name the name given to the location
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter of the address.
   * @return the address
   */
  @NotNull
  public String getAddress() {
    return address;
  }

  /**
   * Setter of the address.
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Getter of the activity.
   * @return the activity associated with the location
   */
  @ManyToOne
  @JsonManagedReference
  public Activity getActivity() {
    return activity;
  }

  /**
   * Setter of the activity.
   * @param activity the activity associated with the location
   */
  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  /**
   * Getter of the meteo.
   * @return the meteo expected the next week-end
   */
  @OneToOne
  @NotNull
  public Meteo getMeteo() {
    return meteo;
  }

  /**
   * Setter of the meteo.
   * @param meteo the meteo expected the next week-end
   */
  public void setMeteo(Meteo meteo) {
    this.meteo = meteo;
  }
}
