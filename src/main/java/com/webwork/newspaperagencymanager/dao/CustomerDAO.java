package com.webwork.newspaperagencymanager.dao;
import com.webwork.newspaperagencymanager.model.Customer1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
  private final String url = "jdbc:mysql://localhost:3306/NewspaperAgency";
  private final String user = "root";
  private final String password = "password";

  public List<Customer1> getAllCustomers() {
    List<Customer1> customers = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      String query = "SELECT * FROM Customer";
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next()) {
        customers.add(new Customer1(
            rs.getInt("customer_id"),
            rs.getString("name"),
            rs.getString("contact"),
            rs.getString("subscription_details")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customers;
  }
}
