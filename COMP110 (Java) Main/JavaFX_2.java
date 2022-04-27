package com.example.demo;
// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (April 27th, 2022)

// Importing javafx libraries
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// JavaFX application that draws a pattern of circles on a spiral
public class JavaFX_2 extends Application {
    // Number of circles constant
    private final int NUM_CIRCLES = 20;
    // Radius of first circle
    private final double RADIUS_FIRST_CIRCLE = 5;
    // Change in radius of each subsequent circle
    private final double CHANGE_IN_RADIUS = 2;
    // Change in distance between center of spiral and center of circle between circles
    private final double CHANGE_IN_DISTANCE = 10;
    // Cycle the colors of the circles through red, green, and blue.
    private final Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    // Change in angle between the positions of circles
    private final double ANGLE_CHANGE = 30;
    @Override
    public void start(Stage stage) {
        // Creating new a pane to hold the circles
        Pane pane = new Pane();
        // Setting the center of the spiral as 300, 300
        double cSpiralX = 300, cSpiralY = 300;
        // Setting distance to be the RADIUS_FIRST_CIRCLE
        double distance = RADIUS_FIRST_CIRCLE;
        // Looping through the number of circles
        for (int i = 0; i < NUM_CIRCLES; i++) {
            // Locating a point that is distance away from (cSpiralX,cSpiralY) at the angle i * ANGLE_CHANGE degrees
            double x = cSpiralX + distance * Math.cos(Math.toRadians(i * ANGLE_CHANGE));
            double y = cSpiralY + distance * Math.sin(Math.toRadians(i * ANGLE_CHANGE));
            // Creating a Circle object with set x, y, and radius = RADIUS_FIRST_CIRCLE + i * CHANGE_IN_RADIUS
            Circle circle = new Circle(x, y, RADIUS_FIRST_CIRCLE + i * CHANGE_IN_RADIUS);
            // Obtaining the color from the COLORS array using the modulus operator to cycle through the colors
            circle.setFill(COLORS[i % COLORS.length]);
            // Adding the circle to the pane
            pane.getChildren().add(circle);
            // Incrementing distance by CHANGE_IN_DISTANCE
            distance += CHANGE_IN_DISTANCE;
        }
        // Creating a new scene with the pane
        Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
    // Main method to start the application
    public static void main(String[] args) {
        launch(args);
    }
}
