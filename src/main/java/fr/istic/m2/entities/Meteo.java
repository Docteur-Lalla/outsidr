package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meteo {

  private int temperature;
  private int wind;
  private String description;
  private String date;

  /**
   * Default constructor
   */
  public Meteo() {

  }

  /**
   * Constructor with a parameter for each field of the class.
   * @param temperature the temperature in degree celsius
   * @param wind the speed of the wind in Beaufort
   * @param description the description of the meteo
   * @param date the date of the meteo
  */
  public Meteo(int temperature, int wind, String description, String date) {
    this.temperature = temperature;
    this.wind = wind;
    this.description = description;
    this.date = date;
  }

  /**
   * Getter of the temperature.
   * @return the temperature of the meteo
   */
  public int getTemperature() {
    return temperature;
  }

  /**
   * Setter of the temperature.
   * @param temperature the temperature of the meteo
   */
  @JsonSetter("temp")
  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }

  /**
   * Getter of the wind speed.
   * @return the wind speed of the meteo
   */
  public int getWind() {
    return wind;
  }

  /**
   * Setter of the wind speed.
   * @param wind the wind speed of the meteo
   */
  @JsonSetter("speed")
  public void setWind(int wind) {
    this.wind = wind;
  }

  /**
   * Getter of the description.
   * @return the description of the meteo
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Setter of the description.
   * @param description the description of the meteo
   */
  @JsonSetter("description")
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Getter of the date.
   * @return the date of the meteo
   */
  public String getDate() {
    return this.date;
  }

  /**
   * Setter of the date.
   * @param date the date of the meteo
   */
  @JsonSetter("dt_txt")
  public void setdate(String date) {
    this.date = date;
  }

}
