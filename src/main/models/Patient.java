package main.models;

public class Patient {
    private int id;
    private String fname;
    private String lname;
    private String birthDate;
    private String medicalHistory;
    private String surgicalHistory;

    public Patient(int id, String fname, String lname, String birthDate, String medicalHistory, String surgicalHistory) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.birthDate = birthDate;
        this.medicalHistory = medicalHistory;
        this.surgicalHistory = surgicalHistory;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + fname + " " 
        + lname + "\nBirth Date: " + birthDate + "\nMedical History: " +
         medicalHistory + "\nSurgical History: " + surgicalHistory;
    }
}