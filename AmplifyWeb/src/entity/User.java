package entity;

import java.util.List;

public class User {
	public String id;
	public String name;
	public String email;
	public int age;
	public String city;
	public List<Genre> favorite_genres;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Genre> getFavorite_genres() {
		return favorite_genres;
	}
	public void setFavorite_genres(List<Genre> favorite_genres) {
		this.favorite_genres = favorite_genres;
	}
}
