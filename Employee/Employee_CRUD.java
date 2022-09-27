package Week7.Day23_PreparedAndCallable.Employee;

import java.sql.*;
import java.util.Formatter;

public class Employee_CRUD {
    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Formatter formatter = new Formatter();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments", "root", "root");

            // CREATE
            String sql = "create table Employee(id int, name varchar(20),designation varchar(20),doj Date,experience int,salary float,status varchar(20));";
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.execute();


            // CASE 1 : insert 10 records :
//            preparedStatement.addBatch("Insert into employee values (1,'Ashraf','ASE','2022-08-08',1,45000,'working')");
//            preparedStatement.addBatch("Insert into employee values (2,'Eoin','ASE','2019-08-08',4,21000,'working')");
//            preparedStatement.addBatch("Insert into employee values (3,'Sam','ASE','2016-08-08',6,45000,'left')");
//            preparedStatement.addBatch("Insert into employee values (4,'Alex','ASE','2014-08-08',8,45000,'left')");
//            preparedStatement.addBatch("Insert into employee values (5,'Jason','ASE','2018-08-08',4,45000,'working')");
//            preparedStatement.addBatch("Insert into employee values (6,'Moeen','ASE','2017-08-08',5,45000,'left')");
//            preparedStatement.addBatch("Insert into employee values (7,'Jos','ASE','2014-08-08',8,45000,'working')");
//            preparedStatement.addBatch("Insert into employee values (8,'Johnny','ASE','2021-08-08',1,45000,'working')");
//            preparedStatement.addBatch("Insert into employee values (9,'Tim','ASE','2021-08-08',1,45000,'left')");
//            preparedStatement.addBatch("Insert into employee values (10,'Harry','ASE','2012-08-08',10,45000,'working')");
//            preparedStatement.executeBatch();

            // Case 2 : Fetch All records :
            resultSet = preparedStatement.executeQuery("select * from employee;");
            while (resultSet.next()) {
                formatter.format("%13s %13s %20s %15s %15s %15s %15s\n", "ID", "Name", "Designation", "DOJ", "EXP", "Salary", "Status");
                while (resultSet.next()) {
                    formatter.format("%13s %13s %20s %15s %15s %15s %15s\n", resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6),
                            resultSet.getString(7));
                }
                System.out.println(formatter);
            }

            // Case 3 : alter table by adding city:
//            preparedStatement.executeUpdate("alter table employee add city varchar(10);");

//            preparedStatement.executeUpdate("update employee set city = 'Pune';");

//            Case 4 : Fetch employees whose salary > 20000 and city = 'Pune'
//            resultSet = preparedStatement.executeQuery("select * from employee where city = 'Pune' and salary > 20000");

//            while (resultSet.next()) {
//                formatter.format("%13s %13s %20s %15s %15s %15s %15s %15s\n", "ID", "Name", "Designation", "DOJ", "EXP", "Salary", "Status"
//                ,"City");
//                while (resultSet.next()) {
//                    formatter.format("%13s %13s %20s %15s %15s %15s %15s %15s\n", resultSet.getInt(1), resultSet.getString(2),
//                            resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6),
//                            resultSet.getString(7),resultSet.getString(8));
//                }
//                System.out.println(formatter);
//            }

//            Case 5 : update salary of employee by 1000 whose exp > 3 yrs
//            preparedStatement.executeUpdate("update employee set salary = salary + 1000 where experience > 3;");

//            Case 6 : delete left employees
//            preparedStatement.executeUpdate("delete from employee where status='left';");

//            resultSet = preparedStatement.executeQuery("select * from employee;");
//            while (resultSet.next()) {
//                formatter.format("%13s %13s %20s %15s %15s %15s %15s %15s\n", "ID", "Name", "Designation", "DOJ", "EXP", "Salary", "Status"
//                        , "City");
//                while (resultSet.next()) {
//                    formatter.format("%13s %13s %20s %15s %15s %15s %15s %15s\n", resultSet.getInt(1), resultSet.getString(2),
//                            resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6),
//                            resultSet.getString(7), resultSet.getString(8));
//                }
//                System.out.println(formatter);
//            }




        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*            // Case 2 : Fetch All records :


           ID          Name          Designation             DOJ             EXP          Salary          Status
            2          Eoin                  ASE      2019-08-08               4           21000         working
            3           Sam                  ASE      2016-08-08               6           45000            left
            4          Alex                  ASE      2014-08-08               8           45000            left
            5         Jason                  ASE      2018-08-08               4           45000         working
            6         Moeen                  ASE      2017-08-08               5           45000            left
            7           Jos                  ASE      2014-08-08               8           45000         working
            8        Johnny                  ASE      2021-08-08               1           45000         working
            9           Tim                  ASE      2021-08-08               1           45000            left
           10         Harry                  ASE      2012-08-08              10           45000         working



* */

/*//            Case 4 : Fetch employees whose salary > 20000 and city = 'Pune'


           ID          Name          Designation             DOJ             EXP          Salary          Status            City
            2          Eoin                  ASE      2019-08-08               4           21000         working            Pune
            3           Sam                  ASE      2016-08-08               6           45000            left            Pune
            4          Alex                  ASE      2014-08-08               8           45000            left            Pune
            5         Jason                  ASE      2018-08-08               4           45000         working            Pune
            6         Moeen                  ASE      2017-08-08               5           45000            left            Pune
            7           Jos                  ASE      2014-08-08               8           45000         working            Pune
            8        Johnny                  ASE      2021-08-08               1           45000         working            Pune
            9           Tim                  ASE      2021-08-08               1           45000            left            Pune
           10         Harry                  ASE      2012-08-08              10           45000         working            Pune


* */

/*//            Case 6 : delete left employees


           ID          Name          Designation             DOJ             EXP          Salary          Status            City
            2          Eoin                  ASE      2019-08-08               4           22000         working            Pune
            5         Jason                  ASE      2018-08-08               4           46000         working            Pune
            7           Jos                  ASE      2014-08-08               8           46000         working            Pune
            8        Johnny                  ASE      2021-08-08               1           45000         working            Pune
           10         Harry                  ASE      2012-08-08              10           46000         working            Pune

* */