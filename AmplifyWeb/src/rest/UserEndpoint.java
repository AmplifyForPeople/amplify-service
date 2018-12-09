package rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import business_module.Users;
import entity.User;

//Remember to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/users")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class UserEndpoint {

	@Inject
	Users users;
	
	@Context
    UriInfo uriInfo;

    @POST
    public Response save(@Valid User user) {
    	this.users.create(user);
    	return Response.ok(user).build();
    }
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final int id) {
		return Response.ok(this.users.findById(id)).build();
	}
//
//	@GET
//	public List<User> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the users 
//		final List<User> users = null;
//		return users;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final User user) {
//		//TODO: process the given user 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the user matching by the given id 
//		return Response.noContent().build();
//	}

}
