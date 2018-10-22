package com.amplify.webservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "amplifyUser")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    public void setId(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
