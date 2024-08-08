package com.std.sms;

import com.std.sms.config.StudentDataBaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.InputMismatchException;

public class InsertStudent {
    public static void addStudent(Scanner sc){
        int id = 0;
        while (true) {
            System.out.print("Enter ID: ");
            try {
                id = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for ID.");
                sc.next();
            }
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double gpa = 0.0;
        while (true) {
            System.out.print("Enter GPA: ");
            try {
                gpa = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for GPA.");
                sc.next();
            }
        }
        System.out.print("Enter City: ");
        String city = sc.nextLine();

        try{
            Connection connection = StudentDataBaseConfiguration.createConnection();
            String insert = "INSERT INTO students (std_id, std_name, std_gpa, city, university) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(insert);
            st.setInt(1, id);
            st.setString(2, name);
            st.setDouble(3, gpa);
            st.setString(4, city);
            st.setString(5, "JNTUH");

            int rowsInserted = st.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Student added successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
