package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class EmployeeView extends VBox {
    private final TableView<Employee> tableView;
    private final EmployeeController controller;

    public EmployeeView(EmployeeController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();
        buildInterface();
        this.createTable();
        this.getChildren().add(tableView);
        this.bindTableData();
    }

    public void buildInterface(){

        Label firstNameLbl = new Label("First Name:");
        TextField firstNameTxt = new TextField();
        Button seachButton = new Button("Search");

        this.getChildren().add(firstNameLbl);
        this.getChildren().add(firstNameTxt);
        this.getChildren().add(seachButton);

        seachButton.setOnAction(event -> {
            String input = firstNameTxt.getText();
            ObservableList<Employee> allEmployees = EmployeeController.getEmployees();

            ObservableList<Employee> filteredList = FXCollections.observableArrayList();
            for(Employee emp : allEmployees){
                if(emp.getFirstName().contains(input)){
                    filteredList.add(emp);
                }
            }
            tableView.setItems(filteredList);
        });

    }


    private void createTable() {
        TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, Double> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, salaryCol);

    }

    private void bindTableData() {
        tableView.setItems(controller.getEmployees());
    }
}