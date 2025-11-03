/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.PersonController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author elkhawac
 */
public class PersonView extends VBox{
    
    TextField firstNameTxt;
    
    PersonController personController;
    
    // Inject the controller object as a dependency: Dependency injection
    public PersonView(PersonController personController){
     
        this.personController = personController;
        
        buildInterface();
    
    }
    public void buildInterface(){


     Label firstNameLbl = new Label("First Name:");

     firstNameTxt = new TextField();

     Button displayFNameBtn = new Button("Display First Name");

     this.getChildren().add(firstNameLbl);
     this.getChildren().add(firstNameTxt);
     this.getChildren().add(displayFNameBtn);

     displayFNameBtn.setOnAction(event -> {
     
         String firstName = personController.getPerson().getFirstName();
     
         firstNameTxt.setText(firstName);
         
         
     });
     
     
     //Note:
     // We could add an event handler in the view that interacts with the model
     // and gets the data
     //This pattern is referred to as Model View View Model (MVVM)
     
     // Another option is to use the Model View Controller (MVC) pattern
     // where each model has a controller that interfaces is actions with the views
     // and other services
     
     
    } 
    
       /*
    public VBox buildInterface(){
        
        VBox rootVbox = new VBox();
       
        Label firstNameLbl = new Label("First Name:");
         
        firstNameTxt = new TextField();
        
        Button displayFNameBtn = new Button("Display First Name");
        
        rootVbox.getChildren().add(firstNameLbl);
        rootVbox.getChildren().add(firstNameTxt);
        rootVbox.getChildren().add(displayFNameBtn);
               
        return rootVbox;
    }*/
}
