package com.example.mvcapplication;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.views.DepartmentsView;
import com.example.mvcapplication.views.EmployeeView;
import com.example.mvcapplication.views.ProjectView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        EmployeeController employeeController = new EmployeeController();
        EmployeeView employeeView = new EmployeeView(employeeController);

        DepartmentController departmentController = new DepartmentController();
        DepartmentsView departmentsView = new DepartmentsView(departmentController);

        ProjectController projectController = new ProjectController();
        ProjectView projectView = new ProjectView(projectController);

        Scene scene1 = new Scene(employeeView, 400, 300);
        Stage stage1 = new Stage();
        stage1.setTitle("Employee Table (MVC)");
        stage1.setScene(scene1);
        stage1.show();

        Scene scene2 = new Scene(departmentsView, 400, 300);
        Stage stage2 = new Stage();
        stage2.setTitle("Department Table (MVC)");
        stage2.setScene(scene2);
        stage2.show();

        Scene scene3 = new Scene(projectView, 400, 300);
        Stage stage3 = new Stage();
        stage3.setTitle("Project Table (MVC)");
        stage3.setScene(scene3);
        stage3.show();

        stage1.setX(90.0);
        stage2.setX(500.0);
        stage3.setX(910.0);


    }

    public static void main(String[] args) {
        launch();
    }
}