package dtos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public int user_in_e;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public float getPosition_lat() {
		return position_lat;
	}
	public void setPosition_lat(float position_lat) {
		this.position_lat = position_lat;
	}
	public float getPosition_lng() {
		return position_lng;
	}
	public void setPosition_lng(float position_lng) {
		this.position_lng = position_lng;
	}
	public String getImatge() {
		return imatge;
	}
	public void setImatge(String imatge) {
		this.imatge = imatge;
	}
	public List<PlayList> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}
	public UserInEstablishment[] getUserinestablishments() {
		return userinestablishments;
	}
	public void setUserinestablishments(UserInEstablishment[] userinestablishments) {
		this.userinestablishments = userinestablishments;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public Establishment() {
    	super();	
    }
	public Establishment(entity.Establishment e) {
		this.user_in_e = 0;
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
			p.id = play.getId();
			Song s = new Song();
			s.name = play.getSong().getName();
			s.author = play.getSong().getAlbum();
			s.image = play.getSong().getImatge();
			s.id = play.getSong().getId();
			s.album=play.getSong().getAlbum();
			s.url = play.getSong().getUrl();
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
		Set<Integer> user_in = new HashSet<>();
		for(entity.UserInEstablishment ue: e.getUserinestablishments()) {
			user_in.add(ue.getId());
		}
		this.user_in_e = user_in.size();
	}
	public int getUser_in_e() {
		return user_in_e;
	}
	public void setUser_in_e(int user_in_e) {
		this.user_in_e = user_in_e;
	}
    
}