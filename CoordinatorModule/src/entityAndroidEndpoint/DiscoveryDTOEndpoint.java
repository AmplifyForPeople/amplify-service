package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.DiscoveryDTO;

@RequestScoped
@Path("/discoverydtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class DiscoveryDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the discoverydto 
		DiscoveryDTO discoverydto = new DiscoveryDTO();
		
		discoverydto.addEstablishments("001", "LocalName1", "Image.png");
		discoverydto.addEstablishments("002", "LocalName2", "Image.png");
		discoverydto.addEstablishments("003", "LocalName3", "Image.png");
		discoverydto.addGenres("001", "Pop");
		discoverydto.addGenres("002", "Rock");
		discoverydto.addGenres("003", "Dance");
		discoverydto.addSongs("001", "SongName1", "Image.png");
		discoverydto.addSongs("002", "SongName2", "Image.png");
		discoverydto.addSongs("003", "SongName3", "Image.png");

		
		return Response.ok(discoverydto.toJSON()).build();
	}

}
