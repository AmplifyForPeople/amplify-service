package entityAndroid;

import java.util.HashMap;
import java.util.ArrayList;

public class DiscoveryDTO {
	public HashMap<String, ArrayList<String>> establishments;
	public HashMap<String, String> mostVotedGenres;
	public HashMap<String, ArrayList<String>> mostVotedSongs;
	
	public HashMap<String, ArrayList<String>> getEstablishments() {
		return establishments;
	}
	
	public void addEstablishments(String id, String name, String image) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		list.add(image);
		establishments.put(id, list);
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
