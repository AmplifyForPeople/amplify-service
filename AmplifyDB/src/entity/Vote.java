package entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "vote_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Vote.FIND_ALL, query = "select g from Vote g")
public class Vote {

    public static final String FIND_ALL = "findAllVotes";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="VOTE_ID")
    @XmlTransient
    protected int id;

    protected int like_point;

    @ManyToOne
    @JoinColumn(name="VOTED_SONG_ID")
    protected Song song;
    
    @ManyToOne
    @JoinColumn(name="USER_VOTED_ID")
    protected User user;
    

    @Override
    public String toString() {
        return new StringBuilder("Genre [")
                .append(id).append(", ")
                .append(like_point).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("like_point", this.like_point)
                .build();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLike_point() {
		return like_point;
	}

	public void setLike_point(int like_point) {
		this.like_point = like_point;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}