package org.bb.frontend;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.random;
/* Author: Bianca Seufert
 * Date: May 23, 2016
 * Class: AP Computer Science
 * Project: Tic Tac Toe Game
 */

public class UI extends Application {
	//These are my main pains that I pass as variables so that I can change them from anywhere with out having to make new ones
	private Stage primaryStage = null;
	private BorderPane base = new BorderPane();
	private VBox glass = new VBox(); 
	private GridPane grid = new GridPane();
	private StackPane form = new StackPane();
	private GameBoardPane playerBoard = null;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage stage) {
		//sets up the main window and the background 
		primaryStage = stage;
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);
        
        //Creates a group of 30 circles 
        Group circles = new Group();
        for (int i = 0; i < 30; i++) {
           Circle circle = new Circle(150, Color.web("white", 0.05));
           circle.setStrokeType(StrokeType.OUTSIDE);
           //the circles are translucent
           circle.setStroke(Color.web("white", 0.16));
           circle.setStrokeWidth(4);
           circles.getChildren().add(circle);
        }
        
        // sets the background to black behind the circles
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
        		// set a gradient to the background in certain spots (p.s. its a rainbow)
        	     new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
        	         Stop[]{
        	            new Stop(0, Color.web("#f8bd55")),
        	            new Stop(0.14, Color.web("#c0fe56")),
        	            new Stop(0.28, Color.web("#5dfbc1")),
        	            new Stop(0.43, Color.web("#64c2f8")),
        	            new Stop(0.57, Color.web("#be4af7")),
        	            new Stop(0.71, Color.web("#ed5fc2")),
        	            new Stop(0.85, Color.web("#ef504c")),
        	            new Stop(1, Color.web("#f2660f")),}));
        // binds the gradient to the circles
        	colors.widthProperty().bind(scene.widthProperty());
        	colors.heightProperty().bind(scene.heightProperty());
        	//blends the circles so that they don't look sharp against the background
        	Group blendModeGroup = 
        		    new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
        		        Color.BLACK), circles), colors);
        		colors.setBlendMode(BlendMode.OVERLAY);
        		root.getChildren().add(blendModeGroup);
        //puts the blending into action
        circles.setEffect(new BoxBlur(10, 10, 3));
        
        //moves the circles for a certain time interval 
        Timeline timeline = new Timeline();
        for (Node circle: circles.getChildren()) {
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, // set start position at 0
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)
                ),
                new KeyFrame(new Duration(40000), // set end position at 40s
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)
                )
            );
        }
        
        //These commands attach the panes created in the beginning so that I only have to create one but still change them 
        root.getChildren().add(base);
        root.getChildren().add(form); 
        playerBoard = new GameBoardPane(base,glass,grid,form,root);
        
        //passing in the panes that can be changed
        mainRender(base,glass,grid);
   
        // play 40s of animation
        timeline.play();
        
        //command to present everything you see in the application 
        primaryStage.show();
    }

	/* This method creates the main page. It is separate from the main method above so 
	 * that when I have a menu but I can revert the current screens back to the original*/
	public void mainRender(BorderPane base, VBox glass, GridPane grid){
	// Creates Main Title
		Label lbl = new Label("Lets Play!");
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 40));
        lbl.setTextFill(Color.web("#FFFFFF"));
        Label lbl2 = new Label("Inc.");
        lbl2.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
        lbl2.setTextFill(Color.web("#FFFFFF"));
        Label lbl3 = new Label("By: Bianca Seufert");
        lbl3.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        lbl3.setTextFill(Color.web("#FFFFFF"));
       
    //Creates the "Lets Play" button
        Button playBtn = new Button();
        playBtn.setText("Tic Tac Toe");
        playBtn.setStyle("-fx-font: 22 arial; -fx-base: #FFFFFF;");
        playBtn.setMaxSize(150.0, 150.0);
    //Mouse click action for the button
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                playerBoard.render();
            }
        });
        
        
    //Creates the "Destroy" button
      Button destroyBtn = new Button();
      destroyBtn.setText("Destroy");
      destroyBtn.setStyle("-fx-font: 22 arial; -fx-base: #FFFFFF;");
      destroyBtn.setMaxSize(150.0, 150.0);
    //Mouse click action for the button
      destroyBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Destroy screne");
            }
        });
        
  //This decorates the glass pane (translucent blue box)
      glass.getChildren().clear();
      glass.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
      glass.setPrefWidth(400.0);
      glass.setPrefHeight(600.0);
      glass.getChildren().addAll(lbl,lbl2, lbl3);
      glass.setPadding(new Insets(200,0,0,100));
      base.setLeft(glass);
	
  //This decorates the grid/game board that isn't yet present in the main window 
    grid.getChildren().clear();
    grid.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
    grid.setPrefWidth(400.0);
    grid.setPrefHeight(600.0);
    grid.setHgap(3);
    grid.setVgap(3);
    grid.setPadding(new Insets(10));
    grid.add(playBtn,40,70);
    grid.add(destroyBtn,40,80);
    base.setRight(grid);
     
  //translucent pane that just holds everything together 
    base.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;");
    base.setPrefWidth(800.0);
    base.setPrefHeight(600.0);
	}
}
	

