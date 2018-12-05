package entityAndroid;

import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class GenresDTO {
	public HashMap<String, String> Genres = new HashMap<>();
	
	public HashMap<String, String> getGenres() {
		return Genres;
	}
	
	public void addGenres(String id, String name) {
		Genres.put(id, name);
	}
	
	public JsonObject toJSON() {
		JsonObject JSONobj = null;
		
		JsonObjectBuilder Builder = Json.createObjectBuilder();
		JsonArrayBuilder Array = Json.createArrayBuilder();
		
		for (String key : Genres.keySet()) {
			JsonObjectBuilder tmp = Json.createObjectBuilder();
			tmp.add("id", key);
			tmp.add("name", Genres.get(key));
			Array.add(tmp);
		}
		
		Builder.add("genres",Array);
		JSONobj = Builder.build();
		
		return JSONobj;
	}
	
	public GenresDTO() {}
	

}
