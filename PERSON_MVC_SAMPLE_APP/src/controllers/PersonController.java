/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Person;

/**
 *
 * @author elkhawac
 */
public class PersonController {
    Person person;
    
    
    public PersonController(){
        
        person = new Person();
        
    }
    
    public Person getPerson(){
        
        return person.getPerson();
        
    }    
    
}
