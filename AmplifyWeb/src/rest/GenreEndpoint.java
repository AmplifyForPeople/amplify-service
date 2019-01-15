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
import business_module.Genres;
import entity.Genre;
import entity.Song;

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
    
    
	private dtos.Genre get_max_and_pop(List<dtos.Genre> genres) {
		int max = 0;
		dtos.Genre genre = null;
		for(dtos.Genre g: genres) {
			if(g.get_votes() >= max || max==0  ) {
		    	max = g.get_votes();
		    	genre = g;
		    }	
		 }
		genres.remove(genre);
		return genre;
	}
    
	
	@GET
	@Path("/most_voted")
	public Response listAll() {
		final List<dtos.Genre> genres = new ArrayList<dtos.Genre>();
		final List<dtos.Genre> result_genres = new ArrayList<dtos.Genre>();
		for(Genre e: this.genres.mostVoted()) {
			genres.add(new dtos.Genre(e));
		}
		if(genres.size()!=0) {result_genres.add(get_max_and_pop(genres));}
		if(genres.size()!=0) {result_genres.add(get_max_and_pop(genres));}
		if(genres.size()!=0) {result_genres.add(get_max_and_pop(genres));}
		return Response.ok(result_genres).build();
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
