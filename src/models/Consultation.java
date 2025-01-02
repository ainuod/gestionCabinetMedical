package models;

import java.time.LocalDate;

public class Consultation {
    private String diagnosis;
    private String prescription;
    private LocalDate date;

    public Consultation(String diagnosis, String prescription, LocalDate date) {
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Diagnosis: " + diagnosis + ", Prescription: " + prescription;
    }
}
