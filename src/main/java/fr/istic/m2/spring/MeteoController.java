package fr.istic.m2.spring;

import fr.istic.m2.entities.Meteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meteo")
public class MeteoController {
  private final MeteoRepository meteoRepository;

  @Autowired
  MeteoController(MeteoRepository meteoRepository) {
    this.meteoRepository = meteoRepository;
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
  public List<Meteo> getAllMeteos() {
    return this.meteoRepository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public Meteo getMeteoById(@PathVariable int id) {
    return this.meteoRepository.findOne(id);
  }
}
