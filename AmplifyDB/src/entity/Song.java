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
    
	//protected int imatge;

	//protected String genre;


	//protected boolean isPremium = false;

	//@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
	//private List<TasteAllergy> tasteAllergy;



	@Override
	public String toString() {
		return new StringBuilder("Song [")
				.append(id).append(", ")
				.append(name).append(", ")
				.append(album).append(", ")
				.append(author).append("]").toString();
	}

	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("id", this.id)
				.add("name", this.name)
				.add("album", this.album)
				.add("author", this.author)
				.build();
	}
}