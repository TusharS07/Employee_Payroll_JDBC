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
            //statement.executeUpdate("update employee_payroll set Salary = "+ salary +" where name = '"+ name +"'");
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
            ResultSet joinDate = statement.executeQuery("SELECT * FROM employee_payroll WHERE start BETWEEN CAST('2021-01-01' AS DATE) AND DATE(NOW())");
            while (joinDate.next()){
                System.out.print(joinDate.getInt(1)+ " ");
                System.out.print(joinDate.getString(2)+ " ");
                System.out.print(joinDate.getString(3)+ " ");
                System.out.print(joinDate.getDouble(4)+ " ");
                System.out.print(joinDate.getDate(5)+ " ");
                System.out.println();
            }

            //UC-6-Ability to find sum, average, min, max and number of male and female employees
            System.out.println("\n sum of male and female employees salary");
            ResultSet sum = statement.executeQuery("SELECT Gender, SUM(Salary) FROM employee_payroll GROUP BY Gender");
            while (sum.next()){
                System.out.print(sum.getString(1)+ " ");
                System.out.print(sum.getString(2)+ " ");
            }

            System.out.println();

            System.out.println("\n AVG of male and female employees salary");
            ResultSet avg = statement.executeQuery("SELECT Gender, AVG(Salary) FROM employee_payroll GROUP BY Gender");
            while (avg.next()){
                System.out.print(avg.getString(1)+ " ");
                System.out.print(avg.getString(2)+ " ");
            }

            System.out.println();

            System.out.println("\n MIN of male and female employees salary");
            ResultSet min = statement.executeQuery("SELECT Gender, MIN(Salary) FROM employee_payroll GROUP BY Gender");
            while (min.next()){
                System.out.print(min.getString(1)+ " ");
                System.out.print(min.getString(2)+ " ");
            }

            System.out.println();

            System.out.println("\n MAX of male and female employees salary");
            ResultSet max = statement.executeQuery("SELECT Gender, MAX(Salary) FROM employee_payroll GROUP BY Gender");
            while (max.next()){
                System.out.print(max.getString(1)+ " ");
                System.out.print(max.getString(2)+ " ");
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}