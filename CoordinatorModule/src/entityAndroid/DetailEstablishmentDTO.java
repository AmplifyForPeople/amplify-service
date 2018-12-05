package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class DetailEstablishmentDTO {
	public String name;
	public String info;
	public String image;
	public HashMap<String, String> mostVotedGenres = new HashMap<>();
	public HashMap<String, ArrayList<String>> mostVotedSongs = new HashMap<>();
	
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
	
	public JsonObject toJSON() {
		JsonObject JSONobj = null;
		
		JsonObjectBuilder Builder = Json.createObjectBuilder();
		JsonArrayBuilder Array1 = Json.createArrayBuilder();
		JsonArrayBuilder Array2 = Json.createArrayBuilder();

		
		Builder.add("name",name);
		Builder.add("info",info);
		Builder.add("image",image);
				
		for (String key : mostVotedGenres.keySet()) {
			JsonObjectBuilder tmp1 = Json.createObjectBuilder();
			tmp1.add("id", key);
			tmp1.add("name", mostVotedGenres.get(key));
			Array1.add(tmp1);
		}
		
		for (String key : mostVotedSongs.keySet()) {
			JsonObjectBuilder tmp2 = Json.createObjectBuilder();
			tmp2.add("id", key);
			tmp2.add("name", mostVotedSongs.get(key).get(0));
			tmp2.add("image", mostVotedSongs.get(key).get(1));
			Array2.add(tmp2);
		}
		
		Builder.add("mostVotedGenres",Array1);
		Builder.add("mostVotedSongs",Array2);
		
		JSONobj = Builder.build();
		
		return JSONobj;
	}
	
	public DetailEstablishmentDTO() {}

}
