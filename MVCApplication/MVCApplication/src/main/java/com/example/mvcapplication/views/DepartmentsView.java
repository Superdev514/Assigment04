package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Departments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DepartmentsView extends VBox {
    private final TableView<Departments> tableView;
    private final DepartmentController controller;

    public DepartmentsView(DepartmentController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();
        buildInterface();
        this.createTable();
        this.getChildren().add(tableView);
        this.bindTableData();
    }

    public void buildInterface(){

        Label departmentNameLbl = new Label("Department Name:");
        TextField departmentNameTxt = new TextField();
        Button seachButton = new Button("Search");


        HBox searchBox = new HBox(10);
        searchBox.getChildren().add(departmentNameLbl);
        searchBox.getChildren().add(departmentNameTxt);
        searchBox.getChildren().add(seachButton);

        searchBox.setAlignment(Pos.BASELINE_LEFT);

        this.getChildren().add(searchBox);
        seachButton.setOnAction(event -> {
            String input = departmentNameTxt.getText();
            ObservableList<Departments> allDepartments = DepartmentController.getDepartments();

            ObservableList<Departments> filteredList = FXCollections.observableArrayList();
            for(Departments department : allDepartments){
                if(department.getName().contains(input)){
                    filteredList.add(department);
                }
            }
            tableView.setItems(filteredList);
        });

    }


    private void createTable() {
        TableColumn<Departments, String> departmentNameCol = new TableColumn<>("Department Name");
        departmentNameCol.setCellValueFactory(new PropertyValueFactory<>("departmentName"));

        tableView.getColumns().addAll(departmentNameCol);

    }

    private void bindTableData() {
        tableView.setItems(controller.getDepartments());
    }
}