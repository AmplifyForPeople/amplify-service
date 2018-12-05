package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entityAndroid.ProfileDTO;

@RequestScoped
@Path("/profiledtoes")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ProfileDTOEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the profiledto 
		ProfileDTO profiledto = new ProfileDTO();
		
		profiledto.setAge("15");
		profiledto.setLocation("Lleida");
		profiledto.setName("Paco");
		profiledto.setSex("Male");
		
		return Response.ok(profiledto.toJSON()).build();
	}

}
