package com.ust.traineeapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtil {
    private static Connection connection=null;
    private static final String url="jdbc:postgresql://localhost:5432/ust_db";
    private static final String username="postgres";
    private static final String password="postgres";
    public static Connection getConnection() {
        try{
            if(connection!=null){
                return connection;
            }
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("connection succesful");
            return connection;
        }
        catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
