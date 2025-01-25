package com.webwork.newspaperagencymanager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Label errorLabel;

  @FXML
  private void handleLogin() {
    String username = usernameField.getText();
    String password = passwordField.getText();
    if (username.equals("admin") && password.equals("password")) {
      // Proceed to Dashboard
      System.out.println("Login successful!");
    } else {
      errorLabel.setText("Invalid username or password.");
    }
  }
}

