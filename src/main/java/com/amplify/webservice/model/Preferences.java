package com.amplify.webservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "preferences")
public class Preferences {

    @Id
    @Column(name = "id")
    private String id;

    @Column
    private AmplifyUser user;

    @Column
    private List<String> genres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AmplifyUser getUser() {
        return user;
    }

    public void setUser(AmplifyUser user) {
        this.user = user;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
