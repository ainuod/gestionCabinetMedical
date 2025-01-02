package models;

public class Appointment {
    private Patient patient;
    private String date;
    private String time;

    public Appointment(Patient patient, String date, String time) {
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "Appointment for Patient ID " + patient.getId() + " (" + patient.getFname() + " " + patient.getLname() + ") on " + date + " at " + time;
    }
}