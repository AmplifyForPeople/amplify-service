package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.AmplifySiteDTO;

@RequestScoped
@Path("/amplifysitedtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class AmplifySiteDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the amplifysitedto 
		AmplifySiteDTO amplifysitedto = new AmplifySiteDTO();
		
		amplifysitedto.setEstablishment("LocalName");
		amplifysitedto.setSongId("001");
		amplifysitedto.setSongName("SongName");
		amplifysitedto.setSongAlbum("AlbumName");
		amplifysitedto.setSongAuthor("SongAuthor");
		amplifysitedto.setSongImage("Image.png");
		
		amplifysitedto.addSongs("002", "Similar1", "Image.png");
		amplifysitedto.addSongs("003", "Similar2", "Image.png");
		amplifysitedto.addSongs("003", "Similar3", "Image.png");

		return Response.ok(amplifysitedto.toJSON()).build();
	}

}
