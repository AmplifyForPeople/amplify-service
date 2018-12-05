package entityAndroid;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class ProfileDTO {
	public String name;
	public String age;
	public String sex;
	public String location;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public JsonObject toJSON() {
		JsonObject JSONobj = null;
		
		JsonObjectBuilder Builder = Json.createObjectBuilder();
		Builder.add("name",name);
		Builder.add("age",age);
		Builder.add("sex",sex);
		Builder.add("location",location);
		JSONobj = Builder.build();
		
		return JSONobj;
	}
	
	public ProfileDTO() {}


}
