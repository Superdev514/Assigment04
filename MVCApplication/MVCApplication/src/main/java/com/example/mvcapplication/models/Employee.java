package com.example.mvcapplication.models;

import com.example.mvcapplication.database.connectionManager;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final DoubleProperty salary;
    private final IntegerProperty departmentId;

    public Employee(int id, String firstName, String lastName, double salary, int departmentId) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.salary = new SimpleDoubleProperty(salary);
        this.departmentId = new SimpleIntegerProperty(departmentId);
    }

    public String getFirstName() {
        return firstName.get();
    }
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public static ObservableList<Employee> getAllEmployees(){
        ObservableList<Employee> employeesData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employees";

        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int employeeID = rs.getInt("employeeID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double salary = rs.getDouble("salary");
                int departmentID = rs.getInt("departmentID");

                Employee employee = new Employee(employeeID, firstName, lastName, salary, departmentID);
                employeesData.add(employee);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return employeesData;
    }

//    public static ObservableList<Employee> getAllEmployees(){
//        ObservableList<Employee> employeeData = FXCollections.observableArrayList(
//                new Employee(1, "John", "Doe", 60000.00, 101),
//                new Employee(2, "Jane", "Smith", 75000.00, 102),
//                new Employee(3, "Peter", "Jones", 85000.00, 101)
//        );
//        return employeeData;
//    }
}