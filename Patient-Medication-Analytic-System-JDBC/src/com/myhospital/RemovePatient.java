package com.myhospital;

import com.myhospital.config.PatientDataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemovePatient {
    // Remove patient based on patient_id
    public static void removePatient(int patientId) {
        try {
            Connection connection = PatientDataBaseConfig.createConnection();
            String deleteQuery = "DELETE FROM patients WHERE patient_id = ?";
            PreparedStatement st = connection.prepareStatement(deleteQuery);
            st.setInt(1, patientId);

            int rowsAffected = st.executeUpdate();
            connection.close();

            if (rowsAffected > 0) {
                System.out.println("Patient details have been successfully removed...");
            } else {
                System.out.println("No patient found with the given ID...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
