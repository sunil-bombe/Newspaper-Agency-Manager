package com.webwork.newspaperagencymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
    BorderPane root = loader.load();

    // Set fixed width and height for the main window
    Scene scene = new Scene(root, 500, 400); // Set fixed size here (800px width and 600px height)

    // Apply the scene to the stage
    primaryStage.setScene(scene);
    primaryStage.setTitle("Newspaper Agency Manager");
    primaryStage.setResizable(false); // Disable window resizing to keep it fixed size
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}