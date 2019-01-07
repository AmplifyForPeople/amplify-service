package dtos;

public class Song {

    public int id;

    public String name;

    public String album;

    public String author;

    public int votes;

    public String image;

    public Song() {
    	super();
    }
    
    public Song(entity.Song s) {
    	super();
    	this.id = s.getId();
    	this.name = s.getName();
    	this.album = s.getAuthor();
    	this.author = s.getAlbum();
    	this.image = s.getImatge();
    	this.votes = 0;
    	for(entity.Vote v: s.getVotes()){
    		this.votes += v.getLike_point();
    	}
    }
    
}