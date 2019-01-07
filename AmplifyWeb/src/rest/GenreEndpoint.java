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
import business_module.Genres;
import entity.Genre;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/genres")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class GenreEndpoint {

	@Inject
	Genres genres;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final int id) {	
		return Response.ok(new dtos.Genre(this.genres.findById(id))).build();
	}
	
    @POST
    public Response save(@Valid Genre genre) {
    	this.genres.create(genre);
    	return Response.ok(genre).build();
    }
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
