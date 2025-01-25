CREATE DATABASE NewspaperAgency;

USE NewspaperAgency;

CREATE TABLE Area (
    area_id INT AUTO_INCREMENT PRIMARY KEY,
    area_name VARCHAR(100) NOT NULL
);

CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(15),
    subscription_details VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(100),
    pincode VARCHAR(10),
    area_id INT,
    subscription_start_date DATE,
    hawker_id INT,
    FOREIGN KEY (area_id) REFERENCES Area(area_id),
    FOREIGN KEY (hawker_id) REFERENCES Hawker(hawker_id)
);

CREATE TABLE Hawker (
    hawker_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(15),
    delivery_routes VARCHAR(255)
);
