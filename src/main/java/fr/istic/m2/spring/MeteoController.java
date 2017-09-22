package fr.istic.m2.spring;

import fr.istic.m2.entities.Meteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring controller of the REST API for the Meteo entity.
 *
 * @see Meteo
 */
@RestController
@RequestMapping("/meteo")
public class MeteoController {
  private final MeteoRepository meteoRepository;

  /**
   * Constructor setting the meteo repository.
   *
   * @param meteoRepository the meteo repository used to send requests to the database
   */
  @Autowired
  MeteoController(MeteoRepository meteoRepository) {
    this.meteoRepository = meteoRepository;
  }

  /**
   * Route used to get all the meteos stored in the database in JSON format.
   *
   * @return the list of every meteos in the database in JSON format
   */
  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
  public List<Meteo> getAllMeteos() {
    return this.meteoRepository.findAll();
  }

  /**
   * Route used to get a Meteo entity in JSON format identified by its ID.
   *
   * @param id the meteo entity's ID
   * @return the meteo entity in JSON format
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public Meteo getMeteoById(@PathVariable int id) {
    return this.meteoRepository.findOne(id);
  }

  /**
   * Route used to create a new meteo entity in the database via a POST request.
   *
   * @param meteo the meteo entity in JSON format
   * @return a HTTP 200 response if the given meteo entity is valid, HTTP 400 otherwise
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<Meteo> createNewMeteo(@RequestBody Meteo meteo) {
    if (meteo != null) {
      this.meteoRepository.save(meteo);
      return new ResponseEntity<Meteo>(meteo, HttpStatus.OK);
    } else {
      return new ResponseEntity<Meteo>(meteo, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Route used to delete a meteo entity in the database via a GET request.
   *
   * @param id the meteo id
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
  public void deleteMeteo(@PathVariable int id) {
    this.meteoRepository.delete(id);
  }
}
