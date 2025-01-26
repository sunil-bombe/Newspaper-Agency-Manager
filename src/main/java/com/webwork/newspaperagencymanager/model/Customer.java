package com.webwork.newspaperagencymanager.model;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
  private final SimpleStringProperty name;
  private final SimpleStringProperty contact;
  private final SimpleStringProperty subscriptionDetails;

  public Customer(int i, String name, String contact, String subscriptionDetails) {
    this.name = new SimpleStringProperty(name);
    this.contact = new SimpleStringProperty(contact);
    this.subscriptionDetails = new SimpleStringProperty(subscriptionDetails);
  }

  public String getName() {
    return name.get();
  }

  public SimpleStringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getContact() {
    return contact.get();
  }

  public SimpleStringProperty contactProperty() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact.set(contact);
  }

  public String getSubscriptionDetails() {
    return subscriptionDetails.get();
  }

  public SimpleStringProperty subscriptionDetailsProperty() {
    return subscriptionDetails;
  }

  public void setSubscriptionDetails(String subscriptionDetails) {
    this.subscriptionDetails.set(subscriptionDetails);
  }


}
