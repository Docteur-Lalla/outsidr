package fr.istic.m2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class City {

    @JsonIgnore
    private int id;
    private int cityID;
    private String name;
    private String country;

    private List<Activity> act;
    private List<Meteo> met;

    public City(){}

    public City(int cityID, String name, String country){
        this.cityID = cityID;
        this.name = name;
        this.country = country;
    }

    @Id
    @NotNull
    @GeneratedValue
    public int getId() {
        return id;
    }

    public int getCityID() {
        return cityID;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @OneToMany(mappedBy = "city")
    public List<Activity> getAct() {
        return act;
    }

    @OneToMany(mappedBy = "city")
    public List<Meteo> getMet() {
        return met;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAct(List<Activity> act) {
        this.act = act;
    }

    public void setMet(List<Meteo> met) {
        this.met = met;
    }

}
