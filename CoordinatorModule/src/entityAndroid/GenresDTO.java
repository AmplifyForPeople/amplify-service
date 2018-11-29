package entityAndroid;

import java.util.HashMap;

public class GenresDTO {
	public HashMap<String, String> Genres;
	
	public HashMap<String, String> getGenres() {
		return Genres;
	}
	
	public void addGenres(String id, String name) {
		Genres.put(id, name);
	}
	

}
