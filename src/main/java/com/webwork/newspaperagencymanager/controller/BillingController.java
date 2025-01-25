package com.webwork.newspaperagencymanager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class BillingController {
  @FXML private TableView<?> billingTable;

  @FXML
  private void handleGenerateBill() {
    System.out.println("Generate Bill button clicked.");
  }

  @FXML
  private void handleViewBill() {
    System.out.println("View Bill button clicked.");
  }

  @FXML
  private void handlePrintBill() {
    System.out.println("Print Bill button clicked.");
  }
}
