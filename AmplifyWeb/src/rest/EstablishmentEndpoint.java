package rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import business_module.Users;
import business_module.Establishments;
import business_module.UserInEstablishments;
import entity.Establishment;
import entity.UserInEstablishment;
//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/establishments")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class EstablishmentEndpoint {

	@Inject
	Establishments establishments;
	
	@Inject
	UserInEstablishments userunestablishments;
	
	@Inject
	Users users;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final int id) {	
		return Response.ok(new dtos.Establishment(this.establishments.findById(id))).build();
	}
	
	@POST
	@Path("/go_in/{user_id:[0-9][0-9]*}/{establishment_id:[0-9][0-9]*}")
	public Response go_in(@PathParam("user_id") final int user_id, @PathParam("establishment_id") final int establishment_id) {
		UserInEstablishment u = new UserInEstablishment();
		u.setUser(this.users.findById(user_id));
		u.setEstablishment(this.establishments.findById(establishment_id));
		this.userunestablishments.create(u);
		return Response.ok(new dtos.Establishment(this.establishments.findById(establishment_id))).build();
	}
	
	
    @POST
    public Response save(@Valid Establishment establishment) {
    	this.establishments.create(establishment);
    	return Response.ok(establishment).build();
    }
	
//	@POST
//	public Response create(final Establishment establishment) {
//		//TODO: process the given establishment 
//		//you may want to use the following return statement, assuming that Establishment#getId() or a similar method 
//		//would provide the identifier to retrieve the created Establishment resource:
//		//return Response.created(UriBuilder.fromResource(EstablishmentEndpoint.class).path(String.valueOf(establishment.getId())).build()).build();
//		return Response.created(null).build();
//	}
//
//
	@GET
	public Response listAll() {
		final List<dtos.Establishment> establishments = new ArrayList<dtos.Establishment>();
		for(Establishment e: this.establishments.findAll()) {
			establishments.add(new dtos.Establishment(e));
		}
		return Response.ok(establishments).build();
	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final Establishment establishment) {
//		//TODO: process the given establishment 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the establishment matching by the given id 
//		return Response.noContent().build();
//	}

}
