package entityAndroid;

import java.util.ArrayList;
import java.util.HashMap;

public class AmplifySiteDTO {
	public String establishment;
	public String songId;
	public String songName;
	public String songAuthor;
	public String songAlbum;
	public String songImage;
	public HashMap<String, ArrayList<String>> similarSongs;
	
	public String getEstablishment() {
		return establishment;
	}
	
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}
	
	public String getSongId() {
		return songId;
	}
	
	public void setSongId(String name) {
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


}
