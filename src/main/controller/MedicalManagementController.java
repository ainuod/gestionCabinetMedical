package main.controller;

import main.managers.PatientManager;
import main.managers.AppointmentManager;
import main.managers.MedicalRecordManager;
import main.models.Patient;

import java.util.Scanner;

public class MedicalManagementController {
    private PatientManager patientManager;
    private AppointmentManager appointmentManager;
    private MedicalRecordManager medicalRecordManager;
    private Scanner scanner;

    private String addPatientPrompt;
    private String dobPrompt;
    private String medicalHistoryPrompt;
    private String surgicalHistoryPrompt;
    private String patientAddedMessage;
    private String patientNotFoundMessage;
    private String diagnosisPrompt;
    private String prescriptionPrompt;
    private String appointmentDatePrompt;
    private String appointmentTimePrompt;
    private String enterPatientIdPrompt;
    private String consultationCompletedMessage;

    public MedicalManagementController(String language) {
        this.patientManager = new PatientManager();
        this.appointmentManager = new AppointmentManager();
        this.medicalRecordManager = new MedicalRecordManager();
        this.scanner = new Scanner(System.in);

        if (language.equals("FR")) {
            addPatientPrompt = "Entrez le nom (Prénom Nom) : ";
            dobPrompt = "Entrez la date de naissance (JJ/MM/AAAA) : ";
            medicalHistoryPrompt = "Entrez l'historique médical : ";
            surgicalHistoryPrompt = "Entrez l'historique chirurgical : ";
            patientAddedMessage = "Patient ajouté avec succès avec ID : ";
            patientNotFoundMessage = "Patient introuvable.";
            diagnosisPrompt = "Entrez le diagnostic de la consulation: ";
            prescriptionPrompt = "Entrez la prescription médicale: ";
            appointmentDatePrompt = "Entrez la date du rendez-vous (JJ/MM/AAAA) : ";
            appointmentTimePrompt = "Entrez l'heure du rendez-vous (HH:MM) : ";
            enterPatientIdPrompt = "Entrez l'ID du patient : ";
            consultationCompletedMessage = "Consultation terminée. Dossier médical mis à jour.";
        } else {
            addPatientPrompt = "Enter name (First Last): ";
            dobPrompt = "Enter date of birth (DD/MM/YYYY): ";
            medicalHistoryPrompt = "Enter medical history: ";
            surgicalHistoryPrompt = "Enter surgical history: ";
            patientAddedMessage = "Patient added successfully with ID: ";
            patientNotFoundMessage = "Patient not found.";
            diagnosisPrompt = "Enter diagnosis of the consultaion: ";
            prescriptionPrompt = "Enter prescription: ";
            appointmentDatePrompt = "Enter appointment date (DD/MM/YYYY): ";
            appointmentTimePrompt = "Enter appointment time (HH:MM): ";
            enterPatientIdPrompt = "Enter patient ID: ";
            consultationCompletedMessage = "Consultation completed. Medical record updated.";
        }
    }

    public void addPatient() {
        System.out.print(addPatientPrompt);
        String name = scanner.nextLine();
        String[] names = name.split(" ", 2);
        String fname = names[0];
        String lname = names.length > 1 ? names[1] : "";
        System.out.print(dobPrompt);
        String dob = scanner.nextLine();
        System.out.print(medicalHistoryPrompt);
        String medicalHistory = scanner.nextLine();
        System.out.print(surgicalHistoryPrompt);
        String surgicalHistory = scanner.nextLine();

        Patient newPatient = patientManager.addPatient(fname, lname, dob, medicalHistory, surgicalHistory);
        System.out.println(patientAddedMessage + newPatient.getId());
    }

    public void createAppointment() {
        System.out.print(enterPatientIdPrompt);
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientManager.findPatient(id);
        if (patient != null) {
            System.out.print(appointmentDatePrompt);
            String date = scanner.nextLine();
            System.out.print(appointmentTimePrompt);
            String time = scanner.nextLine();

            appointmentManager.createAppointment(patient, date, time);
        } else {
            System.out.println(patientNotFoundMessage);
        }
    }

    public void completeAppointment() {
        System.out.print(enterPatientIdPrompt);
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Patient patient = patientManager.findPatient(id);
        if (patient != null) {
            System.out.print(diagnosisPrompt);
            String diagnosis = scanner.nextLine();
            System.out.print(prescriptionPrompt);
            String prescription = scanner.nextLine();

            medicalRecordManager.addConsultation(patient, diagnosis, prescription);
            System.out.println(consultationCompletedMessage);
        } else {
            System.out.println(patientNotFoundMessage);
        }
    }

    public void viewMedicalRecord() {
        System.out.print(enterPatientIdPrompt);
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Patient patient = patientManager.findPatient(id);
        if (patient != null) {
            medicalRecordManager.viewMedicalRecord(patient);
        } else {
            System.out.println(patientNotFoundMessage);
        }
    }

    public void viewAppointments() {
        appointmentManager.viewAppointments();
    }
}
