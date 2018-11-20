package entity;

import java.util.List;

public class Establishment {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public float getLocalation() {
		return localation;
	}
	public void setLocalation(float localation) {
		this.localation = localation;
	}
	public List<Song> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<Song> playlist) {
		this.playlist = playlist;
	}
	public List<Genre> getFavorite_genre() {
		return favorite_genre;
	}
	public void setFavorite_genre(List<Genre> favorite_genre) {
		this.favorite_genre = favorite_genre;
	}
	public Song getPlaying_song() {
		return playing_song;
	}
	public void setPlaying_song(Song playing_song) {
		this.playing_song = playing_song;
	}
	public String id;
	public String email;
	public String image;
	public String name;
	public String info;
	public float localation;
	public List<Song> playlist;
	public List<Genre> favorite_genre;
	public Song playing_song;
	
	
}
