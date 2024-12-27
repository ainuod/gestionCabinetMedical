package models;

public class Appointment {
    private Patient patient;
    private String date; // DD/MM/YYYY (we trust our user to input correctly lol)
    private String time; // HH:MM (we trust our user to input correctly lol)

    // obviously, the contrustor :3
    public Appointment(Patient patient, String date, String time) {
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    // our necessary getters :3
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public Patient getPatient() {
        return patient;
    }

    //toString method to display our patient objet :3
    @Override
    public String toString() {
        return "Appointment for Patient ID " + patient.getId() + " (" + patient.getFname() +" "+patient.getLname()+ ") on " + date + " at " + time;
    }
}
