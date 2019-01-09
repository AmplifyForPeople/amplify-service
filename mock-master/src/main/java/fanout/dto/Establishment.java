package fanout.dto;

import java.util.List;

public class Establishment {
    public int id;
    public String name;
    public String info;
    public float position_lat;
    public float position_lng;
    public String imatge;
    public List<PlayList> playlists;
    public UserInEstablishment[] userinestablishments;
    public List<Genre> genres;

}