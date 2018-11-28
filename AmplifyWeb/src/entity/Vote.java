package entity;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.net.URI;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vote_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Genre.FIND_ALL, query = "select g from Vote g")
public class Vote {

    public static final String FIND_ALL = "findAllVotes";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="VOTE_ID")
    @XmlTransient
    protected int id;

    protected int like_point;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="VOTED_SONG_ID")
    protected Song song;
    
    @ManyToOne(fetch=FetchType.LAZY)
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
}