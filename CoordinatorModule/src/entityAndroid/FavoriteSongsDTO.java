package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

public class FavoriteSongsDTO {
	public HashMap<String, ArrayList<String>> favoriteSongs;
	
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
}
