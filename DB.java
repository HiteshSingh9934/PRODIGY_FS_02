package db;

import java.sql.*;
public class DB{
    private static final String URL="jdbc:mysql://localhost:3306/employee_management";
    private static final String USER="root";
    private static final String PASS="hittu@1234";
    static{
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch(Exception e){}
    }
    public static Connection get() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }
}

