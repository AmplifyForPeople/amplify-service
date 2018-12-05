package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.DetailEstablishmentDTO;

@RequestScoped
@Path("/detailestablishmentdtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class DetailEstablishmentDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the detailestablishmentdto 
		DetailEstablishmentDTO detailestablishmentdto = new DetailEstablishmentDTO();
		
		detailestablishmentdto.setName("LocalName");
		detailestablishmentdto.setInfo("PLACEHOLDER INFO LOCAL");
		detailestablishmentdto.setImage("image.png");
		detailestablishmentdto.addGenres("001", "Pop");
		detailestablishmentdto.addGenres("002", "Rock");
		detailestablishmentdto.addGenres("003", "Dance");
		detailestablishmentdto.addSongs("001", "SongName", "image.png");
		detailestablishmentdto.addSongs("002", "SongName", "image.png");

		return Response.ok(detailestablishmentdto.toJSON()).build();
	}

}
