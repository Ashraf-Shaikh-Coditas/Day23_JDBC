package Week7.Day23_PreparedAndCallable.Student;

import java.sql.*;
import java.text.Format;
import java.util.Formatter;

public class Student_CRUD {
    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Formatter formatter = new Formatter();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments", "root", "root");

            preparedStatement = connection.prepareStatement("create table student(id int ,name varchar(20),year varchar(20),percentage float,city varchar(20));");
//           //preparedStatement.execute();
//
//            preparedStatement.addBatch("insert into Student values(1,'Ashraf','BE',92,'Jalgaon');");
//            preparedStatement.addBatch(" insert into Student values(2,'Swaraj','TE',56,'Pune');");
//            preparedStatement.addBatch( "insert into Student values(3,'Hussain','TE',78,'Pune')");
//            preparedStatement.addBatch("insert into Student values(4,'Ajay','BE',87,'Ahmednagar');");
//            preparedStatement.addBatch("insert into Student values(5,'Sarthak','SE',90,'Ahmednagar');");
//            preparedStatement.addBatch("insert into Student values(6,'Dhiraj','FE',90,'Pune');");
//            preparedStatement.addBatch(" insert into Student values(7,'Harshal','FE',74,'Pune');");
//            preparedStatement.addBatch("insert into Student values(8,'Allaudin','BE',97,'Mumbai');");
//            preparedStatement.addBatch("insert into Student values(9,'Azim','BE',78,'Kolkata');");
//            preparedStatement.addBatch("insert into Student values(10,'Shubham','SE',58,'Kolkata');");
//            preparedStatement.addBatch("insert into Student values(11,'Sam','SE',98,'Pune');");
//            preparedStatement.addBatch("insert into Student values(12,'Tejas','TE',80,'Pune');");
//            preparedStatement.executeBatch();

//            resultSet = preparedStatement.executeQuery("select * from student");
//
//            System.out.println("-------------------------PRINING STUDENTS TABLE -------------------------------");
//            formatter.format("%13s %13s %11s %11s %13s\n", "ID", "Name", "Year", "Percentage", "City");
//            while (resultSet.next()) {
//                formatter.format("%13s %13s %11s %11s %13s \n", resultSet.getInt(1), resultSet.getString(2),
//                        resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
//            }
//            System.out.println(formatter);

//            preparedStatement.executeUpdate("alter table student add column gender varchar(10);");
//            preparedStatement.executeUpdate("update student set gender = 'M';");

//            resultSet = preparedStatement.executeQuery("select * from student where id between 1 and 10");
//
//            System.out.println("-------------------------PRINING STUDENTS TABLE -------------------------------");
//            formatter.format("%13s %13s %11s %11s %13s\n", "ID", "Name", "Year", "Percentage", "City");
//            while (resultSet.next()) {
//                formatter.format("%13s %13s %11s %11s %13s \n", resultSet.getInt(1), resultSet.getString(2),
//                        resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
//            }
//            System.out.println(formatter);

//            preparedStatement.addBatch("insert into Student values(13,'Shivam','SE',58,'Kolkata','M');");
//            preparedStatement.addBatch("insert into Student values(14,'Praveer','SE',98,'Pune','M');");
//            preparedStatement.addBatch("insert into Student values(15,'Aman','TE',80,'Pune','M');");
//            preparedStatement.addBatch("update Student set name = (select concat('Mr. ',name)) where gender = 'M';");
//            preparedStatement.addBatch("update Student set name = (select concat('Ms. ',name)) where gender = 'F';");
//            preparedStatement.addBatch("delete from student where year = 'BE';");
//            preparedStatement.executeBatch();

            resultSet = preparedStatement.executeQuery("select * from student");
            System.out.println("-------------------------PRINING STUDENTS TABLE AFTER UPDATION  -------------------------------");
            formatter.format("%13s %13s %11s %11s %13s\n", "ID", "Name", "Year", "Percentage", "City");
            while (resultSet.next()) {
                formatter.format("%13s %13s %11s %11s %13s \n", resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
            }
            System.out.println(formatter);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

/*

-------------------------PRINING STUDENTS TABLE -------------------------------
           ID          Name        Year  Percentage          City
            1        Ashraf          BE          92       Jalgaon
            2        Swaraj          TE          56          Pune
            3       Hussain          TE          78          Pune
            4          Ajay          BE          87    Ahmednagar
            5       Sarthak          SE          90    Ahmednagar
            6        Dhiraj          FE          90          Pune
            7       Harshal          FE          74          Pune
            8      Allaudin          BE          97        Mumbai
            9          Azim          BE          78       Kolkata
           10       Shubham          SE          58       Kolkata
           11           Sam          SE          98          Pune
           12         Tejas          TE          80          Pune



* */

/*

-------------------------PRINING STUDENTS TABLE ID Between 1 and 10-------------------------------
           ID          Name        Year  Percentage          City
            1        Ashraf          BE          92       Jalgaon
            2        Swaraj          TE          56          Pune
            3       Hussain          TE          78          Pune
            4          Ajay          BE          87    Ahmednagar
            5       Sarthak          SE          90    Ahmednagar
            6        Dhiraj          FE          90          Pune
            7       Harshal          FE          74          Pune
            8      Allaudin          BE          97        Mumbai
            9          Azim          BE          78       Kolkata
           10       Shubham          SE          58       Kolkata


* */

/*

-------------------------PRINING STUDENTS TABLE AFTER UPDATION  -------------------------------
           ID          Name        Year  Percentage          City
            2    Mr. Swaraj          TE          56          Pune
            3   Mr. Hussain          TE          78          Pune
            5   Mr. Sarthak          SE          90    Ahmednagar
            6    Mr. Dhiraj          FE          90          Pune
            7   Mr. Harshal          FE          74          Pune
           10   Mr. Shubham          SE          58       Kolkata
           11       Mr. Sam          SE          98          Pune
           12     Mr. Tejas          TE          80          Pune
           13    Mr. Shivam          SE          58       Kolkata
           14   Mr. Praveer          SE          98          Pune
           15      Mr. Aman          TE          80          Pune


* */