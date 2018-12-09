package entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "userinestablishment_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = UserInEstablishment.FIND_ALL, query = "select g from PlayList g")
public class UserInEstablishment {

    public static final String FIND_ALL = "findAllUserInEstablishment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USERINESTABLISHMENT_ID")
    @XmlTransient
    protected int id;

    //@NotNull
    //protected date date;

    @ManyToOne
    @JoinColumn(name="ESTABLISHMENT_VISIT_ID")
    protected Establishment establishment;
    
    
    @ManyToOne
    @JoinColumn(name="USER_VISITOR_ID")
    protected User user;
        
    
    @Override
    public String toString() {
        return new StringBuilder("UserInEstablishment [")
        		.append(id).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .build();
    }
}