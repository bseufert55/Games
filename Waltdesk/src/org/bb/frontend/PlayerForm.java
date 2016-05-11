package org.bb.frontend;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	
	public PlayerForm(BorderPane base, VBox glass, GridPane grid, StackPane form){
		super(base,glass,grid,form);
        this.form = form;
        this.base = base;
        this.glass = glass;
        this.grid = grid;
	}
	
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
        TextField pOneField = new TextField ();
        HBox hb1 = new HBox();
        hb1.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb1.getChildren().addAll(pOne, pOneField);
        hb1.setSpacing(10);
        vb.getChildren().add(hb1);
        
        Label pTwo = new Label("Player 2: ");
        pTwo.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
        pTwo.setTextFill(Color.web("#FFFFFF"));
        TextField pTwoField = new TextField ();
        HBox hb2 = new HBox();
        hb2.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb2.getChildren().addAll(pTwo, pTwoField);
        hb2.setSpacing(10);
        vb.getChildren().add(hb2);
        
        Button submit = new Button();
		submit.setText("Submit");
		submit.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		submit.setMaxSize(150.0, 150.0);
		submit.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	form.getChildren().clear();
            	form.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
            	resetBoard();
            	statusBoard("you", "computer");
            
            }
        });
		Button cancel = new Button();
		cancel.setText("Cancel");
		cancel.setStyle("-fx-font: 20 arial; -fx-base: #FFFFFF;");
		cancel.setMaxSize(150.0, 150.0);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	//mainRender(base,glass,grid);
            }
        });
		HBox hb3 = new HBox();
        hb2.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
        hb2.setSpacing(10);
        hb2.getChildren().addAll(submit, cancel);
        vb.getChildren().add(hb3);
		
	}
	
	
}
