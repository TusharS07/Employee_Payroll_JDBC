package com.bridgelabz.emp_payroll;

import java.sql.*;

public class EmployeePayroll {
    public static void main(String[] args) throws SQLException {
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
            //UC2 = update salary of emplyoee
            String name = "Ashwini";
            double salary = 30000000;
            statement.executeUpdate("update employee_payroll set Salary = "+ salary +" where name = '"+ name +"'");
            //show database data
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while (resultSet.next()){
                System.out.print(resultSet.getInt(1)+ " ");
                System.out.print(resultSet.getString(2)+ " ");
                System.out.print(resultSet.getString(3)+ " ");
                System.out.print(resultSet.getDouble(4)+ " ");
                System.out.print(resultSet.getDate(5)+ " ");
                System.out.println();
            }

            //UC5= retrive employees who have joined in a particular data range from the payroll service database.
            System.out.println("\n Employee data who joined from '2021-01-01' ");
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM employee_payroll WHERE start BETWEEN CAST('2021-01-01' AS DATE) AND DATE(NOW())");
            while (resultSet2.next()){
                System.out.print(resultSet2.getInt(1)+ " ");
                System.out.print(resultSet2.getString(2)+ " ");
                System.out.print(resultSet2.getString(3)+ " ");
                System.out.print(resultSet2.getDouble(4)+ " ");
                System.out.print(resultSet2.getDate(5)+ " ");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}