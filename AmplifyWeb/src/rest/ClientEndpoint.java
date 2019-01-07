package rest;

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
import business_module.Clients;
import entity.Client;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/clients")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ClientEndpoint {
	
	@Inject
	Clients clients;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final int id) {	
		return Response.ok(new dtos.Client(this.clients.findById(id))).build();
	}
	
    @POST
    public Response save(@Valid Client client) {
    	this.clients.create(client);
    	return Response.ok(client).build();
    }
//
//	@GET
//	public List<Client> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the clients 
//		final List<Client> clients = null;
//		return clients;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final Client client) {
//		//TODO: process the given client 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the client matching by the given id 
//		return Response.noContent().build();
//	}

}
