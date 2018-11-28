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

import entity.Client;

//Remeber to add on header "  Accept=application/json   " to try it.

@RequestScoped
@Path("/clients")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ClientEndpoint {
	
//	@POST
//	public Response create(final Client client) {
//		//TODO: process the given client 
//		//you may want to use the following return statement, assuming that Client#getId() or a similar method 
//		//would provide the identifier to retrieve the created Client resource:
//		//return Response.created(UriBuilder.fromResource(ClientEndpoint.class).path(String.valueOf(client.getId())).build()).build();
//		return Response.created(null).build();
//	}
//
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		/*try
		{
		InitialContext cxt = new InitialContext();
		if ( cxt != null )
		{
		DataSource ds = (DataSource) cxt.lookup( "java:jboss/PostgresXA");
		if ( ds == null ) strStatus = "Error while obtaining the dataSource";
		else
		{
		Connection connection = ds.getConnection();
		Statement stm = connection.createStatement();
		stm.executeUpdate("insert into exemple (code, name) values('"+strCode+"','"+strName+"')");
		connection.close();
		stm.close();
		}
		}
		}*/	
		Client client = new Client();
//		client.setEmail("test@tes.com");
//		client.setId("test_id");
//		client.setName("Test");
//		client.setPassword("test_password");
//		client.setPhone("000 000 000");
		return Response.ok(client).build();
//		TODO: retrieve the client 
//		Client client = null;
//		if (client == null) {
//			return Response.status(200).build();
//		}
//		return Response.ok(client).build();
	}
//
//	@GET
//	public List<Client> listAll(@QueryParam("start") final Integer startPosition,
//			@QueryParam("max") final Integer maxResult) {
//		//TODO: retrieve the clients 
//		final List<Client> clients = null;
//		return clients;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	public Response update(@PathParam("id") Long id, final Client client) {
//		//TODO: process the given client 
//		return Response.noContent().build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final Long id) {
//		//TODO: process the client matching by the given id 
//		return Response.noContent().build();
//	}

}
