package entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "playlist_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = PlayList.FIND_ALL, query = "select g from PlayList g")
public class PlayList {

    public static final String FIND_ALL = "findAllPlayLists";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PLAY_LIST_ID")
    @XmlTransient
    protected int id;

    @NotNull
    protected boolean current;


    @ManyToOne
    @JoinColumn(name="ESTABLISHMENT_OWNER_ID")
    protected Establishment establishment;
    
    @ManyToOne
    @JoinColumn(name="SONG_OWNER_ID")
    protected Song song;
       
    @Override
    public String toString() {
        return new StringBuilder("PlayList [")
        		.append(current).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("current", this.current)
                .build();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public Establishment getEstablishment() {
		return this.establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
    
}