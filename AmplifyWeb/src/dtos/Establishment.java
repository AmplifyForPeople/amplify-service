package dtos;
import java.util.ArrayList;
import java.util.List;

public class Establishment {

    public int id;
    public String name;
    public String info;
    public float position_lat;
    public float position_lng;
    public String imatge;
    public List<PlayList> playlists;
    public UserInEstablishment[] userinestablishments;
    public List<Genre> genres;

    public Establishment() {
    	super();	
    }
	public Establishment(entity.Establishment e) {
		this.id= e.getId();
		this.name = e.getName();
		this.info = e.getInfo();
		this.position_lat = e.getPosition_lat();
		this.position_lng = e.getPosition_lng();
		this.imatge = e.getImatge();
		this.playlists = new ArrayList<PlayList>();
		for(entity.PlayList play : e.getPlaylists()) {
			PlayList p = new PlayList();
			p.current = play.isCurrent();
			Song s = new Song();
			s.name = play.getSong().getName();
			s.author = play.getSong().getAlbum();
			s.image = play.getSong().getImatge();
			s.id = play.getSong().getId();
			p.song = s;
			this.playlists.add(p);
		} 
		this.genres = new ArrayList<Genre>();
		for(entity.Genre g: e.getGenres()) {
			Genre ge = new Genre();
			ge.id = g.getId();
			ge.name = g.getName();
			this.genres.add(ge);
		}
	}
    
}