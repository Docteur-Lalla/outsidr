package fr.istic.m2.spring;

import fr.istic.m2.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/city")
public class CityController {
    private final CityRepository cityRepository;

    /**
     * Constructor setting the city repository.
     *
     * @param cityRepository the city repository used to send requests to the database
     */
    @Autowired
    CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * Route used to get all the cities stored in the database in JSON format.
     *
     * @return the list of every cities in the database in JSON format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<City> getAllCities() {
        return this.cityRepository.findAll();
    }

    /**
     * Route used to get a City entity in JSON format identified by its ID.
     *
     * @param id the city entity's ID
     * @return the city entity in JSON format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public City getCityById(@PathVariable int id) {
        return this.cityRepository.findOne(id);
    }

    /**
     * Route used to create or update a city entity in the database via a POST request.
     *
     * @param city the city entity in JSON format
     * @return a HTTP 200 response if the given user entity is valid, HTTP 400 otherwise
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<City> saveNewUser(@RequestBody City city) {
        if (city != null) {
            this.cityRepository.save(city);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<City>(city, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Route used to delete a city entity in the database via a GET request.
     *
     * @param id the city id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public void deleteUser(@PathVariable int id) {
        this.cityRepository.delete(id);
    }
}
