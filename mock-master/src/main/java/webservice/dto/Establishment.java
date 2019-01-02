package webservice.dto;

import java.util.List;

public class Establishment {

    public int id;
    public String name;
    public String info;
    public float position_lat;
    public float position_lng;
    public String imatge;
    public PlayList[] playlists;
    public UserInEstablishment[] userinestablishments;
    public Genre[] genres;

}