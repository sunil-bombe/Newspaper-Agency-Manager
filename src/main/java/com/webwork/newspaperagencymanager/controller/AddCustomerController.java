package com.webwork.newspaperagencymanager.controller;

import com.webwork.newspaperagencymanager.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerController {

  @FXML
  private TextField nameField;

  @FXML
  private TextField contactField;

  @FXML
  private TextField subscriptionField;

  private CustomerController mainController;

  // Method to set the main controller for callback
  public void setMainController(CustomerController mainController) {
    this.mainController = mainController;
  }

  @FXML
  private void handleAdd(ActionEvent event) {
    String name = nameField.getText();
    String contact = contactField.getText();
    String subscription = subscriptionField.getText();

    if (name.isEmpty() || contact.isEmpty() || subscription.isEmpty()) {
      showAlert("Validation Error", "All fields must be filled!");
    } else {
      Customer newCustomer = new Customer(mainController.getCustomerList().size() + 1, name, contact, subscription);
      mainController.addCustomer(newCustomer); // Add to the main list
      closeWindow();
    }
  }

  @FXML
  private void handleCancel(ActionEvent event) {
    closeWindow();
  }

  private void closeWindow() {
    Stage stage = (Stage) nameField.getScene().getWindow();
    stage.close();
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
