package entity;

import java.math.BigDecimal;
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

    @OneToMany(mappedBy="establishment")
    protected Set<PlayList> playlists;
    
    
    @OneToMany(mappedBy="establishment")
    protected Set<UserInEstablishment> userinestablishments;
    
    @ManyToMany(mappedBy="establishments")
    protected Set<Genre> genres; 
    
    
    //protect ? imatge;
    //protected int imatge;
    
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
                .append(position_lat).append(", ")
                .append(position_lng).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("name", this.name)
                .add("info", this.info)
                .add("position_lat", this.position_lat)
                .add("position_lng", this.position_lng)
                .build();
    }
}