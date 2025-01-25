package com.webwork.newspaperagencymanager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class HawkerController {
  @FXML private TableView<?> hawkerTable;

  @FXML
  private void handleAddHawker() {
    System.out.println("Add Hawker button clicked.");
  }

  @FXML
  private void handleEditHawker() {
    System.out.println("Edit Hawker button clicked.");
  }

  @FXML
  private void handleDeleteHawker() {
    System.out.println("Delete Hawker button clicked.");
  }

  @FXML
  private void handleExport() {
    System.out.println("Export to Excel button clicked.");
  }
}

