package com.webwork.newspaperagencymanager.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Label errorLabel;

  @FXML
  private void handleLogin() {
    String username = usernameField.getText();
    String password = passwordField.getText();

    if (username.equals("Admin") && password.equals("admin123")) {
      // Navigate to Customer View page
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) usernameField.getScene().getWindow(); // Get current stage
        stage.setTitle("Customer Management");
        stage.setScene(new Scene(root));
        stage.show();
      } catch (IOException e) {
        e.printStackTrace();
        errorLabel.setText("Unable to load Customer View page.");
      }
      System.out.println("Login successful!");
    } else {
      errorLabel.setText("Invalid username or password.");
    }
  }

}

