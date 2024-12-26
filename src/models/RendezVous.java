package models;

import java.time.LocalDateTime;

public class RendezVous {
    private Patient patient;
    private LocalDateTime dateHeure;

    public RendezVous(Patient patient, LocalDateTime dateHeure) {
        this.patient = patient;
        this.dateHeure = dateHeure;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "patient=" + patient +
                ", dateHeure=" + dateHeure +
                '}';
    }
}
