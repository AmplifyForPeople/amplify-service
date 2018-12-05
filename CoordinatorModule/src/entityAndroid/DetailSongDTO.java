package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class DetailSongDTO {
	public String name;
	public String author;
	public String genre;
	public String image;
	public HashMap<String, ArrayList<String>> similarSongs = new HashMap<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
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
	
	public JsonObject toJSON() {
		
JsonObject JSONobj = null;
		
		JsonObjectBuilder Builder = Json.createObjectBuilder();
		JsonArrayBuilder Array = Json.createArrayBuilder();
		
		Builder.add("name", name);
		Builder.add("author", author);
		Builder.add("genre", genre);
		Builder.add("image", image);

		
		for (String key : similarSongs.keySet()) {
			JsonObjectBuilder tmp1 = Json.createObjectBuilder();
			tmp1.add("id", key);
			tmp1.add("name", similarSongs.get(key).get(0));
			tmp1.add("image", similarSongs.get(key).get(1));
			
			Array.add(tmp1);
		}
		
		Builder.add("similarSongs",Array);
		
		JSONobj = Builder.build();
		
		return JSONobj;
	}
	
	public DetailSongDTO() {}
}
