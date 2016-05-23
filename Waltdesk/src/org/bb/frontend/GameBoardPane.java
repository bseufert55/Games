package org.bb.frontend;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class GameBoardPane{
// Panes that are past through in order to change them with methods
	private BorderPane base = null;
	private VBox glass = null;
	private GridPane grid = null;
	private StackPane form = null;
	private Group root = null;
// Necessary global variables 
	private Boolean isPlayerOne = false;
	private Boolean isPlayerTwo = false;
	private Boolean player = true;
	private GridButton[][] playBtns = new GridButton[3][3];
	private ArrayList<GridButton> btns = new ArrayList<GridButton>(9);
	private int count = 0;
	
	public GameBoardPane(BorderPane base,VBox glass,GridPane grid, StackPane form,Group root){
		this.base = base;
		this.glass = glass;
		this.grid = grid;
		this.form = form;
		this.root = root;
	}
// Sets who is player 1 and who is player 2
	public void setPlayerOne(Boolean player){ isPlayerOne = player;}
	public void setPlayerTwo(Boolean player){ isPlayerTwo = player;}

// Gets who is player 1 and player 2 
	public Boolean getPOne(){return isPlayerOne;}
	public Boolean getPTwo(){return isPlayerTwo;}

//Creates the buttons used when you click the tic tac toe button/ enter the tic tac toe game
	public ArrayList<Button> getBtns(){
		ArrayList<Button> btns = new ArrayList<Button>(5);
		Button multiPlayer = new Button();
		multiPlayer.setText("Multi-Player");
		multiPlayer.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		multiPlayer.setMaxSize(150.0, 150.0);
		multiPlayer.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	PlayerForm pform = new PlayerForm(base,glass,grid,form,root);
                 pform.render();
            }
        });
		
		Button singlePlayer = new Button();
		singlePlayer.setText("Single Player");
		singlePlayer.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		singlePlayer.setMaxSize(150.0, 150.0);
		singlePlayer.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	Players pOne = new Players("You",true);
            	Players pTwo = new Players("Walter",false);
            	playBoard("single");
            	statusBoard("You", "Walter");
            }
        });
		
		Button cancel = new Button();
		cancel.setText("Cancel");
		cancel.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		cancel.setMaxSize(150.0, 150.0);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	//render();
            }
        });
		
		btns.add(multiPlayer);
		btns.add(singlePlayer);
		btns.add(cancel);
		
        return btns;
        
	}
// Creates a standard blank grid of buttons	
	public GridButton[][] createGrid(){
		GridButton[][] gridBtns = new GridButton[3][3];
		for(int r = 0; r < gridBtns.length; r++ ){
			for(int c = 0; c < gridBtns[0].length; c++){
				gridBtns[r][c] = new GridButton();
				gridBtns[r][c].setState("blank");
				gridBtns[r][c].setStyle(" -fx-background-color:rgba(93,92,92,.7); -fx-background-radius: 10;");
        		gridBtns[r][c].setPrefSize(150.0,200.0);
			}
		}
		return gridBtns;
	}

//takes the formatted grid and resets them to a blank one
	public void resetBoard(){
		grid.getChildren().clear();
		GridButton[][] gridBtns = createGrid();
		for(int r = 0; r < grid.getHgap(); r++){
        	for(int c = 0; c < grid.getVgap(); c++){
        		gridBtns[r][c].setStyle(" -fx-background-color:rgba(93,92,92,.7); -fx-background-radius: 10;");
        		gridBtns[r][c].setPrefSize(150.0,200.0);
        	    grid.add(gridBtns[r][c], r*5, c*5);
        	}
		}
	}
	
//This changes the blue translucent box into the screen you see when you click the tic tac toe button
	public void statusBoard(String pOne, String pTwo){
		glass.getChildren().clear();
		glass.setSpacing(20.0);
		glass.setPadding(new Insets(100,0,0,100));
		Label title = new Label("Stats");
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        title.setTextFill(Color.web("#FFFFFF"));
        Label playerOne = new Label("Player 1: " + pOne);
        playerOne.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        playerOne.setTextFill(Color.web("#FFFFFF"));
        Label playerTwo = new Label("Player 2: " + pTwo);
        playerTwo.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        playerTwo.setTextFill(Color.web("#FFFFFF"));
        
        glass.getChildren().addAll(title, playerOne, playerTwo);
		
	}
	
