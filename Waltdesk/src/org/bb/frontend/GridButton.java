package org.bb.frontend;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class GridButton extends Button{
	
	private Button btn;
	private String state = "blank";
	private int xCord = 0;
	private int yCord = 0;
	
	public GridButton(){
		btn = new Button();
		
	}
	
	public void setState(String state){this.state = state;}
	public String getState(){return state;}
	public void setX(int x){xCord = x;}
	public int getX(){return xCord;}
	public void setY(int x){yCord = x;}
	public int getY(){return yCord;}
	
	
}
