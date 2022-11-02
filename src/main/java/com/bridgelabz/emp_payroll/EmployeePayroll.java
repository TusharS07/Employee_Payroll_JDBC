package com.bridgelabz.emp_payroll;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeePayroll {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Salunkhe@07";

        //Driver loading
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded ");
        } catch (Exception e){
            System.out.println("Driver class not Found " +e);
        }

        //Connecting to database
        try {
            System.out.println("Connecting to database: " + jdbcURL);
            Connection connection =  DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!! " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ");
    }
}