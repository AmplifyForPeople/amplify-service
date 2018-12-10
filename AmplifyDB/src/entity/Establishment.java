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
@Table(name = "establishment_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Establishment.FIND_ALL, query = "select g from Establishment g")
public class Establishment {

    public static final String FIND_ALL = "findAllEstablishments";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ESTABLISHMENT_ID")
    @XmlTransient
    protected int id;

    @NotNull
    protected String name;

    @NotNull
    protected String info;

    @NotNull
    protected float position_lat;

    @NotNull
    protected float position_lng;

    @NotNull
    protected String imatge;
    
    @OneToMany(mappedBy="establishment")
    protected Set<PlayList> playlists;
    
    
    @OneToMany(mappedBy="establishment")
    protected Set<UserInEstablishment> userinestablishments;
    
    @ManyToMany
    @JoinTable(name="EstablishmentGenres_amplify")
    protected Set<Genre> genres; 
    
    
    
    //protected String genre;
    
    
    //protected boolean isPremium = false;
    
    //@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    //private List<TasteAllergy> tasteAllergy;

    

    @Override
    public String toString() {
        return new StringBuilder("Establishment [")
                .append(id).append(", ")
                .append(name).append(", ")
                .append(info).append(", ")
                .append(imatge).append(", ")
                .append(position_lat).append(", ")
                .append(position_lng).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("name", this.name)
                .add("info", this.info)
                .add("imatge", this.imatge)
                .add("position_lat", this.position_lat)
                .add("position_lng", this.position_lng)
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

	public Set<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<PlayList> playlists) {
		this.playlists = playlists;
	}

	public Set<UserInEstablishment> getUserinestablishments() {
		return userinestablishments;
	}

	public void setUserinestablishments(Set<UserInEstablishment> userinestablishments) {
		this.userinestablishments = userinestablishments;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
    
}