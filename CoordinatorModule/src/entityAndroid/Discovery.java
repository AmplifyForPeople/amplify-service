package entityAndroid;

import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import java.util.ArrayList;

public class Discovery {
	public HashMap<String, ArrayList<String>> establishments = new HashMap<>();
	public HashMap<String, String> mostVotedGenres = new HashMap<>();
	public HashMap<String, ArrayList<String>> mostVotedSongs = new HashMap<>();
	
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
	
	public JsonObject toJSON() {
		JsonObject JSONobj = null;
		
		JsonObjectBuilder Builder = Json.createObjectBuilder();
		JsonArrayBuilder Array1 = Json.createArrayBuilder();
		JsonArrayBuilder Array2 = Json.createArrayBuilder();
		JsonArrayBuilder Array3 = Json.createArrayBuilder();

		
		for (String key : establishments.keySet()) {
			JsonObjectBuilder tmp1 = Json.createObjectBuilder();
			tmp1.add("id", key);
			tmp1.add("name", establishments.get(key).get(0));
			tmp1.add("image", establishments.get(key).get(1));
			
			Array1.add(tmp1);
		}
				
		for (String key : mostVotedGenres.keySet()) {
			JsonObjectBuilder tmp2 = Json.createObjectBuilder();
			tmp2.add("id", key);
			tmp2.add("name", mostVotedGenres.get(key));
			Array2.add(tmp2);
		}
		
		for (String key : mostVotedSongs.keySet()) {
			JsonObjectBuilder tmp3 = Json.createObjectBuilder();
			tmp3.add("id", key);
			tmp3.add("name", mostVotedSongs.get(key).get(0));
			tmp3.add("image", mostVotedSongs.get(key).get(1));
			Array3.add(tmp3);
		}
		
		Builder.add("establishments",Array1);
		Builder.add("mostVotedGenres",Array2);
		Builder.add("mostVotedSongs",Array3);
		
		JSONobj = Builder.build();
		
		return JSONobj;
	}
	
	public Discovery() {}
	
	
}
