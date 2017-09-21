package fr.istic.m2.jaxrs;

import fr.istic.m2.entities.Activity;
import fr.istic.m2.entities.Location;
import fr.istic.m2.entities.Meteo;
import fr.istic.m2.factory.DAOFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/location")
public class LocationEndPoint {
    private static final Logger logging = Logger.getLogger(LocationEndPoint.class.getName());

    /**
     * Default URI of the endpoint, returns "OK" if reachable.
     *
     * @return an OK response
     */
    @GET
    public Response getStatus() {
        return Response.status(Response.Status.OK).entity("OK").build();
    }

    /**
     * URI used to get every locations stored in the database
     *
     * @return the list of every locations stored in the database
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getAllLocation() {
        List<Location> locations = DAOFactory.getLocatonDAO().findAll();
        return locations;
    }

    /**
     * URI used to get a specific location by its ID.
     *
     * @param id the location ID
     * @return the location identified by the given ID
     */
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getLocationById(@PathParam("id") int id) {
        Location location = DAOFactory.getLocatonDAO().findOne(id);
        return location;
    }

    /**
     * POST method used to create a new location.
     *
     * @param name    the name of the activity
     * @param address the address of the location
     * @param act     the id of the activity in the location
     * @param met     the id of the meteo in the location
     */
    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createNewActivity(
            @FormParam("name") String name,
            @FormParam("address") String address,
            @FormParam("activity") int act,
            @FormParam("meteo") int met) {
        Activity activity = DAOFactory.getActivityDAO().findOne(act);
        Meteo meteo = DAOFactory.getMeteoDAO().findOne(met);

        Location loc = new Location(name, address, activity, meteo);
        DAOFactory.getLocatonDAO().create(loc);
    }
}
