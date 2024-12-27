package models;

public class Patient {
    // our attributes :3
    private int id;
    private String fname;
    private String lname;    
    private String birthDate;
    private String medicalHistory;
    private String surgicalHistory;

    // our constructor :3
    public Patient(int id, String fname, String lname, String birthDate, String medicalHistory, String surgicalHistory) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.birthDate = birthDate;
        this.medicalHistory = medicalHistory;
        this.surgicalHistory = surgicalHistory;
    }

    //some necessary getters :3
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }

    //toString method to display our patient objet :3
    @Override
    public String toString() {
        return "ID: " + id + "\nFull name: " + fname +" "+ lname + "\nDate of Birth: " + birthDate +
               "\nMedical History: " + medicalHistory + "\nSurgical History: " + surgicalHistory;
    }
}
