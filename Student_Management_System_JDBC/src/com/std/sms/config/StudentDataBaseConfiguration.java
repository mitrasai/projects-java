package com.std.sms.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDataBaseConfiguration {
    // create a connection
    private final static String URL = "jdbc:mysql://localhost:3306/studentsdb";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public static Connection createConnection(){
        Connection connection = null;
        try{
            // load drivers
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
