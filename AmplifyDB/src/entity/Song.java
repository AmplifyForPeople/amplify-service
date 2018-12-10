package entity;

import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "song_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Song.FIND_ALL, query = "select g from Song g")
public class Song {

	public static final String FIND_ALL = "findAllSongs";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SONG_ID")
	@XmlTransient
	protected int id;			
	
	@NotNull
	protected String name;
	
	@NotNull
	protected String album;
	
	@NotNull
	protected String author;

	@OneToMany(mappedBy="song")
	protected Set<PlayList> playlists;
    
	@OneToMany(mappedBy="song")
	protected Set<Vote> votes;
        
	@ManyToMany(mappedBy="songs")
	protected Set<User> users; 
    
	
	@NotNull
	protected String imatge;

	@Override
	public String toString() {
		return new StringBuilder("Song [")
				.append(id).append(", ")
				.append(name).append(", ")
				.append(album).append(", ")
				.append(imatge).append(", ")
				.append(author).append("]").toString();
	}

	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("id", this.id)
				.add("name", this.name)
				.add("album", this.album)
				.add("imatge", this.imatge)
				.add("author", this.author)
				.build();
	}

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

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<PlayList> playlists) {
		this.playlists = playlists;
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getImatge() {
		return imatge;
	}

	public void setImatge(String imatge) {
		this.imatge = imatge;
	}
	
}