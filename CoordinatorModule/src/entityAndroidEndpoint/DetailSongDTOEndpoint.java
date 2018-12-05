package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.DetailSongDTO;

@RequestScoped
@Path("/detailsongdtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class DetailSongDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the detailsongdto 
		DetailSongDTO detailsongdto = new DetailSongDTO();
		
		detailsongdto.setName("SongName");
		detailsongdto.setAuthor("AuthorName");
		detailsongdto.setGenre("SongName");
		detailsongdto.setImage("Image.png");
		detailsongdto.addSongs("001", "Similar1", "Image.png");
		detailsongdto.addSongs("002", "Similar2", "Image.png");
		detailsongdto.addSongs("003", "Similar3", "Image.png");


		

		return Response.ok(detailsongdto.toJSON()).build();
	}

}
