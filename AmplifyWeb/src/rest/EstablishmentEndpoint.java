package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import dtos.PlayList;
import business_module.Establishments;
import business_module.Genres;
import business_module.PlayLists;
import business_module.Songs;
import business_module.UserInEstablishments;
import entity.Establishment;
import entity.Genre;
import entity.Song;
import entity.User;
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
	Songs songs;
	
	@Inject
	UserInEstablishments userunestablishments;
	
	@Inject
	Genres genres;
	
	@Inject
	Users users;
	
	@Inject
	PlayLists playlists;
	
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
		Map<dtos.Genre, Integer> genres_values = get_genres_sensistive(user_id, establishment_id);
		
		return Response.ok(new dtos.Establishment(this.establishments.findById(establishment_id))).build();
	}
	
	private Map<dtos.Genre, Integer> get_genres_sensistive(int user_id, final int establishment_id){
		// Get all genres
		Map<dtos.Genre, Integer> genres_values = new HashMap<dtos.Genre, Integer>();
		for(Genre ge : this.genres.findAll()) {
			dtos.Genre g = new  dtos.Genre(ge);
			genres_values.put(g, 0);
		}
		
		// Set Establishment genres
		//dtos.Establishment current_e = new dtos.Establishment(this.establishments.findById(establishment_id));
		//for(dtos.Genre g : current_e.getGenres()) {
		//	genres_values.put(g, genres_values.get(g)+1);
		//}
		
		// Set users genres
		for(UserInEstablishment us : this.userunestablishments.findAll()) {
			dtos.User use = new  dtos.User(us.getUser());
			dtos.Establishment est = new  dtos.Establishment(us.getEstablishment());
			if(est.id==establishment_id) {
				for(dtos.Genre g: use.genres) {
					genres_values.put(g, genres_values.get(g)+1);
				}
			}
		}
		//recreate_play_list(establishment_id, genres_values);
		return genres_values;
	}
	
	private dtos.Genre get_max_and_pop(Map<dtos.Genre, Integer> genres_values) {
		int max = 0;
		dtos.Genre genre = null;
		for(Map.Entry<dtos.Genre, Integer> entry : genres_values.entrySet()) {
		    dtos.Genre key = entry.getKey();
		    Integer value = entry.getValue();
		    if(value == max || max==0  ) {
		    	max = value;
		    	genre = key;
		    }	
		 }
		genres_values.remove(genre);
		return genre;
	}
	private int getRandomElement(List<dtos.Song> songs) {
		return new Random().nextInt(songs.size());
	}
	
	private List<dtos.Song> get_songs_from_genre(dtos.Genre g, int n) {
		List<dtos.Song> songs = g.songs;
		List<dtos.Song> result_songs = new ArrayList<dtos.Song>();
		for(int i=0; i < n && 0 != songs.size(); i++) {
			int rn = getRandomElement(songs);
			result_songs.add(songs.get(rn));
			songs.remove(rn);
		}
		return result_songs;
	}
	
	private void recreate_play_list(int establishment_id, Map<dtos.Genre, Integer> genres_values) {
		List<dtos.Song> songs1 = null;
		List<dtos.Song> songs2 = null;
		List<dtos.Song> songs3 = null;
		if(genres_values.size()!=0) {songs1 = get_songs_from_genre(get_max_and_pop(genres_values),4);}
		if(genres_values.size()!=0) {songs2 = get_songs_from_genre(get_max_and_pop(genres_values),3);}
		if(genres_values.size()!=0) {songs3 = get_songs_from_genre(get_max_and_pop(genres_values),2);}
		List<dtos.Song> songs = new ArrayList<dtos.Song>();
		List<dtos.Song> result_songs = new ArrayList<dtos.Song>();
		if(songs1!=null) {songs.addAll(songs1);}
		if(songs2!=null) {songs.addAll(songs2);}
		if(songs3!=null) {songs.addAll(songs3);}
		while(0 != songs.size()) {
			int rn = getRandomElement(songs);
			result_songs.add(songs.get(rn)); // Nova llista
			songs.remove(rn);
		}
		
		for(entity.PlayList pl : this.playlists.findAll()) {
			if(pl.getEstablishment().getId() == establishment_id && !pl.isCurrent()) {
				//this.playlists.remove(this.playlists.findById(pl.getId()));
			}
		}
		
		for(dtos.Song s: result_songs) {
			entity.PlayList e_p = new entity.PlayList();
			e_p.setCurrent(false);
			e_p.setSong(this.songs.findById(s.id));
			this.playlists.create(e_p);
		}
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
