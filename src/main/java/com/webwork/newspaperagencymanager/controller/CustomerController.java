package com.webwork.newspaperagencymanager.controller;

import com.webwork.newspaperagencymanager.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    // Initialize the columns with Customer properties
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    contactColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty());
    subscriptionColumn.setCellValueFactory(cellData -> cellData.getValue().subscriptionDetailsProperty());

    // Add sample data
    loadSampleData();
    customerTable.setItems(customerList);
  }

  private void loadSampleData() {
    // Sample data; in a real-world app, this data would come from a database
    customerList.add(new Customer(1, "John Doe", "123-456-7890", "Monthly Subscription"));
    customerList.add(new Customer(2, "Jane Smith", "987-654-3210", "Weekly Subscription"));
  }

  @FXML
  private void handleAddCustomer(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AddCustomerForm.fxml"));
      Parent root = loader.load();
      AddCustomerController controller = loader.getController();
      controller.setMainController(this); // Pass the main controller for callback
      Stage stage = new Stage();
      stage.setTitle("Add Customer");
      stage.setScene(new Scene(root));
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
      showAlert("Error", "Unable to open Add Customer form.");
    }
  }

  public void addCustomer(Customer customer) {
    customerList.add(customer);
  }

  public ObservableList<Customer> getCustomerList() {
    return customerList;
  }

  @FXML
  private void handleEditCustomer(ActionEvent event) {
    Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
    if (selectedCustomer != null) {
      try {
        // Load the Edit Customer FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/EditCustomerView.fxml"));
        Parent parent = loader.load();

        // Get the controller and pass the selected customer
        EditCustomerController controller = loader.getController();
        controller.setCustomer(selectedCustomer);

        // Create a new stage for the Edit Customer screen
        Stage stage = new Stage();
        stage.setTitle("Edit Customer");
        stage.setScene(new Scene(parent));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.showAndWait();

        // Refresh the customer table if data is updated
        customerTable.refresh();
      } catch (IOException e) {
        e.printStackTrace();
        showAlert("Error", "Unable to load Edit Customer screen.");
      }
    } else {
      showAlert("No customer selected", "Please select a customer to edit.");
    }
  }


  @FXML
  private void handleDeleteCustomer(ActionEvent event) {
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
