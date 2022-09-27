package Week7.Day23_PreparedAndCallable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class Image {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pst;

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments", "root", "root");
            pst = con.prepareStatement("insert into Image values(?,?)");
            pst.setString(1,"Image1");

            FileInputStream fin = new FileInputStream("C:\\Users\\Coditas\\IdeaProjects\\Java_Assignments\\src\\Week7\\Day23_PreparedAndCallable\\imageprevious.png");
            pst.setBinaryStream(2,fin);

//             pst.executeUpdate();

            pst = con.prepareStatement("select * from Image");
            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                Blob b = rs.getBlob(2);
                byte barr[] = b.getBytes(1,(int)b.length());

                FileOutputStream fout = new FileOutputStream("C:\\Users\\Coditas\\IdeaProjects\\Java_Assignments\\src\\Week7\\Day23_PreparedAndCallable\\imageNew.png");
                fout.write(barr);

                fout.close();
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}