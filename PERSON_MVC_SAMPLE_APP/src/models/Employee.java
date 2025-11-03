package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.connectionManager;

public class Employee {

    private int ID;
    private String firstName;
    private String lastName;
    private static String title;
    private static int departmentID;

    @Override
    public String toString() {
        return "Employee [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
                + ", departmentID=" + departmentID + "]";
    }


    //constructor
    public Employee(int ID, String firstName, String lastName, String title, int departmentID) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.departmentID = departmentID;
    }


    //getters & setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getDepartmentID() {
        return departmentID;
    }


    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }



    //readOne()
    public static Employee readOne(int employeeId) {

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = connectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                return new Employee(id, firstName, lastName, title, departmentID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if employee not found
    }




}
