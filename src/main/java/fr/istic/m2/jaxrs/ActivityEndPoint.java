package fr.istic.m2.jaxrs;


import fr.istic.m2.entities.Activity;
import fr.istic.m2.factory.DAOFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/activity")
public class ActivityEndPoint {
    private static final Logger logging = Logger.getLogger(ActivityEndPoint.class.getName());

    /**
     * Default URI of the endpoint, returns "OK" if reachable.
     * @return an OK response
     */
    @GET
    public Response getStatus() {
        return Response.status(Response.Status.OK).entity("OK").build();
    }

    /**
     * URI used to get every activities stored in the database
     * @return the list of every activities stored in the database
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getAllActivity() {
        List<Activity> activities = DAOFactory.getActivityDAO().findAll();
        return activities;
    }

    /**
     * URI used to get a specific activity by its ID.
     * @param id the activity ID
     * @return the activity identified by the given ID
     */
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Activity getActivityById(@PathParam("id") int id) {
        Activity activity = DAOFactory.getActivityDAO().findOne(id);
        return activity;
    }
}
