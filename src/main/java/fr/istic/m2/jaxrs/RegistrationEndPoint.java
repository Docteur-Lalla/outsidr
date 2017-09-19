package fr.istic.m2.jaxrs;

import fr.istic.m2.entities.Registration;
import fr.istic.m2.factory.DAOFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/registration")
public class RegistrationEndPoint {
    private static final Logger logging = Logger.getLogger(RegistrationEndPoint.class.getName());

    /**
     * Default URI of the endpoint, returns "OK" if reachable.
     * @return an OK response
     */
    @GET
    public Response getStatus() {
        return Response.status(Response.Status.OK).entity("OK").build();
    }

    /**
     * URI used to get every registrations stored in the database
     * @return the list of every registrations stored in the database
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Registration> getAllRegistraton() {
        List<Registration> regs = DAOFactory.getRegistrationDAO().findAll();
        return regs;
    }

    /**
     * URI used to get a specific registration by its ID.
     * @param id the registration ID
     * @return the registration identified by the given ID
     */
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Registration getRegistrationById(@PathParam("id") int id) {
        Registration reg = DAOFactory.getRegistrationDAO().findOne(id);
        return reg;
    }
}
