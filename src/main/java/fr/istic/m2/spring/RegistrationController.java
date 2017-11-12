package fr.istic.m2.spring;

import fr.istic.m2.entities.Activity;
import fr.istic.m2.entities.Registration;
import fr.istic.m2.entities.User;
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
@CrossOrigin(origins = "*")
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;


    /**
     * Constructor setting the registration repository.
     *
     * @param registrationRepository the registration repository used to send requests to the database
     */
    @Autowired
    RegistrationController(RegistrationRepository registrationRepository,
                           UserRepository userRepository,
                           ActivityRepository activityRepository) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
        this.activityRepository = activityRepository;
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
     * Route used to get a Registration entity in JSON format identified by its user.
     * @param id the registration entity's user ID
     * @return the registration entity in JSON format
     */
    @RequestMapping(value = "/user={id}", method = RequestMethod.GET, produces = "application/json")
    public List<Registration> getRegistrationByUser(@PathVariable int id) {
        User user = this.userRepository.findOne(id);
        return this.registrationRepository.findByUser(user);
    }

    /**
     * Route used to get a Registration entity in JSON format identified by its activity.
     * @param id the registration entity's activity ID
     * @return the registration entity in JSON format
     */
    @RequestMapping(value = "/activity={id}", method = RequestMethod.GET, produces = "application/json")
    public Registration getRegistrationByActivity(@PathVariable int id) {
        Activity activity = this.activityRepository.findOne(id);
        return this.registrationRepository.findByActivity(activity);
    }

    /**
     * Route used to create or update a registration entity in the database via a POST request.
     *
     * @param registration the registration entity in JSON format
     * @return a HTTP 200 response if the given registration entity is valid, HTTP 400 otherwise
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Registration> saveNewRegistration(@RequestBody Registration registration) {
        if (registration != null) {
            this.registrationRepository.save(registration);
            return new ResponseEntity<Registration>(registration, HttpStatus.OK);
        } else {
            return new ResponseEntity<Registration>(registration, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Route used to delete a registration entity in the database via a GET request.
     *
     * @param id the registration id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public void deleteRegistration(@PathVariable int id) {
        this.registrationRepository.delete(id);
    }
}
