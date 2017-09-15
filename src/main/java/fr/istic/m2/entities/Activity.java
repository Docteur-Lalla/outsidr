package fr.istic.m2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Activity {
  private int id;
  private String name;
  private List<Location> location;
  private List<Registration> registration;

  public Activity() {

  }

  public Activity(String name, List<Location> location, List<Registration> registration) {
    this.name = name;
    this.location = location;
    this.registration = registration;
  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToMany
  public List<Location> getLocation() {
    return location;
  }

  public void setLocation(List<Location> location) {
    this.location = location;
  }

  @OneToMany
  public List<Registration> getRegistration() {
    return registration;
  }

  public void setRegistration(List<Registration> registration) {
    this.registration = registration;
  }
}
