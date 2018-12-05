package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.FavoriteSongsDTO;

@RequestScoped
@Path("/favoritesongsdtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class FavoriteSongsDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the favoritesongsdto 
		FavoriteSongsDTO favoritesongsdto = new FavoriteSongsDTO();
		
		favoritesongsdto.addSongs("001", "SongName1", "SongAuthor1", "SongAlbum1", "Image.png");
		favoritesongsdto.addSongs("002", "SongName2", "SongAuthor2", "SongAlbum2", "Image.png");
		favoritesongsdto.addSongs("003", "SongName3", "SongAuthor3", "SongAlbum3", "Image.png");
		favoritesongsdto.addSongs("004", "SongName4", "SongAuthor4", "SongAlbum4", "Image.png");
		favoritesongsdto.addSongs("005", "SongName5", "SongAuthor5", "SongAlbum5", "Image.png");

		return Response.ok(favoritesongsdto.toJSON()).build();
	}

}
