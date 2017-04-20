import javax.swing.*;
import java.sql.*;


public class Java2MySql{
    public static final String url = "jdbc:mysql://localhost:3306/javabase";
    public static final String username = "root";
    public static final String password = "123";
    private static String loginusername; 
    private static String loginpassword;
    private static String EmailAdress;
    private static String UserType; 
    public static ResultSet rs; 

//    public static void connect(String[] args)  throws Exception {
      public static Connection connect()  throws Exception {    
        

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        Connection conn = null;
        conn = DriverManager.getConnection(url, username, password);
        return(conn);

 
//        Statement stmt = conn.createStatement();
////        String sql = "CREATE TABLE USER (Username VARCHAR(30) NOT NULL, Email_Address VARCHAR(30) NOT NULL, Passward VARCHAR(30) NOT NULL, UserType VARCHAR(30) NOT NULL, PRIMARY KEY (Username), UNIQUE (Email_Address));";
////
////        String sql = "CREATE TABLE tutor (Username VARCHAR(30) NOT NULL, Password VARCHAR(30) NOT NULL);";
////        String insert = "INSERT INTO tutor VALUES (\"ABC\", \"123\");";
////        stmt.executeUpdate(sql);
////        stmt.executeUpdate(insert);
//        rs = stmt.executeQuery("SELECT * FROM USER");
//        while (rs.next()) {
//            System.out.println(rs.getString(2)); //gets the first column's rows.
//            loginusername = rs.getString("Username");
//            EmailAdress = rs.getString("Email_Address");
//            loginpassword = rs.getString("Password");
//            UserType = rs.getString("UserType");             
//        }
//        stmt.close();
//        conn.close();
    }


    public ResultSet getResultSet() {
        return rs;
    }

}

