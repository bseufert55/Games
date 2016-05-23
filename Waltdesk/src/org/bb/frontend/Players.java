package org.bb.frontend;

public class Players {
	
	private String myName;
	private Boolean playerOne = false;
	
	public Players(String name, boolean player){
		myName = name;
		playerOne = player;
	}
	
// gets the name of the player
	public String getName(){return myName;}

// Determines if player is the first player or not
	public Boolean isPlayerOne(){return playerOne;}

}
