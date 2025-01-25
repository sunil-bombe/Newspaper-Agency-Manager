package com.webwork.newspaperagencymanager.model;

public class Customer {
  private int id;
  private String name;
  private String contact;
  private String subscriptionDetails;

  public Customer(int id, String name, String contact, String subscriptionDetails) {
    this.id = id;
    this.name = name;
    this.contact = contact;
    this.subscriptionDetails = subscriptionDetails;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getSubscriptionDetails() {
    return subscriptionDetails;
  }

  public void setSubscriptionDetails(String subscriptionDetails) {
    this.subscriptionDetails = subscriptionDetails;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", contact='" + contact + '\'' +
        ", subscriptionDetails='" + subscriptionDetails + '\'' +
        '}';
  }
}