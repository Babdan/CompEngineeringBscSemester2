package com.example.demo;
// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (April 27th, 2022)

// Importing javafx libraries
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// JavaFX application that draws a pattern of evenly spaced circles
public class JavaFX extends Application {
    // Number of circles constant
    private final int NUM_CIRCLES = 10;
    // Radius of first circle
    private final double RADIUS_FIRST_CIRCLE = 20;
    // Change in radius of each subsequent circle
    private final double CHANGE_IN_RADIUS = 10;
    // Change in the x-coordinate of the circle
    private final double CHANGE_IN_X = 50;
    // Cycle the colors of the circles through red, green, and blue.
    private final Color COLORS[] = {Color.RED, Color.GREEN, Color.BLUE};
    @Override
    public void start(Stage stage) {
        // Creating new a pane to hold the circles
        Pane pane = new Pane();
        // Setting x = RADIUS_FIRST_CIRCLE, y = 300 and radius = RADIUS_FIRST_CIRCLE
        double x = RADIUS_FIRST_CIRCLE, y = 300;
        double radius = RADIUS_FIRST_CIRCLE;
        // Looping through the number of circles
        for (int i = 0; i < NUM_CIRCLES; i++) {
            // Creating a new Circle object with set x, y, and radius values
            Circle circle = new Circle(x, y, radius);
            // Obtaining the color from the COLORS array using the modulus operator to cycle through the colors
            circle.setFill(COLORS[i % COLORS.length]);
            // Adding the circle to the pane
            pane.getChildren().add(circle);
            // Incrementing the x-coordinate of the circle by the CHANGE_IN_X value
            x += CHANGE_IN_X;
            // Incrementing the radius of the circle by the CHANGE_IN_RADIUS value
            radius += CHANGE_IN_RADIUS;
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