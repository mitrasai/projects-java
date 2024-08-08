package com.std.sms;

import com.std.sms.config.StudentDataBaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveStudent {
    public static void removeStudent(Scanner sc){
        System.out.println("----- Remove Student -----");
        int id = 0;
        while (true) {
            System.out.print("Enter the ID of the student to remove: ");
            try {
                id = sc.nextInt();
                sc.nextLine(); // consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for ID.");
                sc.next();
            }
        }

        try{
            Connection connection = StudentDataBaseConfiguration.createConnection();
            String remove = "DELETE FROM students WHERE std_id = ?";
            PreparedStatement st = connection.prepareStatement(remove);
            st.setInt(1, id);

            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("Student removed successfully.");
            }else{
                System.out.println("Student not found!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
