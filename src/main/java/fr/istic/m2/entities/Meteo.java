package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity representing the meteo of activities for the next week-end.
 * @see Activity
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meteo {

  @JsonIgnore
  private int id;
  private boolean snowing;
  private int temperature;
  private int wave;
  private int wind;
  private City city;

  /**
   * Default constructor
   */
  public Meteo() {

  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param snowing true if it is snowing, false otherwise
   * @param temperature the temperature in degree celsius
   * @param wave the height of the waves in meters
   * @param wind the speed of the wind in Beaufort
  */
  public Meteo(boolean snowing, int temperature, int wave, int wind) {
    this.snowing = snowing;
    this.temperature = temperature;
    this.wave = wave;
    this.wind = wind;
  }

  /**
   * Getter of the ID.
   * @return the ID of the meteo entity in the database
   */
  @Id
  @NotNull
  @GeneratedValue
  public int getId() {
    return id;
  }

  /**
   * Setter of the ID.
   * @param id the ID of the meteo entity in the database
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter of the snowing attribute.
   * @return the snowing attribute of the meteo entity
   */
  @NotNull
  public boolean isSnowing() {
    return snowing;
  }

  /**
   * Setter of the snowing attribute.
   * @param snowing the snowing attribute of the meteo entity
   */
  public void setSnowing(boolean snowing) {
    this.snowing = snowing;
  }

  /**
   * Getter of the temperature.
   * @return the temperature of the meteo entity in the database
   */
  @NotNull
  public int getTemperature() {
    return temperature;
  }

  /**
   * Setter of the temperature.
   * @param temperature the temperature of the meteo entity in the database
   */
  @JsonSetter("temp")
  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }

  /**
   * Getter of the wave height.
   * @return the wave height of the meteo entity in the database
   */
  public int getWave() {
    return wave;
  }

  /**
   * Setter of the wave height.
   * @param wave the wave height of the meteo entity in the database
   */
  public void setWave(int wave) {
    this.wave = wave;
  }

  /**
   * Getter of the wind speed.
   * @return the wind speed of the meteo entity in the database
   */
  @NotNull
  public int getWind() {
    return wind;
  }

  /**
   * Setter of the wind speed.
   * @param wind the wind speed of the meteo entity in the database
   */
  @JsonSetter("speed")
  public void setWind(int wind) {
    this.wind = wind;
  }

  @ManyToOne
  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }
}
