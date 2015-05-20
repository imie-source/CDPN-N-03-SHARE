/**
 * 
 */
package fr.imie;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;


/**
 * @author imie
 *
 */
@Stateless
// @RequestScoped
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Path("personne")
public class ServiceRestPersonne {

	@Inject
	PathFinder pathFinder;

	@Inject
	ServicePersonne servicePersonne;

	@GET()
	@Path("/list")
	public Response getAll() {
		return Response.ok(servicePersonne.getAll()).build();
	}

	@GET()
	@Path("/{id}")
	public Response getOne(@PathParam("id") Integer id) {
		Personne personne=servicePersonne.getById(id);
		return Response.ok(personne).links(personne.selfLinks()).build();
	}

	@POST()
	public Response createOne(Personne personne) {
		personne = servicePersonne.create(personne);
		return Response.ok(personne).build();
	}
	
	@PUT()
	@Path("/{id}")
	public Response updateOne(Personne personne, @PathParam("id") Integer id) {
		personne.setId(id);
		personne = servicePersonne.update(personne);
		return Response.ok(personne).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteOne(@PathParam("id") Integer id) {
		servicePersonne.delete(id);
		return Response.ok().build();
	}

}
