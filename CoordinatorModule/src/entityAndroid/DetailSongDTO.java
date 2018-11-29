package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailSongDTO {
	public String name;
	public String author;
	public String genre;
	public String image;
	public HashMap<String, ArrayList<String>> similarSongs;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setInfo(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
	public HashMap<String, ArrayList<String>> getSongs() {
		return similarSongs;
	}
	
	public void addSongs(String id, String name, String image) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		list.add(image);
		similarSongs.put(id, list);
	}
}
