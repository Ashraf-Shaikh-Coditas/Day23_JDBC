package Week7.Day23_PreparedAndCallable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableDemo {
    public static void main(String[] args) {
        Connection connection;
        CallableStatement callableStatement;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments","root","root");

            callableStatement = connection.prepareCall("call InsertIntoTable(?,?)");
            callableStatement.setInt(1,1);
            callableStatement.setString(2,"Aman");
//            callableStatement.execute();


            callableStatement = connection.prepareCall("call getSum(?)");
            callableStatement.setInt(1,1);
            callableStatement.execute();

            callableStatement = connection.prepareCall("{call getSid(?,?)}");
            callableStatement.setInt(1,1);
            callableStatement.setString(2,"Ashraf");
            callableStatement.execute();




        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*

create procedure InsertIntoTable(IN id int,IN name varchar(20))
    -> begin
    -> insert into StudentName values(id,name);
    -> end
    -> $

* */

/*

create procedure getSum(out sum int)
    -> begin
    -> select sum(id) from StudentName;
    -> end
    -> $

* */

/*

 create procedure getSid(INOUT sid int ,IN sname varchar(10))
    -> begin
    -> select id from Student where name = sname;
    -> end
    -> $

* */