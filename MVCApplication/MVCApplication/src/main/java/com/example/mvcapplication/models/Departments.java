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

public class Departments {
    private final IntegerProperty departmentId;
    private final StringProperty departmentName;



    public Departments(int departmentId, String departmentName) {
        this.departmentId = new SimpleIntegerProperty(departmentId);
        this.departmentName = new SimpleStringProperty(departmentName);
    }

    public String getName() {
        return departmentName.get();
    }
    public IntegerProperty idProperty() {
        return departmentId;
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }

    public static ObservableList<Departments> getAllDepartments(){
        ObservableList<Departments> departmentsData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM departments";

        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int departmentID = rs.getInt("departmentID");
                String departmentName = rs.getString("name");

                Departments department = new Departments(departmentID, departmentName);
                departmentsData.add(department);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return departmentsData;
    }
}