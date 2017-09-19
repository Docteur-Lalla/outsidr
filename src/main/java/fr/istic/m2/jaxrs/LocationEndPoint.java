package fr.istic.m2.jaxrs;

import fr.istic.m2.entities.Location;
import fr.istic.m2.factory.DAOFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/location")
public class LocationEndPoint {
    private static final Logger logging = Logger.getLogger(LocationEndPoint.class.getName());

    /**
     * Default URI of the endpoint, returns "OK" if reachable.
     * @return an OK response
     */
    @GET
    public Response getStatus() {
        return Response.status(Response.Status.OK).entity("OK").build();
    }

    /**
     * URI used to get every locations stored in the database
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
}
