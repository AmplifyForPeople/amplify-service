package entityAndroidEndpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.Random;

import entityAndroid.Genres;


@RequestScoped
@Path("/genres")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class GenresEndpoint {

	private String KEY = "";
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the genres 
		
		Genres genres = new Genres();
		JsonObject result = null;
		
		 try {
				URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=tag.getTopTags&api_key="+KEY+"&format=json");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");				
				conn.setRequestProperty("Accept", "accept=application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				JsonReader jsonReader = Json.createReader(br);
				JsonObject object = jsonReader.readObject();
				result=object;
				jsonReader.close();
				
				conn.disconnect();

			  } catch (MalformedURLException e) { e.printStackTrace(); 
			  } catch (IOException e) { e.printStackTrace(); }
		 
		 JsonArray array = result.getJsonObject("toptags").getJsonArray("tag");
		 int counter = 0;
		 for(int i = 0; i < array.size() && counter < 5; i++) {
			 Random rand = new Random();
			 if(0==rand.nextInt(5)){
				 String nameTag = array.get(i).asJsonObject().getString("name");
				 String idTag = Integer.toString(array.get(i).asJsonObject().getInt("count"));
				 genres.addGenres(idTag, nameTag);
				 counter++;
			 }
		 }
		 
		return Response.ok(genres.toJSON()).build();
	}

}
