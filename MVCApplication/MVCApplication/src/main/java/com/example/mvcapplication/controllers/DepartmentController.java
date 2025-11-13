package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.Departments;
import com.example.mvcapplication.models.Employee;
import javafx.collections.ObservableList;

public class DepartmentController {

    public DepartmentController() {

    }

    public static ObservableList<Departments> getDepartments() {
        return Departments.getAllDepartments();
    }
}
