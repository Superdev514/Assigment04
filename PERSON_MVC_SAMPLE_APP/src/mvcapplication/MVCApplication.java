/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcapplication;

import controllers.PersonController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.PersonView;

/**
 *
 * @author elkhawac
 */
public class MVCApplication extends Application{
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        PersonController personController = new PersonController();
        
        PersonView personView = new PersonView(personController);
        
        ///VBox root = personView.buildInterface();
        
        ///Scene scene = new Scene(root, 200,200);
        
        Scene scene = new Scene(personView, 200,200);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
