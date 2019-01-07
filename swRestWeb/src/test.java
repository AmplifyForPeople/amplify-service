import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("class1")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class test {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String hello()
	{
		// http://localhost:8080/swRestWeb/rest/class1/text
		return "Hello World";
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json/{username}")
	public BeanJSon[] helloJSon(@PathParam("username") String userName)	
	{
			// http://localhost:8080/swRestWeb/rest/class1/json/UserName
			BeanJSon bean[] = new BeanJSon[3];
			bean[0] = new BeanJSon();
			bean[0].setCode(1);
			bean[0].setName("Xavi");
			
			bean[1] = new BeanJSon();
			bean[1].setCode(2);
			bean[1].setName("Jordi");

			bean[2] = new BeanJSon();
			bean[2].setCode(3);
			bean[2].setName(userName);
			
			return bean;
		}

	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(BeanJSon bean) {  	
	    
		String result = "\n\n\nBeanJSon created.\tCode:"+bean.getCode()+"\tName:"+bean.getName(); 
			
		System.out.print("\nInside web service:"+result);
			
		return Response.status(201).entity(result).build();
			
		}


}
