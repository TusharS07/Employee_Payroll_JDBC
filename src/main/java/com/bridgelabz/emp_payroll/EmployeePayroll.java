package com.bridgelabz.emp_payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeePayroll {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Salunkhe@07";
        Connection connection = null;

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
            connection =  DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!! " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while (resultSet.next()){
                System.out.print(resultSet.getInt(1)+ " ");
                System.out.print(resultSet.getString(2)+ " ");
                System.out.print(resultSet.getString(3)+ " ");
                System.out.print(resultSet.getDouble(4)+ " ");
                System.out.print(resultSet.getDate(5)+ " ");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}