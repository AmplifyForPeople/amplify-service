package entity;


import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

@Entity
@Table(name = "genre_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Genre.FIND_ALL, query = "select g from Genre g")
public class Genre {

    public static final String FIND_ALL = "findAllGenres";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GENRE_ID")
    @XmlTransient
    protected int id;

    @NotNull
    protected String name;

    
    @ManyToMany(mappedBy="genres")
    protected Set<Establishment> establishments;
    
    @ManyToMany(mappedBy="genres")
    protected Set<User>  users;
    
	@OneToMany(mappedBy="genre")
	protected Set<Song> songs;
    
    @Override
    public String toString() {
        return new StringBuilder("Genre [")
                .append(id).append(", ")
                .append(name).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("name", this.name)
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

	public Set<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(Set<Establishment> establishments) {
		this.establishments = establishments;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
}