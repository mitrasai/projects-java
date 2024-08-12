package com.myhospital;

public class PatientOperations {

    public static void insertPatient(String patientName, String contactNumber, String email,
                                     double patientWeight, double patientHeight, double bmi, String bmiCategory,
                                     double bsa, double patientCardiac, double ci, String drug, int dose, double medication) {
        InsertPatient.insertPatientInfo(patientName, contactNumber, email, patientWeight, patientHeight, bmi, bmiCategory, bsa, patientCardiac, ci, drug, dose, medication);
    }

    public static void updatePatient(int patientId, String contactNo, String email,
                                     double patientWt, double patientHt, double patientCardiac,
                                     String drug, int dose) {
        UpdatePatient.updatePatient(patientId, contactNo, email, patientWt, patientHt, patientCardiac, drug, dose);
    }

    public static void removePatient(int patientId) {
        RemovePatient.removePatient(patientId);
    }
}
