package org.bb.frontend;

import javafx.scene.control.Button;


public class GridButton extends Button{
	
	private String state = "blank";
	private int xCord = 0;
	private int yCord = 0;
	
	public GridButton(){
	}
	//set the state of the button (can be x, o, or blank)
	public void setState(String state){this.state = state;}
	
	//gets the state of the button
	public String getState(){return state;}
	
	// sets the x - coordinate 
	public void setX(int x){xCord = x;}
	
	// gets the x - coordinate 
	public int getX(){return xCord;}
	
	// sets the y - coordinate 
	public void setY(int x){yCord = x;}
	
	// gets the y - coordinate 
	public int getY(){return yCord;}
	
	
}
