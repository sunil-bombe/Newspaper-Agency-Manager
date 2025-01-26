module com.webwork.newspaperagencymanager {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.bootstrapfx.core;
  requires eu.hansolo.tilesfx;
  requires com.almasb.fxgl.all;
  requires java.sql;

  exports com.webwork.newspaperagencymanager;
  exports com.webwork.newspaperagencymanager.model;

  opens com.webwork.newspaperagencymanager.controller to javafx.fxml;

}