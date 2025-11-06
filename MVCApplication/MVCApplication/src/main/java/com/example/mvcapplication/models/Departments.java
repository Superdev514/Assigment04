package com.example.mvcapplication.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Departments {
    private final IntegerProperty departmentId;
    private final StringProperty name;



    public Departments(int departmentId, String name) {
        this.departmentId = new SimpleIntegerProperty(departmentId);
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }
    public IntegerProperty idProperty() {
        return departmentId;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public static ObservableList<Departments> getAllDepartments(){
        ObservableList<Departments> departmentsData = FXCollections.observableArrayList(
                new Departments(1, "Accountant"),
                new Departments(2, "Engineer"),
                new Departments(3, "Lawyer")

        );
        return departmentsData;
    }
}