package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private String name;
    private String country;

    private List<Activity> activities;

    /**
     * Default constructor.
     */
    public City() {
    }

    /**
     * Constructor with a parameter for each field of the class.
     *
     * @param id  the city's ID
     * @param name    the city's name
     * @param country the country where the city is situated
     */
    public City(int id, String name, String country) {
        this.id = id;
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
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    /**
     * Getter for the city's name.
     *
     * @return the city's name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for the country.
     *
     * @return the country where the city is situated
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * Getter for the activities that take place in the city.
     *
     * @return the activities
     */
    @OneToMany(mappedBy = "city")
    @JsonBackReference(value="city-activity")
    public List<Activity> getActivities() {
        return activities;
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

}
