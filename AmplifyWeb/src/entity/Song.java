package entity;
import java.util.List;

public class Song {
	public String id;
	public String name;
	public String album;
	public String author;
	public String image;
	public List<Song> similars;
	public int global_like;
	public int global_dislike;
	//TODO establiment like
	//Todo establiment dislike
	public Genre genre;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Song> getSimilars() {
		return similars;
	}
	public void setSimilars(List<Song> similars) {
		this.similars = similars;
	}
	public int getGlobal_like() {
		return global_like;
	}
	public void setGlobal_like(int global_like) {
		this.global_like = global_like;
	}
	public int getGlobal_dislike() {
		return global_dislike;
	}
	public void setGlobal_dislike(int global_dislike) {
		this.global_dislike = global_dislike;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
