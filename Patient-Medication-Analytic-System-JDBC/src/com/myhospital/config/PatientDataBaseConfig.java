package com.myhospital.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class PatientDataBaseConfig {
    // create a connection
    private final static String URL = "jdbc:mysql://localhost:3306/medicationdb";
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
