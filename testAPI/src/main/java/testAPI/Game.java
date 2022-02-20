package testAPI;

import java.io.IOException;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
 

 
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
 

 
 

public class Game implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String Label;
	private ArrayList<Player> Players=new ArrayList<Player>();
	 
	
	
	
	public Game() throws IOException {
		  //this.Data=;
		  this.Players=getPlayersFromData();
		  this.Label=(String)this.GetData().getAsJsonObject().getAsJsonObject().get("settings").getAsJsonObject().get("label").getAsString();
		
		
	}
	
	
	public String getLabel() {
		return Label;
	}
	public void setLabel(String Label) {
		this.Label = Label;
	}
	public ArrayList<Player> getPlayers() {
		return Players;
	}
	public void setPlayers(ArrayList<Player> players) {
		Players = players;
	}


	
	private JsonElement GetData() throws IOException {
		java.io.InputStream Stream = new java.net.URL("http://cdn.55labs.com/demo/api.json").openStream();
	    String Data = new String(Stream.readAllBytes());
	    com.google.gson.JsonElement JsonData = com.google.gson.JsonParser.parseString(Data); 
		return JsonData;
	}
	
	
	private ArrayList<Player> getPlayersFromData() throws IOException {
		 ArrayList<Player> Players= new ArrayList<Player> ();
		 Player john=new Player();
		 Player larry=new Player();
 
		 john.setFirstname((String)this.GetData().getAsJsonObject().get("settings").getAsJsonObject().get("dictionary").getAsJsonObject().get("john").getAsJsonObject().get("firstname").getAsString());
		 john.setLastname(this.GetData().getAsJsonObject().get("settings").getAsJsonObject().get("dictionary").getAsJsonObject().get("john").getAsJsonObject().get("lastname").getAsString());
		 john.setMatches(this.GetDateAndPointFromData( (JsonArray) this.GetData().getAsJsonObject().get("data").getAsJsonObject().get("DAILY").getAsJsonObject().get("dates").getAsJsonArray(),(JsonArray) this.GetData().getAsJsonObject().get("data").getAsJsonObject().get("DAILY").getAsJsonObject().get("dataByMember").getAsJsonObject().get("players").getAsJsonObject().get("john").getAsJsonObject().get("points").getAsJsonArray()));
		 john.SetScorefromData();
		 
		 larry.setFirstname(this.GetData().getAsJsonObject().get("settings").getAsJsonObject().get("dictionary").getAsJsonObject().get("larry").getAsJsonObject().get("firstname").getAsString());
		 larry.setLastname(this.GetData().getAsJsonObject().get("settings").getAsJsonObject().get("dictionary").getAsJsonObject().get("larry").getAsJsonObject().get("lastname").getAsString());
		 larry.setMatches(this.GetDateAndPointFromData( (JsonArray) this.GetData().getAsJsonObject().get("data").getAsJsonObject().get("DAILY").getAsJsonObject().get("dates").getAsJsonArray(),(JsonArray) this.GetData().getAsJsonObject().get("data").getAsJsonObject().get("DAILY").getAsJsonObject().get("dataByMember").getAsJsonObject().get("players").getAsJsonObject().get("larry").getAsJsonObject().get("points").getAsJsonArray()));
		 larry.SetScorefromData();
		 
		 Players.add(larry);
		 Players.add(john);
		 
		 return Players;
	}
	
	private  LinkedHashMap<String, Integer> GetDateAndPointFromData(JsonArray dates,JsonArray points)  {
		String year= new String();
		String month= new String();
		String day= new String();
		
	    LinkedHashMap<String, Integer> matches = new LinkedHashMap<String,Integer >();
		 int Point;
		 
		for (int i =0;i<dates.size();i++ ) {
		if(dates.get(i).isJsonNull())   
			continue;  
		  
		  year= (String) dates.get(i).getAsString().subSequence(0, 4);
 		  month=(String) dates.get(i).getAsString().subSequence(4, 6);
		  day=  (String) dates.get(i).getAsString().subSequence(6,8);
		  
 		 if(points.get(i).isJsonNull())
 			Point=0;
 		 else Point=points.get(i).getAsInt();
 		matches.put( year+"-"+month+"-"+day,Point); 
		}
		
		return matches ;
	}
}
