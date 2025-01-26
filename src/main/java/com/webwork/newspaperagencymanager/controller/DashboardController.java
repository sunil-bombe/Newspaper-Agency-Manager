package com.webwork.newspaperagencymanager.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardController {

  @FXML
  private void openCustomerManagement(ActionEvent event) {
    try {
      // Load the Customer View FXML
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CustomerView.fxml"));
      Parent customerView = loader.load();

      // Get the current scene and set the root to the Customer View
      Scene currentScene = ((Node) event.getSource()).getScene();
      currentScene.setRoot(customerView);

    } catch (IOException e) {
      e.printStackTrace();
      showAlert("Error", "Unable to load Customer Management screen.");
    }
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.showAndWait();
  }





//  @FXML
//  private void openCustomerManagement() {
//    try {
//      // Load the Edit Customer FXML
//      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CustomerView.fxml"));
//      Parent parent = loader.load();
//
//      // Get the controller and pass the selected customer
//      EditCustomerController controller = loader.getController();
//     // controller.setCustomer(selectedCustomer);
//
//      // Create a new stage for the Edit Customer screen
//      Stage stage = new Stage();
//      stage.setTitle("Edit Customer");
//      stage.setScene(new Scene(parent));
//      stage.initModality(Modality.WINDOW_MODAL);
//      stage.initOwner(((Node) event.getSource()).getScene().getWindow());
//      stage.showAndWait();
//
//      // Refresh the customer table if data is updated
//      customerTable.refresh();
//    } catch (IOException e) {
//      e.printStackTrace();
//      showAlert("Error", "Unable to load Edit Customer screen.");
//    }
//  } else {
//    showAlert("No customer selected", "Please select a customer to edit.");
//  }
//  }

  @FXML
  private void openHawkerManagement() {
    System.out.println("Opening Hawker Management...");
  }

  @FXML
  private void openAreaManagement() {
    System.out.println("Opening Area Management...");
  }

  @FXML
  private void openBilling() {
    System.out.println("Opening Billing...");
  }
}
