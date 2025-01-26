package com.webwork.newspaperagencymanager.controller;

import com.webwork.newspaperagencymanager.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditCustomerController {

  @FXML
  private TextField nameField;

  @FXML
  private TextField contactField;

  @FXML
  private TextField subscriptionField;

  private Customer customer;

  public void setCustomer(Customer customer) {
    this.customer = customer;

    // Populate the fields with the existing customer data
    nameField.setText(customer.getName());
    contactField.setText(customer.getContact());
    subscriptionField.setText(customer.getSubscriptionDetails());
  }

  @FXML
  private void handleSave() {
    // Update customer details
    customer.setName(nameField.getText());
    customer.setContact(contactField.getText());
    customer.setSubscriptionDetails(subscriptionField.getText());

    // Close the Edit Customer window
    Stage stage = (Stage) nameField.getScene().getWindow();
    stage.close();
  }

  @FXML
  private void handleCancel() {
    // Close the Edit Customer window without saving
    Stage stage = (Stage) nameField.getScene().getWindow();
    stage.close();
  }
}
