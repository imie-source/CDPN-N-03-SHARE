/**
 * 
 */
package fr.imie;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author imie
 *
 */
@Stateless
//@RequestScoped
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path("service2")
public class TestService2 {

	@GET()
	@Path("pathToGet/{id}/{other}")
	public Response getMethode() {
		return Response.ok("HI").build();
	}
	
}
