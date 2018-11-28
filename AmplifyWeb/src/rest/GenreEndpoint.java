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

import entity.Genre;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/genres")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class GenreEndpoint {

//	@POST
//	public Response create(final Genre genre) {
//		//TODO: process the given genre 
//		//you may want to use the following return statement, assuming that Genre#getId() or a similar method 
//		//would provide the identifier to retrieve the created Genre resource:
//		//return Response.created(UriBuilder.fromResource(GenreEndpoint.class).path(String.valueOf(genre.getId())).build()).build();
//		return Response.created(null).build();
//	}
//
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Genre genre = new Genre();
//		genre.setId(1);
//		genre.setName("GenreTest");
		return Response.ok(genre).build();
//		//TODO: retrieve the genre 
//		Genre genre = null;
//		if (genre == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.ok(genre).build();
	}
//
//	@GET
//	public List<Genre> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the genres 
//		final List<Genre> genres = null;
//		return genres;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final Genre genre) {
//		//TODO: process the given genre 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the genre matching by the given id 
//		return Response.noContent().build();
//	}

}
