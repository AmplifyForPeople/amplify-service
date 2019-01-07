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
import business_module.Songs;
import entity.Song;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/songs")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SongEndpoint {

	@Inject
	Songs songs;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final int id) {	
		return Response.ok(new dtos.Song(this.songs.findById(id))).build();
	}
	
    @POST
    public Response save(@Valid Song song) {
    	this.songs.create(song);
    	return Response.ok(song).build();
    }
    
//	@GET
//	public List<Song> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the songs 
//		final List<Song> songs = null;
//		return songs;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final Song song) {
//		//TODO: process the given song 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the song matching by the given id 
//		return Response.noContent().build();
//	}

}
