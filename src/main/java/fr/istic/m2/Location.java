package fr.istic.m2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Location {
  private int id;
  private String name;
  private String address;
  private Activity activity;
  private Meteo meteo;

  public Location() {

  }

  public Location(int id, String name, String address, Meteo meteo) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.meteo = meteo;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @ManyToOne
  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  @OneToOne
  public Meteo getMeteo() {
    return meteo;
  }

  public void setMeteo(Meteo meteo) {
    this.meteo = meteo;
  }
}
