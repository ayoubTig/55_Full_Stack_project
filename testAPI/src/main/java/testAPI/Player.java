package testAPI;

import java.io.Serializable;
 
import java.util.LinkedHashMap;
  

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private int Score;
	private LinkedHashMap<String, Integer> Matches = new LinkedHashMap<String,Integer >();  //date,point
	
	
	public int getScore() {
		return Score;
	}
 

	public void setScore(int scoor) {
		Score = scoor;
	}
	
	public void SetScorefromData() {
		int sum=0;
		for (int f : this.Matches.values()) {
		    sum += f;
		}
		this.Score=sum;
	}

	public Player() {
		this.firstname="";
		this.lastname="";
		
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public LinkedHashMap<String, Integer> getMatches() {
		return Matches;
	}


	public void setMatches(LinkedHashMap<String, Integer> matches) {
		Matches = matches;
	}
	 
}
