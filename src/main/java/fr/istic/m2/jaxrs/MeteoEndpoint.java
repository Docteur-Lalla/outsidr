package fr.istic.m2.jaxrs;

import fr.istic.m2.entities.Meteo;
import fr.istic.m2.factory.DAOFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

/**
 * Meteo-related endpoint of the REST API.
 * /meteo is the default URI, it is used for debug purpose.
 * /meteo/all returns the list of each meteo stored in the database.
 * /meteo/id/{id} returns the meteo identified by the given id.
 * @see Meteo
 */
@Path("/meteo")
public class MeteoEndpoint {
  private static final Logger logging = Logger.getLogger(MeteoEndpoint.class.getName());

  /**
   * Default URI of the endpoint, returns "OK" if reachable.
   * @return an OK response
   */
  @GET
  public Response getStatus() {
    return Response.status(Response.Status.OK).entity("OK").build();
  }

  /**
   * URI used to get every meteos stored in the database
   * @return the list of every meteos stored in the database
   */
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Meteo> getAllMeteos() {
    List<Meteo> meteos = DAOFactory.getMeteoDAO().findAll();
    return meteos;
  }

  /**
   * URI used to get a specific meteo by its ID.
   * @param id the meteo ID
   * @return the meteo identified by the given ID
   */
  @GET
  @Path("/id/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Meteo getMeteoById(@PathParam("id") int id) {
    Meteo meteo = DAOFactory.getMeteoDAO().findOne(id);
    return meteo;
  }
}
