package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class AmplifySite {
	public String establishment;
	public String songId;
	public String songName;
	public String songAuthor;
	public String songAlbum;
	public String songImage;
	public HashMap<String, ArrayList<String>> similarSongs = new HashMap<>();
	
	public String getEstablishment() {
		return establishment;
	}
	
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}
	
	public String getSongId() {
		return songId;
	}
	
	public void setSongId(String songId) {
		this.songId = songId;
	}
	
	public String getSongName() {
		return songName;
	}
	
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public String getSongAuthor() {
		return songAuthor;
	}
	
	public void setSongAuthor(String songAuthor) {
		this.songAuthor = songAuthor;
	}
	
	public String getSongAlbum() {
		return songAlbum;
	}
	
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}
	
	public String getSongImage() {
		return songImage;
	}
	
	public void setSongImage(String songImage) {
		this.songImage = songImage;
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
		
		Builder.add("establishment", establishment);
		Builder.add("songId", songId);
		Builder.add("songName", songName);
		Builder.add("songAuthor", songAuthor);
		Builder.add("songAlbum", songAlbum);
		Builder.add("songImage", songImage);
		
		for (String key : similarSongs.keySet()) {
			JsonObjectBuilder tmp = Json.createObjectBuilder();
			tmp.add("id", key);
			tmp.add("name", similarSongs.get(key).get(0));
			tmp.add("image", similarSongs.get(key).get(1));
			
			Array.add(tmp);
		}
		
		Builder.add("similarSongs",Array);
		
		JSONobj = Builder.build();
		
		return JSONobj;
	}
	
	public AmplifySite() {}

}
