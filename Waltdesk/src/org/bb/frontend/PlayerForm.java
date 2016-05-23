package org.bb.frontend;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerForm extends GameBoardPane{
	private StackPane form = null;
	private BorderPane base = null;
	private VBox glass = null;
	private GridPane grid = null;
	private Group root = null;
	
	public PlayerForm(BorderPane base, VBox glass, GridPane grid, StackPane form, Group root ){
		super(base,glass,grid,form,root);
        this.form = form;
        this.base = base;
        this.glass = glass;
        this.grid = grid;
        this.root = root;
	}
	
// renders the pop-up screen that asks for the players names for the multi-player button
	public void render(){
		form.setStyle("-fx-background-color: rgba(27, 27, 27, 0.95); -fx-background-radius: 10;");
		form.setPrefHeight(600.0);
		form.setPrefWidth(800.0);
		
		VBox vb = new VBox();
		vb.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
		
		form.setPadding(new Insets(250,0,0,200));
		form.getChildren().add(vb);
		
		Label pOne = new Label("Player 1: ");
        pOne.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        pOne.setTextFill(Color.web("#FFFFFF"));
        
        final TextField pOneField = new TextField ();
        
        HBox hb1 = new HBox();
        hb1.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb1.getChildren().addAll(pOne, pOneField);
        hb1.setSpacing(10);
        
        Label pTwo = new Label("Player 2: ");
        pTwo.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        pTwo.setTextFill(Color.web("#FFFFFF"));
        
        final TextField pTwoField = new TextField ();
        
        HBox hb2 = new HBox();
        hb2.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb2.getChildren().addAll(pTwo, pTwoField);
        hb2.setSpacing(10);
        
        Button submit = new Button();
		submit.setText("Submit");
		submit.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		submit.setMaxSize(150.0, 150.0);
		submit.setOnAction(new EventHandler<ActionEvent>() {
	 	
            @Override
            public void handle(ActionEvent event) {
            	Players pOne = new Players(pOneField.getText(),true);
            	Players pTwo = new Players(pTwoField.getText(),false);
            	root.getChildren().remove(form);
            	playBoard("multi");
            	statusBoard(pOneField.getText(), pTwoField.getText());
            
            }
        });
		
		Button cancel = new Button();
		cancel.setText("Cancel");
		cancel.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		cancel.setMaxSize(150.0, 150.0);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	form.getChildren().clear();
            	form.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
            
            }
        });
		
		HBox hb3 = new HBox();
        hb3.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb3.setSpacing(10);
        hb3.getChildren().addAll(submit, cancel);
        
        vb.getChildren().addAll(hb1,hb2,hb3);
		
	}
	
/* Method is not used but can be used as a pop-up for congratulations to the winner
	public void winForm(final Players playerOne, final Players playerTwo){
		
		form.getChildren().clear();
		
		form.setStyle("-fx-background-color: rgba(27, 27, 27, 0.95); -fx-background-radius: 10;");
		form.setPrefHeight(600.0);
		form.setPrefWidth(800.0);
		VBox vb = new VBox();
		vb.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
		form.setPadding(new Insets(250,0,0,200));
		form.getChildren().add(vb);
		
		Label title = new Label("Congratulations Player " + playerOne.getNum());
        title.setFont(Font.font("Amble CN", FontWeight.BOLD, 40));
        title.setTextFill(Color.web("#FFFFFF"));
        
        Label winner = new Label(playerOne.getName() + " Wins!");
        winner.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        winner.setTextFill(Color.web("#FFFFFF"));
        
        
        
        Button rematch = new Button();
		rematch.setText("Rematch");
		rematch.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		rematch.setMaxSize(150.0, 150.0);
		rematch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				root.getChildren().remove(form);
				playBoard(playerOne, playerTwo);
            }
        });
		
		Button menu = new Button();
		menu.setText("Menu");
		menu.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		menu.setMaxSize(150.0, 150.0);
		menu.setOnAction(new EventHandler<ActionEvent>() {
	 	
            @Override
            public void handle(ActionEvent event) {
            	root.getChildren().remove(form);
            
            }
        });
        
		HBox hb = new HBox();
		hb.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb.setSpacing(10);
        hb.getChildren().addAll(rematch, menu);
		 
		form.getChildren().add(vb);
		vb.getChildren().addAll(title,winner,hb);
	
	}*/
	
	
}