//This method changes the grid when you click the tic tac toe button
	public void playBoard( String x){
		final String type = x;
		grid.getChildren().clear();
		
		for(int r = 0; r < grid.getHgap(); r++){
        	for(int c = 0; c < grid.getVgap(); c++){
        		playBtns[r][c] = new GridButton();
        		playBtns[r][c].setState("blank");
				playBtns[r][c].setStyle(" -fx-background-color:rgba(93,92,92,.7); -fx-background-radius: 10;");
        		playBtns[r][c].setPrefSize(150.0,200.0);
        		playBtns[r][c].setX(c);
        		playBtns[r][c].setY(r);
        		btns.add(playBtns[r][c]);
        		playBtns[r][c].setOnAction(new EventHandler<ActionEvent>() {
        		 	
                    @Override
                    public void handle(ActionEvent event) {
                    	
                    	if(((GridButton)event.getSource()).getState().equals("blank")){
                    	count++;
                    	if(player || type.equals("single")){
                    		player = false;
                    		((GridButton)event.getSource()).setState("x");
                    		((GridButton)event.getSource()).setText("X");
                    		((GridButton)event.getSource()).setStyle("-fx-font: 35 arial; -fx-background-color:rgba(225,13,48,.7); -fx-background-radius: 10;");
                    		if(count == 9){
                    			tieBoard();
                    		} else if(count > 3){
                    			checkBoard(btns);
                    			
                    		}
                    		
                    		if(type.equals("single")){
                    			int row = (int) (Math.random() * 2);
                    			int col = (int) (Math.random() * 2);
                    			String play = checkPlays();
                    			if(count > 3 && play.length() > 1){
                    				row = Integer.parseInt(play.substring(0,1));
                    				col = Integer.parseInt(play.substring(1));
                    				
                    			} else{
                    			for(int r = 0; r < playBtns.length; r++){
                    				for(int c = 0; c < playBtns[0].length; c++){
                    					if(!playBtns[row][col].getState().equals("blank")){
                            				row = r;
                            				col = c;
                            			}
                    				}
                    			}
                    			}
                    			playBtns[row][col].setState("o");
                				playBtns[row][col].setText("O");
                				playBtns[row][col].setStyle("-fx-font: 35 arial; -fx-background-color:rgba(129,225,13,.7); -fx-background-radius: 10;");
                				if(count == 9){
                        			tieBoard();
                        		} else if(count > 3){
                        			checkBoard(btns);
                        			
                        		}
                    		}
                    	}else if (!player){
                    		player = true;
                    		((GridButton)event.getSource()).setState("o");
                    		((GridButton)event.getSource()).setText("O");
                    		((GridButton)event.getSource()).setStyle("-fx-font: 35 arial; -fx-background-color:rgba(129,225,13,.7); -fx-background-radius: 10;");
                    		if(count == 9){
                    			tieBoard();
                    		} else if(count > 3){
                    			checkBoard(btns);
                    		}	
                    	}
                    }
                  }
                });
        		
        	    grid.add(playBtns[r][c], r*5, c*5);
        	}
		}
	}
	
	
// default look for when the back button is pressed
	public void render(){
        glass.getChildren().clear();
        grid.getChildren().clear();
        Label title = new Label("Tic Tac Toe");
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 40));
        title.setTextFill(Color.web("#FFFFFF"));
        glass.getChildren().addAll(title,getBtns().get(0),getBtns().get(1),getBtns().get(2));
        glass.setPadding(new Insets(100,0,0,100));
        glass.setSpacing(50.0);
        GridButton[][] gridBtns = createGrid();
        for(int r = 0; r < grid.getHgap(); r++){
        	for(int c = 0; c < grid.getVgap(); c++){
        		if(r==c || ( r == 0 && c == 2) || (r == 2 && c == 0) ){
        		gridBtns[r][c].setText("O");
        		gridBtns[r][c].setStyle("-fx-font: 35 arial; -fx-background-color:rgba(129,225,13,.7); -fx-background-radius: 10;");
        		} else {
        			gridBtns[r][c].setText("X");
            		gridBtns[r][c].setStyle("-fx-font: 35 arial; -fx-background-color:rgba(225,13,48,.7); -fx-background-radius: 10;");
        		}
        		gridBtns[r][c].setPrefSize(150.0,200.0);
        	    grid.add(gridBtns[r][c], r*5, c*5);
        	    
        	}
        }
        
	}

// Checks to see if the buttons on the board have a winner play
	public void checkBoard(ArrayList<GridButton> btns){
		if(isAcrossX(btns)){
			winBoard(1);
		} else if(isDownX(btns)){
			winBoard(1);
		} else if(isDiagonalX(btns)){
			winBoard(1);
		} else if(isAcrossO(btns)){
			winBoard(2);
		} else if(isDownO(btns)){
			winBoard(2);
		} else if(isDiagonalO(btns)){
			winBoard(2);
		}
	}

// Checks three down for X's/ player 1
	public Boolean isDownX(ArrayList<GridButton> arr){
	for(int i = 0; i < 7; i+=3){
		if(arr.get(i).getState().equals("x") && arr.get(i+1).getState().equals("x") && arr.get(i+2).getState().equals("x")){
			return true;
		} 
	}
	return false;
	}
	
// Checks three down for O's/ player 2
	public Boolean isDownO(ArrayList<GridButton> arr){
		for(int i = 0; i < 7; i+=3){	
			if (arr.get(i).getState().equals("o") && arr.get(i+1).getState().equals("o") && arr.get(i+2).getState().equals("o")){
				return true;
			}
		 }
		return false;
	}

