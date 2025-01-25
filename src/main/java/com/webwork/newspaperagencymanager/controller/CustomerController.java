package com.webwork.newspaperagencymanager.controller;

import com.webwork.newspaperagencymanager.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomerController {

  @FXML
  private TableView<Customer> customerTable;

  @FXML
  private TableColumn<Customer, String> nameColumn;

  @FXML
  private TableColumn<Customer, String> contactColumn;

  @FXML
  private TableColumn<Customer, String> subscriptionColumn;

  private ObservableList<Customer> customerList;

  public CustomerController() {
    customerList = FXCollections.observableArrayList();
  }

  @FXML
  public void initialize() {
    // Initialize the TableView with sample data (if necessary)
//    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
//    contactColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty());
//    subscriptionColumn.setCellValueFactory(cellData -> cellData.getValue().subscriptionDetailsProperty());

    // Initialize the columns with Customer properties
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
    subscriptionColumn.setCellValueFactory(new PropertyValueFactory<>("subscriptionDetails"));

    // Add sample data
    loadSampleData();
    customerTable.setItems(customerList);


  }

  private void loadSampleData() {
    // Sample data; in a real-world app, this data would come from a database
    customerList.add(new Customer(1,"John Doe", "123-456-7890", "Monthly Subscription"));
    customerList.add(new Customer(2,"Jane Smith", "987-654-3210", "Weekly Subscription"));
  }

  @FXML
  private void handleAddCustomer(ActionEvent event) {
    // Logic to add a new customer (e.g., show an add customer form)
    System.out.println("Add Customer Button Clicked");
  }

  @FXML
  private void handleEditCustomer(ActionEvent event) {
    // Logic to edit the selected customer
    Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
    if (selectedCustomer != null) {
      System.out.println("Edit Customer: " + selectedCustomer.getName());
    } else {
      showAlert("No customer selected", "Please select a customer to edit.");
    }
  }

  @FXML
  private void handleDeleteCustomer(ActionEvent event) {
    // Logic to delete the selected customer
    Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
    if (selectedCustomer != null) {
      customerList.remove(selectedCustomer);
      System.out.println("Deleted Customer: " + selectedCustomer.getName());
    } else {
      showAlert("No customer selected", "Please select a customer to delete.");
    }
  }

  @FXML
  private void handleExportToExcel(ActionEvent event) {
    // Logic to export customer data to an Excel file
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
    File file = fileChooser.showSaveDialog(new Stage());

    if (file != null) {
      try (FileWriter writer = new FileWriter(file)) {
        writer.write("Name, Contact, Subscription Details\n");
        for (Customer customer : customerList) {
          writer.write(String.format("%s, %s, %s\n", customer.getName(), customer.getContact(), customer.getSubscriptionDetails()));
        }
        System.out.println("Data exported successfully!");
      } catch (IOException e) {
        showAlert("Export Error", "There was an error exporting the data.");
        e.printStackTrace();
      }
    }
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
