package dtos;

public class Genre {
    public int id;
    public String name;
    public Genre() {
    	super();
    }
    public Genre(entity.Genre g) {
    	super();
    	this.id = g.getId();
    	this.name = g.getName();
    }
}