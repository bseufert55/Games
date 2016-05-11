package org.bb.frontend;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

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
	private BorderPane base = null;
	private VBox glass = null;
	private GridPane grid = null;
	private StackPane form = null;
	
	public GameBoardPane(BorderPane base,VBox glass,GridPane grid, StackPane form){
		this.base = base;
		this.glass = glass;
		this.grid = grid;
		this.form = form;
	}
	
	public ArrayList<Button> getBtns(){
		ArrayList<Button> btns = new ArrayList<Button>(5);
		Button multiPlayer = new Button();
		multiPlayer.setText("Multi-Player");
		multiPlayer.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		multiPlayer.setMaxSize(150.0, 150.0);
        //mouse click action for the button
		multiPlayer.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                 PlayerForm pform = new PlayerForm(base,glass,grid,form);
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
            	resetBoard();
            	statusBoard("you", "computer");
            }
        });
		
		btns.add(multiPlayer);
		btns.add(singlePlayer);
		
        return btns;
        
	}
	
	public GridButton[][] getGrid(){
		GridButton[][] gridBtns = new GridButton[3][3];
		for(int r = 0; r < gridBtns.length; r++ ){
			for(int c = 0; c < gridBtns[0].length; c++){
				gridBtns[r][c] = new GridButton();
			}
		}
		return gridBtns;
	}
	
	public void resetBoard(){
		grid.getChildren().clear();
		GridButton[][] gridBtns = getGrid();
		for(int r = 0; r < grid.getHgap(); r++){
        	for(int c = 0; c < grid.getVgap(); c++){
        		gridBtns[r][c].setStyle(" -fx-background-color:rgba(93,92,92,.7); -fx-background-radius: 10;");
        		gridBtns[r][c].setPrefSize(150.0,200.0);
        	    grid.add(gridBtns[r][c], r*5, c*5);
        	}
		}
	}
	
	public void statusBoard(String pOne, String pTwo){
		glass.getChildren().clear();
		glass.setSpacing(20.0);
		glass.setPadding(new Insets(100,0,0,100));
		Label title = new Label("Stats");
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        title.setTextFill(Color.web("#FFFFFF"));
        Label playerOne = new Label("Player 1: You");
        playerOne.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        playerOne.setTextFill(Color.web("#FFFFFF"));
        Label playerTwo = new Label("Player 2: Computer");
        playerTwo.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        playerTwo.setTextFill(Color.web("#FFFFFF"));
        
        glass.getChildren().addAll(title, playerOne, playerTwo);
		
	}
	
	public void render(){
        glass.getChildren().clear();
        grid.getChildren().clear();
        Label title = new Label("Tic Tac Toe");
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 40));
        title.setTextFill(Color.web("#FFFFFF"));
        glass.getChildren().addAll(title,getBtns().get(0),getBtns().get(1));
        glass.setSpacing(50.0);
        GridButton[][] gridBtns = getGrid();
        for(int r = 0; r < grid.getHgap(); r++){
        	for(int c = 0; c < grid.getVgap(); c++){
        		//gridBtns[r][c].setGraphic(new ImageView("img/images.jpg"));
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
}
