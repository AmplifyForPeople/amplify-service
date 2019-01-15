package rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import business_module.Establishments;
import business_module.PlayLists;
import business_module.Songs;
import business_module.UserInEstablishments;
import business_module.Users;
import dtos.User;
import entity.Establishment;
import entity.Song;
import entity.UserInEstablishment;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/songs")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SongEndpoint {

	@Inject
	Songs songs;
	
	@Inject
	PlayLists playlist;
	
	@Inject
	Establishments establishment;	
	
	@Inject
	UserInEstablishments userinestablishments;
	
	
	@Inject
	Users user;
	
	
	@GET
	@Path("/{id:[0-9][0-9]*}/similar")
	public Response similar(@PathParam("id") final int id) {
		final List<dtos.Song> songs = new ArrayList<dtos.Song>();
		final List<dtos.Song> result_songs = new ArrayList<dtos.Song>();
		for(Song e: this.songs.findAll()) {
			songs.add(new dtos.Song(e));
		}
		dtos.Song so = new dtos.Song(this.songs.findById(id));
		int genre_id = so.genre_id;
		int song_id = id;
		int count = 0;
		for(dtos.Song s:songs) {
			if(s.id != song_id && s.genre_id == genre_id) {
				result_songs.add(s);
				count +=1;
				if(count == 3) {
					break;
				}
			}
		}
		return Response.ok(result_songs).build();
	}
	
	@POST
	@Path("/{id:[0-9][0-9]*}")
	public Response next(@PathParam("id") final int id) {
		entity.PlayList p = this.playlist.findById(id);
		entity.Establishment e = p.getEstablishment();
		this.playlist.remove(id);
		entity.PlayList pl = e.getPlaylists().iterator().next();
		this.playlist.set_current(pl.getId());
		return Response.ok().build();
	}

	@POST
	@Path("/{user_id:[0-9][0-9]*}/{song_id:[0-9][0-9]*}")
	public Response next(@PathParam("user_id") final int user_id, @PathParam("song_id") final int song_id) {
		this.user.add_song(user_id, song_id);
		return Response.ok().build();
	}
	
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
    
    
	private dtos.Song get_max_and_pop(List<dtos.Song> songs) {
		int max = 0;
		dtos.Song song = null;
		for(dtos.Song s: songs) {
			if(s.votes >= max || max==0  ) {
		    	max = s.votes;
		    	song = s;
		    }	
		 }
		songs.remove(song);
		return song;
	}
    
    
	@GET
	@Path("/most_voted")
	public Response listAll() {
		final List<dtos.Song> songs = new ArrayList<dtos.Song>();
		final List<dtos.Song> result_songs = new ArrayList<dtos.Song>();
		for(Song e: this.songs.mostVoted()) {
			songs.add(new dtos.Song(e));
		}
		if(songs.size()!=0) {result_songs.add(get_max_and_pop(songs));}
		if(songs.size()!=0) {result_songs.add(get_max_and_pop(songs));}
		if(songs.size()!=0) {result_songs.add(get_max_and_pop(songs));}
		return Response.ok(result_songs).build();
	}
    
	
	@GET
	@Path("/most_voted_establishment/{id:[0-9][0-9]*}")
	public Response most_voted_establishment(@PathParam("id") final int est_id) {	
		final Set<Integer> users_ids = new HashSet<Integer>();
		final Set<Integer> songs_ids = new HashSet<Integer>();
		for(UserInEstablishment uie: this.userinestablishments.findAll()) {
			if(uie.getEstablishment().getId()==est_id) {
				users_ids.add(uie.getUser().getId());
			}
		}
		for(Integer i: users_ids) {
			dtos.User u = new dtos.User(this.user.findById(i));
			for(dtos.Song s: u.songs) {
				songs_ids.add(s.id);
			}
		}
		final List<dtos.Song> songs = new ArrayList<dtos.Song>();
		final List<dtos.Song> result_songs = new ArrayList<dtos.Song>();
		for(Song e: this.songs.mostVoted()) {
			if(songs_ids.contains(e.getId())) {
				songs.add(new dtos.Song(e));
			}
		}
		if(songs.size()!=0) {result_songs.add(get_max_and_pop(songs));}
		if(songs.size()!=0) {result_songs.add(get_max_and_pop(songs));}
		if(songs.size()!=0) {result_songs.add(get_max_and_pop(songs));}
		return Response.ok(result_songs).build();
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
