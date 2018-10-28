package com.amplify.webservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String location;

    @Column
    private List<AmplifyUser> users;

    @Column
    private Statistics statistics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<AmplifyUser> getUsers() {
        return users;
    }

    public void setUsers(List<AmplifyUser> users) {
        this.users = users;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
