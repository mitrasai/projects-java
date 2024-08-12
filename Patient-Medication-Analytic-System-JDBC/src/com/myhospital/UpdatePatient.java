package com.myhospital;

import com.myhospital.config.PatientDataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdatePatient {
    // Update patient details using patient_id
    public static void updatePatient(int patientId, String contactNo, String email,
                                     double patientWt, double patientHt, double patientCardiac,
                                     String drug, double dose) {
        try {
            Connection connection = PatientDataBaseConfig.createConnection();
            String updateQuery = "UPDATE patients SET patient_weight = ?, patient_height = ?, contact = ?, email = ?, " +
                    "cardiac_output = ?, drug_name = ?, `drug_dosage(mg)` = ? WHERE patient_id = ?";
            PreparedStatement st = connection.prepareStatement(updateQuery);
            st.setDouble(1, patientWt);
            st.setDouble(2, patientHt);
            st.setString(3, contactNo);
            st.setString(4, email);
            st.setDouble(5, patientCardiac);
            st.setString(6, drug);
            st.setDouble(7, dose);
            st.setInt(8, patientId);

            st.executeUpdate();
            connection.close();
            System.out.println("Patient details have been successfully updated...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
