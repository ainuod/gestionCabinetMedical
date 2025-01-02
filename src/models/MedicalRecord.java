package models;

import java.util.ArrayList;

public class MedicalRecord {
    private Patient patient;
    private ArrayList<Consultation> consultations;

    public MedicalRecord(Patient patient) {
        this.patient = patient;
        this.consultations = new ArrayList<>();
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        StringBuilder record = new StringBuilder();
        record.append("Medical Record for Patient: ").append(patient).append("\n");
        record.append("Consultations:\n");
        for (Consultation consultation : consultations) {
            record.append(consultation).append("\n");
        }
        return record.toString();
    }
}

