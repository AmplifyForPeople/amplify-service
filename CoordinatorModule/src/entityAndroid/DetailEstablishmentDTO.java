package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailEstablishmentDTO {
	public String name;
	public String info;
	public String image;
	public HashMap<String, String> mostVotedGenres;
	public HashMap<String, ArrayList<String>> mostVotedSongs;
	
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
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public HashMap<String, String> getGenres() {
		return mostVotedGenres;
	}
	
	public void addGenres(String id, String name) {
		mostVotedGenres.put(id, name);
	}
	
	public HashMap<String, ArrayList<String>> getSongs() {
		return mostVotedSongs;
	}
	
	public void addSongs(String id, String name, String image) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		list.add(image);
		mostVotedSongs.put(id, list);
	}
	

}
