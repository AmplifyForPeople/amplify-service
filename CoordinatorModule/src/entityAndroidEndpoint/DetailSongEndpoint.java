package entityAndroidEndpoint;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import entityAndroid.DetailSong;

@RequestScoped
@Path("/detailsongs")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class DetailSongEndpoint {
	
	private String KEY = "";

	@GET
	@Path("/{mbid:([a-zA-Z0-9_]|-)+}")
	public Response findById(@PathParam("mbid") final String mbid) {
		//TODO: retrieve the detailsong 
		DetailSong detailsong = new DetailSong();
		
		JsonObject result = null;
		//String track = "32ca187e-ee25-4f18-b7d0-3b6713f24635";		
		 try {
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key="+KEY+"&mbid="+mbid+"&format=json");
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
			
		String nameTrack = result.getJsonObject("track").getString("name");
		String author = result.getJsonObject("track").getJsonObject("artist").getString("name");
		String image = result.getJsonObject("track").getJsonObject("album").getJsonArray("image").get(2).asJsonObject().getString("#text");

		/*String album = "No found album";			
		if(result.getJsonObject("track").containsKey("album")) {
			album = result.getJsonObject("track").getJsonObject("album").getString("title");
		}*/
				
		detailsong.setName(nameTrack);
		detailsong.setAuthor(author);
		detailsong.setImage(image);
		detailsong.setGenre("SongName");
		 
		 try {
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=track.getsimilar&mbid="+mbid+"&api_key="+KEY+"&format=json");
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
		 
		 JsonArray array = result.getJsonObject("similartracks").getJsonArray("track");
			
		 int counter = 0;
		 for(int i = 0; i < array.size() && counter < 5; i++) {
			 Random rand = new Random();
			 if(0==rand.nextInt(5)){
				String idSimilar = array.get(i).asJsonObject().getString("mbid");
				String nameSimilar = array.get(i).asJsonObject().getString("name");
				String imageSimilar = array.get(i).asJsonObject().getJsonArray("image").get(2).asJsonObject().getString("#text");
				detailsong.addSongs(idSimilar, nameSimilar, imageSimilar);
				counter++;
			 }
		}
		
		return Response.ok(detailsong.toJSON()).build();
	}

}
