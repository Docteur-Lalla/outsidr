package fr.istic.m2.spring;

import fr.istic.m2.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Spring controller of the REST API for the Activity entity.
 * @see Activity
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    private final ActivityRepository activityRepository;

    /**
     * Constructor setting the activity repository.
     *
     * @param activityRepository the activity repository used to send requests to the database
     */
    @Autowired
    ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    /**
     * Route used to get all the activities stored in the database in JSON format.
     *
     * @return the list of every activities in the database in JSON format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Activity> getAllActivities() {
        return this.activityRepository.findAll();
    }

    /**
     * Route used to get a Activity entity in JSON format identified by its ID.
     *
     * @param id the activity entity's ID
     * @return the activity entity in JSON format
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Activity getActivityById(@PathVariable int id) {
        return this.activityRepository.findOne(id);
    }

    /**
     * Route used to create or update a activity entity in the database via a POST request.
     *
     * @param activity the activity entity in JSON format
     * @return a HTTP 200 response if the given activity entity is valid, HTTP 400 otherwise
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Activity> saveNewActivity(@RequestBody Activity activity) {
        if (activity != null) {
            this.activityRepository.save(activity);
            return new ResponseEntity<Activity>(activity, HttpStatus.OK);
        } else {
            return new ResponseEntity<Activity>(activity, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Route used to delete an activity entity in the database via a GET request.
     *
     * @param id the activity id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public void deleteActivity(@PathVariable int id) {
        this.activityRepository.delete(id);
    }
}
