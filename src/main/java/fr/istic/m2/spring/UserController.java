package fr.istic.m2.spring;

import fr.istic.m2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring controller of the REST API for the User entity.
 * @see User
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    /**
     * Constructor setting the user repository.
     *
     * @param userRepository the user repository used to send requests to the database
     */
    @Autowired
    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Route used to get all the users stored in the database in JSON format.
     *
     * @return the list of every users in the database in JSON format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    /**
     * Route used to get a User entity in JSON format identified by its ID.
     *
     * @param id the user entity's ID
     * @return the user entity in JSON format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUserById(@PathVariable int id) {
        return this.userRepository.findOne(id);
    }

    /**
     * Route used to create or update a user entity in the database via a POST request.
     *
     * @param user the user entity in JSON format
     * @return a HTTP 200 response if the given user entity is valid, HTTP 400 otherwise
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> saveNewUser(@RequestBody User user) {
        if (user != null) {
            this.userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Route used to delete a user entity in the database via a GET request.
     *
     * @param id the user id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public void deleteUser(@PathVariable int id) {
        this.userRepository.delete(id);
    }
}
