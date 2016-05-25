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
		super(base,glass,grid,root);
        this.form = form;
        this.base = base;
        this.glass = glass;
        this.grid = grid;
        this.root = root;
	}
	
// renders the pop-up screen that asks for the players names for the multi-player button
	public void render(){
		//sets the style, width, and height of the form
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
        //input box for the first player
        final TextField pOneField = new TextField ();
        
        HBox hb1 = new HBox();
        hb1.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb1.getChildren().addAll(pOne, pOneField);
        hb1.setSpacing(10);
        
        Label pTwo = new Label("Player 2: ");
        pTwo.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        pTwo.setTextFill(Color.web("#FFFFFF"));
        //input box for the second player
        final TextField pTwoField = new TextField ();
        
        HBox hb2 = new HBox();
        hb2.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb2.getChildren().addAll(pTwo, pTwoField);
        hb2.setSpacing(10);
        
        //creates the submit button
        Button submit = new Button();
		submit.setText("Submit");
		submit.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		submit.setMaxSize(150.0, 150.0);
		submit.setOnAction(new EventHandler<ActionEvent>() {
	 	
            @Override
            public void handle(ActionEvent event) {
            	root.getChildren().remove(form);
            	playBoard("multi");
            	statusBoard(pOneField.getText(), pTwoField.getText());
            
            }
        });
		// Creates cancle button
		Button cancel = new Button();
		cancel.setText("Cancel");
		cancel.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		cancel.setMaxSize(150.0, 150.0);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            root.getChildren().remove(form);
            }
        });
		// places the buttons
		HBox hb3 = new HBox();
        hb3.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb3.setSpacing(10);
        hb3.getChildren().addAll(submit, cancel);
        
        //attaches everything in to the form
        vb.getChildren().addAll(hb1,hb2,hb3);
		
	}
	
}
