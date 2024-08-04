package com.myhospital;

import com.myhospital.config.DataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdatePatientDetails {
    // find with patient_name and update contact, email, patientwt., patientht., cardiac_output, drug_name, drug_dose
    public static void updatePatient(String patientName, String contactNo, String email,
                                 double patientWt, double patientHt, double patientCardiac,
                                 String drug, double dose){
        try{
            Connection connection = DataBaseConfig.createConnection();
            String updateQuery = "UPDATE patients SET patient_weight = ?, patient_height = ?, contact = ?, email = ?, " +
                    "cardiac_output = ?, drug_name = ?, `drug_dosage(mg)` = ? WHERE patient_name = ?";
            PreparedStatement st = connection.prepareStatement(updateQuery);
            st.setDouble(1, patientWt);
            st.setDouble(2, patientHt);
            st.setString(3, contactNo);
            st.setString(4, email);
            st.setDouble(5, patientCardiac);
            st.setString(6, drug);
            st.setDouble(7, dose);
            st.setString(8, patientName);

            st.executeUpdate();
            connection.close();
            System.out.println("Patient details have been successfully updated...");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
