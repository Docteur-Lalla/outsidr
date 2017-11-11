package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Class embedding the composite key for the Registration entity.
 * @see Registration
 */
class CompositeKey implements Serializable {
  private User user;
  private Activity activity;

  /**
   * Default constructor
   */
  public CompositeKey() {

  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param user the user
   * @param activity the activity the user is registered in
   */
  public CompositeKey(User user, Activity activity) {
    this.user = user;
    this.activity = activity;
  }

  /**
   * Getter of the user.
   * @return the user
   */
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
}

/**
 * Class representing the association of a user and an activity in the database.
 * @see User
 * @see Activity
 */
@Entity
@IdClass(CompositeKey.class)
public class Registration {
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
   * Getter of the user.
   * @return the user
   */
  @ManyToOne
  @Id
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
  @Id
  @JsonManagedReference
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
