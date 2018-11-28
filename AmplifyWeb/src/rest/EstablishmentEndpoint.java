package rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entity.Establishment;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/establishments")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class EstablishmentEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Establishment est = new Establishment();
//		est.setId("test_id");
//		est.setEmail("test@test.com");
//		est.setInfo("Test test test test test test");
//		est.setName("TestEstablishName");
//		est.setLocalation(1);
//		est.setFavorite_genre(null);
//		est.setImage("TestImg.jpg");
//		est.setPlaying_song(null);
//		est.setPlaylist(null);
		return Response.ok(est).build();
//		//TODO: retrieve the establishment 
//		Establishment establishment = null;
//		if (establishment == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.ok(establishment).build();
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
//	@GET
//	public List<Establishment> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the establishments 
//		final List<Establishment> establishments = null;
//		return establishments;
//	}
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
