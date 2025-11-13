package com.example.mvcapplication.models;

import com.example.mvcapplication.database.connectionManager;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Project {

    private final IntegerProperty projectId;
    private final StringProperty projectName;
    private final DoubleProperty budget;

    public Project(int projectId, String projectName, double budget) {
        this.projectId = new SimpleIntegerProperty(projectId);
        this.projectName = new SimpleStringProperty(projectName);
        this.budget = new SimpleDoubleProperty(budget);
    }

    public int getProjectId() {
        return projectId.get();
    }

    public IntegerProperty projectIdProperty() {
        return projectId;
    }

    public String getProjectName() {
        return projectName.get();
    }

    public StringProperty projectNameProperty() {
        return projectName;
    }

    public double getBudget() {
        return budget.get();
    }

    public DoubleProperty budgetProperty() {
        return budget;
    }

    public static ObservableList<Project> getAllProjects(){
        ObservableList<Project> projectsData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM project";

        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int projectID = rs.getInt("projectID");
                String projectName = rs.getString("name");
                double budget = rs.getDouble("budget");

                Project employee = new Project(projectID, projectName, budget);
                projectsData.add(employee);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return projectsData;
    }


}
