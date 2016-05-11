package org.bb.frontend;

public class Walter {
	private String[] myGreetings = {"Hello!, How may I be of assistance? ", "Welcome", "Hi", "Howdie", "Howdy", "Hey", "Good Day!" }; 
	private Boolean myStatus;
	
	public Walter(){
		myStatus = true;
		
	}
	
	public String getGreeting(){
		return myGreetings[0];
	}
	
	public Boolean getStatus(){
		return myStatus;
	}
	
}
