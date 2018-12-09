package entityAndroidEndpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import entityAndroid.Profile;

@RequestScoped
@Path("/profiles")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ProfileEndpoint {

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the profile 
		Profile profile = new Profile();
		
		profile.setAge("15");
		profile.setLocation("Lleida");
		profile.setName("Paco");
		profile.setSex("Male");
		
		return Response.ok(profile.toJSON()).build();
	}

}
