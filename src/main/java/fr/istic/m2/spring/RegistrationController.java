package fr.istic.m2.spring;

import fr.istic.m2.entities.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring controller of the REST API for the Registration entity.
 * @see Registration
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;

    /**
     * Constructor setting the registration repository.
     *
     * @param registrationRepository the registration repository used to send requests to the database
     */
    @Autowired
    RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    /**
     * Route used to get all the registrations stored in the database in JSON format.
     *
     * @return the list of every registrations in the database in JSON format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Registration> getAllRegistrations() {
        return this.registrationRepository.findAll();
    }

    /**
     * Route used to get a Registration entity in JSON format identified by its ID.
     *
     * @param id the registration entity's ID
     * @return the registration entity in JSON format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Registration getRegistrationById(@PathVariable int id) {
        return this.registrationRepository.findOne(id);
    }

    /**
     * Route used to create a new registration entity in the database via a POST request.
     *
     * @param registration the registration entity in JSON format
     * @return a HTTP 200 response if the given registration entity is valid, HTTP 400 otherwise
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Registration> createNewRegistration(@RequestBody Registration registration) {
        if (registration != null) {
            this.registrationRepository.save(registration);
            return new ResponseEntity<Registration>(registration, HttpStatus.OK);
        } else {
            return new ResponseEntity<Registration>(registration, HttpStatus.BAD_REQUEST);
        }
    }
}