// Checks three across for X's/ player 1
	public Boolean isAcrossX(ArrayList<GridButton> arr){
		for(int i = 0; i < 3; i++){
		 if(arr.get(i).getState().equals("x") && arr.get(i+3).getState().equals("x") && arr.get(i+6).getState().equals("x")){
			 return true;
		 }
		}
		 return false;
	}

// Checks three across for O's/ player 2
	public Boolean isAcrossO(ArrayList<GridButton> arr){
		for(int i = 0; i < 3; i++){
			if (arr.get(i).getState().equals("o") && arr.get(i+3).getState().equals("o") && arr.get(i+6).getState().equals("o")){
				 return true;
			 }
		}
		 return false;
	}
	
// Checks three diagonal for X's/ player 1
	public Boolean isDiagonalX(ArrayList<GridButton> arr){
		 if(arr.get(0).getState().equals("x") && arr.get(4).getState().equals("x") && arr.get(8).getState().equals("x")){
			 return true;
		 } else if(arr.get(6).getState().equals("x") && arr.get(4).getState().equals("x") && arr.get(2).getState().equals("x")){
			 return true;
		 }
		return false;
	}

// Checks three diagonal for O's/ player 2
	public Boolean isDiagonalO(ArrayList<GridButton> arr){
		if (arr.get(0).getState().equals("o") && arr.get(4).getState().equals("o") && arr.get(8).getState().equals("o")){
			 return true;
		 } else if(arr.get(6).getState().equals("o") && arr.get(4).getState().equals("o") && arr.get(2).getState().equals("o")){
			 return true;
		 }
		return false;
	}

// This method checks the all possible plays on the board goes with the most recent play
	public String checkPlays(){
	String result = "";	
	
		for(int r = 0; r < playBtns.length; r++){
			int c = 0;
			if(playBtns[r][c].getState().equals(playBtns[r][c+1].getState())){
				if(playBtns[r][c+2].getState().equals("blank")){
					result = "" + r + (c + 2);
				}
			}
		}
		for(int c = 0; c < playBtns[0].length; c++){
			int r = 0;
			if(playBtns[r][c].getState().equals(playBtns[r+1][c].getState())){
				if(playBtns[r+2][c].getState().equals("blank")){
				result = "" + (r+2) + c;
				}
			}
		}		
		for(int r = playBtns.length -1 ; r > -1; r--){
			int c = 2;
			if(playBtns[r][c].getState().equals(playBtns[r][c - 1].getState())){
				if(playBtns[r][c - 2].getState().equals("blank")){
					result = "" + r  + (c - 2);
				}
			}
		}
		for(int c = playBtns[0].length - 1 ; c > -1; c--){
			int r = 2;
			if(playBtns[r][c].getState().equals(playBtns[r-1][c].getState())){
				if(playBtns[r-2][c].getState().equals("blank")){
					result = "" + (r-2)  + c;
				}
			}
		}
		if(playBtns[0][0].getState().equals(playBtns[1][1].getState())){
			if(playBtns[2][2].getState().equals("blank")){
				result = "" + 2  + 2;
			}
		}else if((playBtns[2][2].getState().equals(playBtns[1][1].getState()))){
			if(playBtns[0][0].getState().equals("blank")){
				result = "" + 0  + 0;
			}
		}else if((playBtns[2][0].getState().equals(playBtns[1][1].getState()))){
			if(playBtns[2][0].getState().equals("blank")){
				result = "" + 2  + 0;
			}
		}else if((playBtns[0][2].getState().equals(playBtns[1][1].getState()))){
			if(playBtns[0][2].getState().equals("blank")){
				result = "" + 0 + 2;
			}
		}
		return result;
	}
	
// If a player wins then this method changes the blue box to a congratulations sign
	public void winBoard(int num){
		glass.getChildren().clear();
        Label title = new Label("Tic Tac Toe");
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 40));
        title.setTextFill(Color.web("#FFFFFF"));
        Label congrats = new Label("Congratulations!");
        congrats.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        congrats.setTextFill(Color.web("#FFFFFF"));
        Label winner = new Label("Player " + num + " Won!");
        winner.setFont(Font.font("Amble CN", FontWeight.BOLD, 25));
        winner.setTextFill(Color.web("#FFFFFF"));
        glass.getChildren().addAll(title, congrats, winner);
        glass.setPadding(new Insets(100,0,0,100));
        glass.setSpacing(50.0);
	}
	
	public void tieBoard(){
		glass.getChildren().clear();
        Label title = new Label("Tic Tac Toe");
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 40));
        title.setTextFill(Color.web("#FFFFFF"));
        Label congrats = new Label("Nice Try!");
        congrats.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        congrats.setTextFill(Color.web("#FFFFFF"));
        Label winner = new Label("It's a Tie!");
        winner.setFont(Font.font("Amble CN", FontWeight.BOLD, 25));
        winner.setTextFill(Color.web("#FFFFFF"));
        glass.getChildren().addAll(title, congrats, winner);
        glass.setPadding(new Insets(100,0,0,100));
        glass.setSpacing(50.0);
	}

}
