package main.gui;

import javax.swing.*;

import main.models.Appointment;
import main.models.Consultation;
import main.models.MedicalRecord;
import main.models.Patient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    //private MainGui mainGui;  


    public MainPanel(String language) {
        //this.mainGui = mainGui.getInstance();
        setLayout(new BorderLayout());

        //ImageIcon background = new ImageIcon("images/welcome_bg.png");
        //JLabel backgroundLabel = new JLabel(background);
        //add(backgroundLabel);

        // Create buttons for the 6 options
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true); 
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));  // Set grid layout for buttons
        buttonPanel.setBackground(new Color(8, 188, 184, 100));

        JButton addPatientButton = createOptionButton("Add Patient");
        JButton scheduleAppointmentButton = createOptionButton("Schedule Appointment");
        JButton viewAppointmentsButton = createOptionButton("View Appointments");
        JButton addConsultationButton = createOptionButton("Add Consultation");
        JButton viewMedicalRecordButton = createOptionButton("View Medical Record");
        JButton exitButton = createOptionButton("Exit");


        buttonPanel.add(addPatientButton);
        addPatientButton.setPreferredSize(new Dimension(500,100));
        addPatientButton.setBackground(new Color(255, 255, 255));
        addPatientButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 

        buttonPanel.add(scheduleAppointmentButton);
        scheduleAppointmentButton.setPreferredSize(new Dimension(500,100));
        scheduleAppointmentButton.setBackground(new Color(255, 255, 255));
        scheduleAppointmentButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 

        buttonPanel.add(viewAppointmentsButton);
        viewAppointmentsButton.setPreferredSize(new Dimension(500,100));
        viewAppointmentsButton.setBackground(new Color(255, 255, 255));
        viewAppointmentsButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 

        buttonPanel.add(addConsultationButton);
        addConsultationButton.setBackground(new Color(255, 255, 255));
        addConsultationButton.setPreferredSize(new Dimension(500,100));
        addConsultationButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 

        buttonPanel.add(viewMedicalRecordButton);
        viewMedicalRecordButton.setBackground(new Color(255, 255, 255));
        viewMedicalRecordButton.setPreferredSize(new Dimension(500,100));
        viewMedicalRecordButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 

        buttonPanel.add(exitButton);
        exitButton.setPreferredSize(new Dimension(500,100));
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 
        //exitButton.setBorder(BorderFactory.createRoundBorder(20));

        // Add the button panel to the main panel
        add(buttonPanel, BorderLayout.CENTER);

    }

    
    private ArrayList<Patient> patientsList = new ArrayList<>();
    private void showAddPatientDialog() {
        // Create a JDialog for the "Add Patient" form
        JDialog dialog = new JDialog(MainGui.getInstance(), "Add Patient", true);
        dialog.setLayout(new GridLayout(5, 2, 10, 10)); // Grid layout for form fields
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(MainPanel.this); // Center the dialog on the main panel
    
        // Labels for the fields
        JLabel nameLabel = new JLabel("Full Name:");
        JLabel dobLabel = new JLabel("Date of Birth (DD/MM/YYYY):");
        JLabel medicalHistoryLabel = new JLabel("Medical History:");
        JLabel surgicalHistoryLabel = new JLabel("Surgical History:");
    
        // Text fields for the user to input data
        JTextField nameField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField medicalHistoryField = new JTextField();
        JTextField surgicalHistoryField = new JTextField();
    
        // Submit button
        JButton submitButton = new JButton("Submit");
    
        // Add components to the dialog
        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(dobLabel);
        dialog.add(dobField);
        dialog.add(medicalHistoryLabel);
        dialog.add(medicalHistoryField);
        dialog.add(surgicalHistoryLabel);
        dialog.add(surgicalHistoryField);
        dialog.add(new JLabel()); // Empty cell for alignment
        dialog.add(submitButton);
    
        // Action for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String[] nameParts = name.split(" ");
                String fname = nameParts[0]; // First name
                String lname = nameParts.length > 1 ? nameParts[1] : ""; // Last name (if available)
                String dob = dobField.getText();
                String medicalHistory = medicalHistoryField.getText();
                String surgicalHistory = surgicalHistoryField.getText();
    
                // Create a new patient and add it to the list
                int patientId = patientsList.size() + 1; // Simple ID generation (incrementing size)
                Patient newPatient = new Patient(patientId, fname, lname, dob, medicalHistory, surgicalHistory);
                patientsList.add(newPatient);
    
                // Show the patient information (or process as needed)
                JOptionPane.showMessageDialog(dialog, 
                    "Patient Added:\n" + newPatient.toString());
                
                // Close the dialog
                dialog.dispose();
            }
        });
    
        // Make the dialog visible
        dialog.setVisible(true);
    }
    
    private ArrayList<Appointment> appointmentsList = new ArrayList<>();
    private void showScheduleAppointmentDialog() {
        // Step 1: Ask for Patient ID
        String patientIdInput = JOptionPane.showInputDialog("Enter Patient ID:");
        
        if (patientIdInput == null || patientIdInput.isEmpty()) {
            return;  // Exit if no ID is entered
        }
    
        int patientId;
        try {
            patientId = Integer.parseInt(patientIdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Patient ID.");
            return;
        }
    
        // Step 2: Check if patient exists in the patients list
        Patient patient = null;
        for (Patient p : patientsList) {
            if (p.getId() == patientId) {
                patient = p;
                break;
            }
        }
    
        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found.");
            return;
        }
    
        // Step 3: Ask for appointment date and time
        String appointmentDate = JOptionPane.showInputDialog("Enter appointment date (DD/MM/YYYY):");
        if (appointmentDate == null || appointmentDate.isEmpty()) {
            return;
        }
    
        String appointmentTime = JOptionPane.showInputDialog("Enter appointment time (HH:MM):");
        if (appointmentTime == null || appointmentTime.isEmpty()) {
            return;
        }
    
        // Step 4: Create an Appointment object
        Appointment newAppointment = new Appointment(patient, appointmentDate, appointmentTime);
        appointmentsList.add(newAppointment);
    
        // Step 5: Show confirmation
        JOptionPane.showMessageDialog(null, "Appointment scheduled:\n" + newAppointment.toString());
    }

    private void showViewAppointmentsDialog() {
        // Step 1: Check if there are any appointments
        if (appointmentsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No appointments scheduled.");
            return;
        }
    
        // Step 2: Create a panel to show the appointments
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use vertical layout
    
        // Step 3: Populate the panel with each appointment's details
        for (Appointment appointment : appointmentsList) {
            JLabel appointmentLabel = new JLabel(appointment.toString());
            panel.add(appointmentLabel);
        }
    
        // Step 4: Display the panel in a dialog
        JOptionPane.showMessageDialog(null, panel, "Appointments", JOptionPane.PLAIN_MESSAGE);
    }
    
    private ArrayList<MedicalRecord> medicalRecordsList = new ArrayList<>();
    private void showViewMedicalRecordDialog() {
        // Step 1: Ask for Patient ID
        String patientIdInput = JOptionPane.showInputDialog(null, "Enter Patient ID to view their medical record:");
        if (patientIdInput == null || patientIdInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Patient ID cannot be empty.");
            return;
        }
    
        int patientId = Integer.parseInt(patientIdInput);
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Patient with ID " + patientId + " not found.");
            return;
        }
    
        // Step 2: Find the Medical Record for the patient
        MedicalRecord medicalRecord = getMedicalRecordForPatient(patient);
    
        if (medicalRecord == null || medicalRecord.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No consultations found for this patient.");
        } else {
            // Step 3: Show the medical record
            JOptionPane.showMessageDialog(null, medicalRecord);
        }
    }
    
    // Helper method to find a patient by ID
    private Patient findPatientById(int id) {
        for (Patient patient : patientsList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null; // Patient not found
    }
    
    // Helper method to get the medical record of a patient
    private MedicalRecord getMedicalRecordForPatient(Patient patient) {
        // Assuming you have a list of medical records for patients (similar to the patientsList)
        // If you don't have a separate list for medical records, you can directly search through consultations
        for (MedicalRecord record : medicalRecordsList) {
            if (record.getPatient().getId() == patient.getId()) {
                return record;
            }
        }
        return null; // No medical record found
    }
    
    
    private void showAddConsultationDialog() {
        // Step 1: Ask for Patient ID
        String patientIdInput = JOptionPane.showInputDialog(null, "Enter Patient ID:");
        if (patientIdInput == null || patientIdInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Patient ID cannot be empty.");
            return;
        }

        // Step 2: Check if the patient exists
        int patientId = Integer.parseInt(patientIdInput);
        Patient patient = null;
        for (Patient p : patientsList) {
            if (p.getId() == patientId) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Patient with ID " + patientId + " not found.");
            return;
        }

        // Step 3: Get consultation details (Diagnosis, Prescription, Date)
        String diagnosis = JOptionPane.showInputDialog(null, "Enter Diagnosis:");
        String prescription = JOptionPane.showInputDialog(null, "Enter Prescription:");
        String dateInput = JOptionPane.showInputDialog(null, "Enter Date (YYYY-MM-DD):");

        if (diagnosis == null || prescription == null || dateInput == null) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        try {
            LocalDate date = LocalDate.parse(dateInput);

            // Step 4: Create the consultation and add it to the patient's medical record
            Consultation consultation = new Consultation(diagnosis, prescription, date);
            MedicalRecord medicalRecord = new MedicalRecord(patient); // You may already have this record saved
            medicalRecord.addConsultation(consultation);

            // Optionally, store the updated medical record in some list or database

            // Step 5: Show confirmation message
            JOptionPane.showMessageDialog(null, "Consultation added successfully for Patient: " + patient.getFname() + " " + patient.getLname());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    private JButton createOptionButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(500, 100));  // Set custom size for buttons
        button.setFont(new Font("Arial", Font.PLAIN, 18));  // Set font size

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (text) {
                    case "Exit":
                        int confirm = JOptionPane.showConfirmDialog(
                            MainPanel.this,
                            "Are you sure you want to exit?",
                            "Exit Confirmation",
                            JOptionPane.YES_NO_OPTION
                        );
                        if (confirm == JOptionPane.YES_OPTION) {
                            System.exit(0); // Exit the application
                        }
                        break;
                    case "Add Patient":
                        showAddPatientDialog();
                        break;
                    case "Schedule Appointment":
                        showScheduleAppointmentDialog();
                        break;
                    case "View Appointments":
                        showViewAppointmentsDialog();
                        break;
                    case "Add Consultation":
                        showAddConsultationDialog();  // Open the Add Consultation dialog
                        break;
                    case "View Medical Record":
                        showViewMedicalRecordDialog();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Unknown option selected.");
                }
            }
        });

        return button;
    }


}
