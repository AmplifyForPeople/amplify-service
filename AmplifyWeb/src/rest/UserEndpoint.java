package rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entity.User;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/users")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class UserEndpoint {

//	@POST
//	public Response create(final User user) {
//		//TODO: process the given user 
//		//you may want to use the following return statement, assuming that User#getId() or a similar method 
//		//would provide the identifier to retrieve the created User resource:
//		//return Response.created(UriBuilder.fromResource(UserEndpoint.class).path(String.valueOf(user.getId())).build()).build();
//		return Response.created(null).build();
//	}
//
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		User user = new User();
		user.setAge(15);
		user.setCity("CityTets");
		user.setEmail("test@test.com");
		user.setFavorite_genres(null);
		user.setId("TestIdUser");
		user.setName("TestUserName");
		return Response.ok(user).build();
//		//TODO: retrieve the user 
//		User user = null;
//		if (user == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.ok(user).build();
	}
//
//	@GET
//	public List<User> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the users 
//		final List<User> users = null;
//		return users;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final User user) {
//		//TODO: process the given user 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the user matching by the given id 
//		return Response.noContent().build();
//	}

}
