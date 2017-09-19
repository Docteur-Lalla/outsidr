package fr.istic.m2.jaxrs;

import fr.istic.m2.entities.User;
import fr.istic.m2.factory.DAOFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/user")
public class UserEndPoint {
    private static final Logger logging = Logger.getLogger(UserEndPoint.class.getName());

    /**
     * Default URI of the endpoint, returns "OK" if reachable.
     * @return an OK response
     */
    @GET
    public Response getStatus() {
        return Response.status(Response.Status.OK).entity("OK").build();
    }

    /**
     * URI used to get every users stored in the database
     * @return the list of every users stored in the database
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        List<User> users = DAOFactory.getUserDAO().findAll();
        return users;
    }

    /**
     * URI used to get a specific user by its ID.
     * @param id the user ID
     * @return the user identified by the given ID
     */
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") int id) {
        User user = DAOFactory.getUserDAO().findOne(id);
        return user;
    }
}
