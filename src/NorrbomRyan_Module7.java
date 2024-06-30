/*Created by Ryan Norrbom 
 * Created On: 06/29/2024
 * Created for: CSD420
 * 
 * Using mystyle.css, also in the source file location, create and display 4 circles to the end user. 
 * 
 */

 // Start
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.layout.Pane;
 import javafx.scene.shape.Circle;
 import javafx.scene.shape.Rectangle;
 import javafx.stage.Stage;
 
 public class NorrbomRyan_Module7 extends Application {
 
     @Override
     public void start(Stage primaryStage) {
        // Create a canvas to hold the circles
        Pane canvas = new Pane();

        // Create four circles with different styles
        Circle circle1 = new Circle(50, 80, 35);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(150, 80, 35);
        circle2.getStyleClass().add("circleborder");

        Rectangle border1 = new Rectangle(10, 10, 80, 160);
        border1.getStyleClass().add("border");

        Circle circle3 = new Circle(250, 80, 35);
        circle3.setId("redcircle");

        Circle circle4 = new Circle(350, 80, 35);
        circle4.setId("greencircle");

        // Add circles to the canvas
        canvas.getChildren().addAll(circle1, border1, circle2, circle3, circle4);

        // Create a scene and add the canvas to it
        Scene scene = new Scene(canvas, 600, 300);
 
        // Load the CSS stylesheet
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        // Set the stage
        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
     }
 
     public static void main(String[] args) {
        launch(args);
     }
 }
//End