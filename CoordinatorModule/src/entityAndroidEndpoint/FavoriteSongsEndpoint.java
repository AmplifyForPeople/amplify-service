package entityAndroidEndpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

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
import entityAndroid.FavoriteSongs;

@RequestScoped
@Path("/favoritesongs")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class FavoriteSongsEndpoint {
	
	private String KEY = "";


	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the favoritesongs
		FavoriteSongs favoritesongs = new FavoriteSongs();
		
		JsonObject result = null;
		
		 try {
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key="+KEY+"&format=json");
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
			
		 JsonArray array = result.getJsonObject("tracks").getJsonArray("track");
		 int counter = 0;
		 
		JsonObject albumJson = null;
		 for(int i = 0; i < array.size() && counter < 7; i++) {
			 Random rand = new Random();
			 if(0==rand.nextInt(3)){
				String nameTrack = array.get(i).asJsonObject().getString("name");
				String author = array.get(i).asJsonObject().getJsonObject("artist").getString("name");				
				 try {
						URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key="+KEY+"&artist="+author+"&track="+nameTrack+"&format=json");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");				
						conn.setRequestProperty("Accept", "accept=application/json");
				
						if (conn.getResponseCode() != 200) {
							throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
						}
				
						BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
						JsonReader jsonReader = Json.createReader(br);
						albumJson = jsonReader.readObject();

						jsonReader.close();
						
						conn.disconnect();

					} catch (MalformedURLException e) { e.printStackTrace(); 
					} catch (IOException e) { e.printStackTrace(); }


				String idTrack = "NULL";
				if(albumJson.getJsonObject("track").containsKey("mbid")) {
					idTrack =albumJson.getJsonObject("track").getString("mbid");
				}
				 String album = "NULL";
				if(albumJson.getJsonObject("track").containsKey("album")) {
					album = albumJson.getJsonObject("track").getJsonObject("album").getString("title");
				}
				
				String image = "NULL";
				if(albumJson.getJsonObject("track").containsKey("image")) {
					image =albumJson.getJsonObject("track").getJsonArray("image").get(2).asJsonObject().getString("#text");
				}
				
				favoritesongs.addSongs(idTrack, nameTrack, author, album, image);
				 counter++;
			 }
		 }

		return Response.ok(favoritesongs.toJSON()).build();
	}

}
