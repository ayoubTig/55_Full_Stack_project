package testAPI;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/login")// L'URL pour la récuperation des données 
public class APICon {
	private Game G1;
	
	public APICon() {
		try {
			G1= new Game();
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response  SendResults() {
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(new Gson().toJson(G1, Game.class))
	            .build();
	}
	
	@Path("/{user}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response userloginon(@PathParam("user") String firstname){
		String Result;
		if(firstname.equals("Larry"))
			Result= new Gson().toJson(G1.getPlayers().get(0), Player.class);
		else Result= new Gson().toJson(G1.getPlayers().get(1), Player.class);
		
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(Result)
	            .build();
		 
	}
	
	
}
