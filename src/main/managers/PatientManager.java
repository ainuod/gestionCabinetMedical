package main.managers;

import main.models.Patient;
import java.util.ArrayList;

public class PatientManager {
    private ArrayList<Patient> patients = new ArrayList<>();
    private int nextId = 1;

    public Patient addPatient(String fname, String lname, String birthDate, String medicalHistory, String surgicalHistory) {
        Patient newPatient = new Patient(nextId++, fname, lname, birthDate, medicalHistory, surgicalHistory);
        patients.add(newPatient);
        return newPatient;
    }

    public Patient findPatient(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }
}
