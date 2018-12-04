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
@Table(name = "user_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = User.FIND_ALL, query = "select g from User g")
public class User {

    public static final String FIND_ALL = "findAllUsers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="USER_ID")
    @XmlTransient
    protected int id;

    @NotNull
    protected String name;

    @NotNull
    protected String password;

    @NotNull
    protected String email;

    @NotNull
    protected int age;
    
    @NotNull
    protected String city;
    
    @OneToMany(mappedBy="user")
    protected Set<UserInEstablishment> userinestablishment;
    
    @OneToMany(mappedBy="user")
    protected Set<Vote> votes;
    
    @ManyToMany
    @JoinTable(name="UserGenres_amplify")
    protected Set<Genre>  genres; 
    
    @ManyToMany
    @JoinTable(name="FavoriteSongs_amplify")
    protected Set<Song> songs; 
    
    //protected boolean isPremium = false;
    
    //@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    //private List<TasteAllergy> tasteAllergy;

    

    @Override
    public String toString() {
        return new StringBuilder("User [")
                .append(id).append(", ")
                .append(name).append(", ")
                .append(age).append(", ")
                .append(email).append(", ")
                .append(city).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("name", this.name)
                .add("age", this.age)
                .add("email", this.email)
                .add("city", this.city)
                .build();
    }
}