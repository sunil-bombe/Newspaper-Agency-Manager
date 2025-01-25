package com.webwork.newspaperagencymanager.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class AreaController {
  @FXML private TableView<?> areaTable;

  @FXML
  private void handleAddArea() {
    System.out.println("Add Area button clicked.");
  }

  @FXML
  private void handleEditArea() {
    System.out.println("Edit Area button clicked.");
  }

  @FXML
  private void handleDeleteArea() {
    System.out.println("Delete Area button clicked.");
  }
}

