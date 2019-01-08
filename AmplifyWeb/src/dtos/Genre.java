package dtos;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    public int id;
    public String name;
    public List<Song> songs;
    public Genre() {
    	super();
    }
    public Genre(entity.Genre g) {
    	super();
    	this.id = g.getId();
    	this.name = g.getName();
    	this.songs = new ArrayList<Song>();
		for(entity.Song song : g.getSongs()) {
			Song p = new Song();
			p.album = song.getAlbum();
			p.name = song.getName();
			p.author = song.getAlbum();
			p.image = song.getImatge();
			p.id = song.getId();
			this.songs.add(p);
		} 
    }
}