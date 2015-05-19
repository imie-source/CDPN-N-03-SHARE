/**
 * 
 */
package fr.imie;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author imie
 *
 */
@Stateless
// @RequestScoped
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path("service")
public class TestService {

	@Inject
	PathFinder pathFinder;
	
	@Inject
	ServicePersonne servicePersonne;
	
	@GET()
	@Path("/list")
	public Response getAllMethode() {
		return Response.ok(servicePersonne.getAll()).build();
	}
	
	@GET()
	@Path("/{id}")
	public Response getOneMethode(@PathParam("id") Integer id) {
		Personne personne=servicePersonne.getById(id);
		return Response.ok(personne).build();
	}
	
	@POST()
	public Response createOneMethode(Personne personne) {
		personne=servicePersonne.create(personne);
		return Response.ok(personne).build();
	}
	
	

}
