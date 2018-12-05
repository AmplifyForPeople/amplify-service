package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.GenresDTO;

@RequestScoped
@Path("/genresdtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class GenresDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the genresdto 
		GenresDTO genresdto = new GenresDTO();
		
		genresdto.addGenres("001", "Pop");
		genresdto.addGenres("002", "Rock");
		genresdto.addGenres("003", "Dance");
		genresdto.addGenres("004", "Disco");
		
		return Response.ok(genresdto.toJSON()).build();
	}

}
