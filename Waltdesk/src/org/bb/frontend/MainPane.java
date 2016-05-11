package org.bb.frontend;

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

public class MainPane {
	private BorderPane base = null;
	private VBox glass = null;
	private GridPane grid = null;
	private StackPane form = null;
	
	
	public MainPane(BorderPane base,VBox glass,GridPane grid, StackPane form){
		this.base = base;
		this.glass = glass;
		this.grid = grid;
		this.form = form;
	}
	
	
}
