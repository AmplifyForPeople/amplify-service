package fanout.dto;


import java.util.List;

public class User {
    public int id;

    public String name;

    public String password;

    public String email;

    public int age;

    public String city;

    public Establishment establishment;

    public List<Vote> votes;

    public List<Genre> genres;

    public List<Song> songs;
}