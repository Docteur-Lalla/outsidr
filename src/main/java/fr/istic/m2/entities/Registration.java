package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class representing the association of a user and an activity in the database.
 * @see User
 * @see Activity
 */
@Entity
public class Registration {
  private int id;
  private User user;
  private Activity activity;
  private String level;

  /**
   * Default constructor
   */
  public Registration() {

  }

  /**
   * Constructor with a parameter for each field in the class.
   * @param user the user
   * @param activity the activity
   * @param level the level of skill the user wishes to practice at
   */
  public Registration(User user, Activity activity, String level) {
    this.user = user;
    this.activity = activity;
    this.level = level;
  }

  /**
   * Getter of the ID.
   *
   * @return the ID
   */
  @Id
  @GeneratedValue
  public int getId() {
    return this.id;
  }

  /**
   * Setter of the ID.
   *
   * @param id the ID
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter of the user.
   * @return the user
   */
  @ManyToOne
//  @JsonManagedReference
  public User getUser() {
    return user;
  }

  /**
   * Setter of the user.
   * @param user the user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Getter of the activity.
   * @return the activity
   */
  @ManyToOne
//  @JsonManagedReference
  public Activity getActivity() {
    return activity;
  }

  /**
   * Setter of the activity.
   * @param activity the activity
   */
  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  /**
   * Getter of the skill level.
   * @return the skill level the user wishes to practice at
   */
  @NotNull
  public String getLevel() {
    return level;
  }

  /**
   * Setter of the skill level.
   * @param level the skill level the user wishes to practice at
   */
  public void setLevel(String level) {
    this.level = level;
  }
}
