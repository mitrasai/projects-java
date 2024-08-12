package com.myhospital;

import com.myhospital.config.PatientDataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertPatient {
    public static void insertPatientInfo(String patientName, String contactNo, String email,
                                         double patientWt, double patientHt, double bmi,
                                         String bmiCategory, double bsa, double patientCardiac,
                                         double ci, String drug, double dose, double medication){
        try{
            Connection connection = PatientDataBaseConfig.createConnection();
            String insertQuery = "INSERT INTO patients (patient_name, contact, email, patient_weight, " +
                    "patient_height, `body_mass_index(kg/m^2)`, BMI_Category, `body_surface_area(m^2)`, " +
                    "cardiac_output, `cardiac_index(liters/minute/m^2)`, drug_name, `drug_dosage(mg)`, " +
                    "`medication_dosage(mg)`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = connection.prepareStatement(insertQuery);
            st.setString(1, patientName);
            st.setString(2, contactNo);
            st.setString(3, email);
            st.setDouble(4, patientWt);
            st.setDouble(5, patientHt);
            st.setDouble(6, bmi);
            st.setString(7, bmiCategory);
            st.setDouble(8, bsa);
            st.setDouble(9, patientCardiac);
            st.setDouble(10, ci);
            st.setString(11, drug);
            st.setDouble(12, dose);
            st.setDouble(13, medication);

            st.executeUpdate();
            connection.close();

            System.out.println("Patient details have been successfully inserted...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static class RemovePatient {
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
}
