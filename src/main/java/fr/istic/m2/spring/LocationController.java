package fr.istic.m2.spring;

import fr.istic.m2.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring controller of the REST API for the Location entity.
 * @see Location
 */
@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationRepository locationRepository;

    /**
     * Constructor setting the location repository.
     *
     * @param locationRepository the location repository used to send requests to the database
     */
    @Autowired
    LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Route used to get all the locations stored in the database in JSON format.
     *
     * @return the list of every locations in the database in JSON format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Location> getAllLocations() {
        return this.locationRepository.findAll();
    }

    /**
     * Route used to get a Location entity in JSON format identified by its ID.
     *
     * @param id the location entity's ID
     * @return the location entity in JSON format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Location getLocationById(@PathVariable int id) {
        return this.locationRepository.findOne(id);
    }

    /**
     * Route used to create a new location entity in the database via a POST request.
     *
     * @param location the location entity in JSON format
     * @return a HTTP 200 response if the given location entity is valid, HTTP 400 otherwise
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Location> createNewLocation(@RequestBody Location location) {
        if (location != null) {
            this.locationRepository.save(location);
            return new ResponseEntity<Location>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<Location>(location, HttpStatus.BAD_REQUEST);
        }
    }
}
