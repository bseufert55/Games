package org.bb.frontend;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class GridButton extends Button{
	
	private Button btn;
	private String state;
	
	public GridButton(){
		btn = new Button();
		state = "blank";
	}
	
	public void setState(String state){this.state = state;}
	public String getState(){return state;}
	
}
