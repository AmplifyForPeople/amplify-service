package dtos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {

    public int id;

    public String name;

    public String password;

    public String email;

    public int age;

    public String city;

    public Establishment establishment;

    public List<Vote> votes;

    public List<Genre> genres;

    public List<Song> songs;
    
    
    public User() {
    	super();
    }
    
    public User(entity.User u) {
    	this.name = u.getName();
    	this.id = u.getId();
    	this.password = u.getPassword();
    	this.email = u.getEmail();
    	this.age = u.getAge();
    	Iterator<entity.UserInEstablishment> iter = u.getUserinestablishment().iterator();
    	if(iter.hasNext()) {
    		this.establishment = new Establishment(iter.next().getEstablishment());
    	}
		this.votes = new ArrayList<Vote>();
		for(entity.Vote v:u.getVotes()) {
    		dtos.Vote vo = new dtos.Vote();
    		vo.song_id = v.getSong().getId();
    		vo.id = v.getId();
    		vo.like_point = v.getLike_point();
    		this.votes.add(vo);
    	}
    	this.genres = new ArrayList<Genre>();
    	for(entity.Genre g:u.getGenres()) {
    		Genre ge = new Genre();
    		ge.id=g.getId();
    		ge.name = g.getName();
    		this.genres.add(ge);
    	}
    	this.songs = new ArrayList<Song>();
    	for(entity.Song s:u.getSongs()) {
    		Song so = new Song();
    		so.id = s.getId();
    		so.name = s.getName();
    		so.album = s.getAlbum();
    		so.author = s.getAuthor();
    		so.image = s.getImatge();
    		this.songs.add(so);
    	}
    }
    
    

}