package fr.istic.m2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meteo {
  private Long id;
  private Boolean snowing;
  private Integer temperature;
  private Integer wave;
  private Integer wind;

  public Meteo() {

  }

  public Meteo(Long id, Boolean snowing, Integer temperature, Integer wave, Integer wind) {
    this.id = id;
    this.snowing = snowing;
    this.temperature = temperature;
    this.wave = wave;
    this.wind = wind;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean isSnowing() {
    return snowing;
  }

  public void setSnowing(Boolean snowing) {
    this.snowing = snowing;
  }

  public Integer getTemperature() {
    return temperature;
  }

  public void setTemperature(Integer temperature) {
    this.temperature = temperature;
  }

  public Integer getWave() {
    return wave;
  }

  public void setWave(Integer wave) {
    this.wave = wave;
  }

  public Integer getWind() {
    return wind;
  }

  public void setWind(Integer wind) {
    this.wind = wind;
  }
}
