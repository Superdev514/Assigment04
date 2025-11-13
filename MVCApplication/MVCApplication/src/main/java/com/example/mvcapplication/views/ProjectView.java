package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.ProjectController;

import com.example.mvcapplication.models.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ProjectView extends VBox {

    private final TableView<Project> tableView;
    private final ProjectController controller;

    public ProjectView(ProjectController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();
        buildInterface();
        this.createTable();
        this.getChildren().add(tableView);
        this.bindTableData();
    }

    public void buildInterface(){

        Label projectNameLbl = new Label("Project Name:");
        TextField projectNameTxt = new TextField();
        Button seachButton = new Button("Search");


        HBox searchBox = new HBox(10);
        searchBox.getChildren().add(projectNameLbl);
        searchBox.getChildren().add(projectNameTxt);
        searchBox.getChildren().add(seachButton);

        searchBox.setAlignment(Pos.BASELINE_LEFT);
        this.getChildren().add(searchBox);

        seachButton.setOnAction(event -> {
            String input = projectNameTxt.getText();
            ObservableList<Project> allProjects = ProjectController.getProjects();

            ObservableList<Project> filteredList = FXCollections.observableArrayList();
            for(Project proj : allProjects){
                if(proj.getProjectName().contains(input)){
                    filteredList.add(proj);
                }
            }
            tableView.setItems(filteredList);
        });

    }


    private void createTable() {
        TableColumn<Project, String> projectNameCol = new TableColumn<>("Project Name");
        projectNameCol.setCellValueFactory(new PropertyValueFactory<>("projectName"));

        TableColumn<Project, Double> budgetCol = new TableColumn<>("Budget");
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("budget"));

        tableView.getColumns().addAll(projectNameCol, budgetCol);

    }

    private void bindTableData() {
        tableView.setItems(controller.getProjects());
    }

}
