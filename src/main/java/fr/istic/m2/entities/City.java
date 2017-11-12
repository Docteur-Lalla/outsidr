package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Entity representing a city where activities take place.
 *
 * @see Activity
 */
@Entity
public class City {

    private int id;
    private int cityID;
    private String name;
    private String country;

    private List<Activity> activities;
    private List<Meteo> meteos;

    /**
     * Default constructor.
     */
    public City() {
    }

    /**
     * Constructor with a parameter for each field of the class.
     *
     * @param cityID  the city's ID
     * @param name    the city's name
     * @param country the country where the city is situated
     */
    public City(int cityID, String name, String country) {
        this.cityID = cityID;
        this.name = name;
        this.country = country;
    }

    /**
     * Getter for the city's database-internal ID.
     *
     * @return the city's database-internal ID
     */
    @Id
    @NotNull
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * Getter for the city's ID.
     *
     * @return the city's ID
     */
    public int getCityID() {
        return cityID;
    }

    /**
     * Getter for the city's name.
     *
     * @return the city's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the country.
     *
     * @return the country where the city is situated
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter for the activities that take place in the city.
     *
     * @return the activities
     */
    @OneToMany(mappedBy = "city")
    @JsonBackReference
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Getter for the meteos associated with the city.
     *
     * @return the meteos
     */
    @OneToMany(mappedBy = "city")
    @JsonBackReference
    public List<Meteo> getMeteos() {
        return meteos;
    }

    /**
     * Setter for the city's database-internal ID.
     *
     * @param id the city's database-internal ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for the city's ID.
     *
     * @param cityID the city's ID
     */
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    /**
     * Setter for the city's name.
     *
     * @param name the city's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the country where the city is situated.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Setter for the activities that take place in the city.
     *
     * @param act the activities
     */
    public void setActivities(List<Activity> act) {
        this.activities = act;
    }

    /**
     * Setter for the meteos of the city.
     *
     * @param met the meteos
     */
    public void setMeteos(List<Meteo> met) {
        this.meteos = met;
    }

}
