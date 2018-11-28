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
@Table(name = "client_amplify")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Client.FIND_ALL, query = "select g from Client g")
public class Client {

    public static final String FIND_ALL = "findAllClients";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLIENT_ID")
    @XmlTransient
    protected int id;

    @NotNull
    protected String name;

    @NotNull
    protected String password;

    @NotNull
    protected String email;

    @NotNull
    protected String phone;
    
    @OneToOne @MapsId
    Establishment establishment;
        

    @Override
    public String toString() {
        return new StringBuilder("Client [")
                .append(id).append(", ")
                .append(name).append(", ")
                .append(email).append(", ")
                .append(phone).append(", ")
                .append(establishment).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", this.id)
                .add("name", this.name)
                .add("email", this.email)
                .add("phone", this.phone)
                .add("establishment", String.valueOf(this.establishment))
                .build();
    }
}