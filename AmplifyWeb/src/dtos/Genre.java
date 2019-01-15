package dtos;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    public int id;
    public String name;
    public List<Song> songs;
    public Genre() {
    	super();
    	this.songs = new ArrayList<Song>();
    }
    public Genre(entity.Genre g) {
    	super();
    	this.id = g.getId();
    	this.name = g.getName();
    	this.songs = new ArrayList<Song>();
		for(entity.Song song : g.getSongs()) {
			Song p = new Song();
			p.votes = 0;
	    	for(entity.Vote v: song.getVotes()){
	    		p.votes += v.getLike_point();
	    	}
			p.album = song.getAlbum();
			p.name = song.getName();
			p.author = song.getAlbum();
			p.image = song.getImatge();
			p.id = song.getId();
			this.songs.add(p);
		} 
    }

    public int get_votes() {
    	int sum = 0;
    	for(dtos.Song s: this.songs) {
    		sum += s.votes;
    	}
    	return sum;
    }
    
    @Override
    public int hashCode() {
        return this.id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (!(o instanceof Genre)) {
          return false;
        }
        Genre cc = (Genre)o;
        return cc.id == this.id;
      }
}