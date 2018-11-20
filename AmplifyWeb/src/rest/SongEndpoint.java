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

import entity.Song;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/songs")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SongEndpoint {

//	@POST
//	public Response create(final Song song) {
//		//TODO: process the given song 
//		//you may want to use the following return statement, assuming that Song#getId() or a similar method 
//		//would provide the identifier to retrieve the created Song resource:
//		//return Response.created(UriBuilder.fromResource(SongEndpoint.class).path(String.valueOf(song.getId())).build()).build();
//		return Response.created(null).build();
//	}
//
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Song song = new Song();
		song.setAlbum("AlbumTest");
		song.setAuthor("Manolo");
		song.setGenre(null);
		song.setGlobal_dislike(100);
		song.setGlobal_like(100);
		song.setId("SongIdTest");
		song.setImage("ImatgeTest.jpg");
		song.setName("TestSong");
		song.setSimilars(null);
		
		return Response.ok(song).build();
//		//TODO: retrieve the song 
//		Song song = null;
//		if (song == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.ok(song).build();
	}
//
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
