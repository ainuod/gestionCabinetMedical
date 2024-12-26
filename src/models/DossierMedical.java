package models;

import java.util.ArrayList;
import java.util.List;

public class DossierMedical {
    private Patient patient;
    private List<String> consultations = new ArrayList<>();
    private List<String> prescriptions = new ArrayList<>();

    public DossierMedical(Patient patient) {
        this.patient = patient;
    }

    public void addConsultation(String consultation) {
        consultations.add(consultation);
    }

    public void addPrescription(String prescription) {
        prescriptions.add(prescription);
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
                "patient=" + patient +
                ", consultations=" + consultations +
                ", prescriptions=" + prescriptions +
                '}';
    }
}
