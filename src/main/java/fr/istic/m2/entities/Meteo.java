package fr.istic.m2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meteo {
  private int id;
  private boolean snowing;
  private int temperature;
  private int wave;
  private int wind;

  public Meteo() {

  }

  public Meteo(int id, boolean snowing, int temperature, int wave, int wind) {
    this.id = id;
    this.snowing = snowing;
    this.temperature = temperature;
    this.wave = wave;
    this.wind = wind;
  }

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isSnowing() {
    return snowing;
  }

  public void setSnowing(boolean snowing) {
    this.snowing = snowing;
  }

  public int getTemperature() {
    return temperature;
  }

  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }

  public int getWave() {
    return wave;
  }

  public void setWave(int wave) {
    this.wave = wave;
  }

  public int getWind() {
    return wind;
  }

  public void setWind(int wind) {
    this.wind = wind;
  }
}
