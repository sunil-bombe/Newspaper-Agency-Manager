package com.webwork.newspaperagencymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
    Scene scene = new Scene(loader.load());
   // scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Newspaper Agency Manager");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}