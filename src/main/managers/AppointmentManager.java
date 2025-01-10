package main.managers;

import main.models.Appointment;
import main.models.Patient;
import java.util.ArrayList;

public class AppointmentManager {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public boolean isAvailable(String date, String time) {
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                return false;
            }
        }
        return true;
    }

    public void createAppointment(Patient patient, String date, String time) {
        if (isAvailable(date, time)) {
            Appointment newAppointment = new Appointment(patient, date, time);
            appointments.add(newAppointment);
            System.out.println("The appointment has been scheduled successfully for " + patient.getFname() + " " + patient.getLname() + " on " + date + " at " + time);
        } else {
            System.out.println("The selected time is already taken. Please choose another time.");
        }
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("Scheduled Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}
