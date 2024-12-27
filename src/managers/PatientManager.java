package managers;

//our necessarry imports :3
import models.Patient;
import java.util.ArrayList;


public class PatientManager {
    
    //our attributes :3
    private ArrayList<Patient> patients = new ArrayList<>();
    private int nextId = 1; // Auto-incrementing patient ID

    // the constructor :3
    public Patient addPatient(String fname, String lname, String birthDate, String medicalHistory, String surgicalHistory) {
        Patient newPatient = new Patient(nextId++, fname, lname, birthDate, medicalHistory, surgicalHistory);
        patients.add(newPatient);
        return newPatient;
    }

    //method to find a patient in the "database" using the ID :3
    public Patient findPatient(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }
}
