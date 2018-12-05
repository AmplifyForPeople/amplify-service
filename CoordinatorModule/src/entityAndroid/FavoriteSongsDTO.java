package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class FavoriteSongsDTO {
	public HashMap<String, ArrayList<String>> favoriteSongs = new HashMap<>();
	
	public HashMap<String, ArrayList<String>> getSongs() {
		return favoriteSongs;
	}
	
	public void addSongs(String id, String name, String author, String album, String image) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		list.add(author);
		list.add(album);
		list.add(image);
		favoriteSongs.put(id, list);
	}
	
	public JsonObject toJSON() {
		JsonObject JSONobj = null;
		
		JsonObjectBuilder Builder = Json.createObjectBuilder();
		JsonArrayBuilder Array = Json.createArrayBuilder();
		
		for (String key : favoriteSongs.keySet()) {
			JsonObjectBuilder tmp = Json.createObjectBuilder();
			tmp.add("id", key);
			tmp.add("name", favoriteSongs.get(key).get(0));
			tmp.add("author", favoriteSongs.get(key).get(1));
			tmp.add("album", favoriteSongs.get(key).get(2));
			tmp.add("image", favoriteSongs.get(key).get(3));
			
			Array.add(tmp);
		}
		
		Builder.add("favoriteSongs",Array);
		JSONobj = Builder.build();
		
		return JSONobj;
		
	}
	
	public FavoriteSongsDTO() {}
}
