package fr.istic.m2;

import javax.persistence.*;
import java.io.Serializable;

class CompositeKey implements Serializable {
  private User user;
  private Activity activity;

  public CompositeKey() {

  }

  public CompositeKey(User user, Activity activity) {
    this.user = user;
    this.activity = activity;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }
}

@Entity
@IdClass(CompositeKey.class)
public class Registration {
  private User user;
  private Activity activity;
  private String level;

  public Registration() {

  }

  public Registration(User user, Activity activity, String level) {
    this.user = user;
    this.activity = activity;
    this.level = level;
  }


  @ManyToOne
  @Id
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToOne
  @Id
  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }
}
