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

import entityAndroid.DetailEstablishment;

@RequestScoped
@Path("/detailestablishments")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class DetailEstablishmentEndpoint {
	
	private String KEY = "";

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the detailestablishments 
		DetailEstablishment detailestablishments = new DetailEstablishment();
		
		detailestablishments.setName("ESTABLISHMENT NAME");
		detailestablishments.setInfo("PLACEHOLDER INFO LOCAL");
		detailestablishments.setImage("NULL");
		
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
				 detailestablishments.addGenres(idTag, nameTag);
				 counter++;
			 }
		 }
		
			
		 
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
			
		 array = result.getJsonObject("tracks").getJsonArray("track");
		 counter = 0;
		JsonObject trackJson = null;
		
		 for(int i = 0; i < array.size() && counter < 5; i++) {
			 Random rand = new Random();
			 if(0==rand.nextInt(5)){
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
					trackJson = jsonReader.readObject();

					jsonReader.close();
						
					conn.disconnect();

				} catch (MalformedURLException e) { e.printStackTrace(); 
				} catch (IOException e) { e.printStackTrace(); }

				String idTrack = "NULL";
				if(trackJson.getJsonObject("track").containsKey("mbid")) {
					idTrack = trackJson.getJsonObject("track").getString("mbid");
				}
				String image = "NULL"; 
				if(trackJson.getJsonObject("track").containsKey("mbid")) {
					image = array.get(i).asJsonObject().getJsonArray("image").get(2).asJsonObject().getString("#text");
				}
				detailestablishments.addSimilarSongs(idTrack, nameTrack, image);
				counter++;
			 }
		 }
		

		return Response.ok(detailestablishments.toJSON()).build();
	}

}
