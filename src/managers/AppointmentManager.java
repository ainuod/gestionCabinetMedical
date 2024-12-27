package managers;

//our necessarry imports :3
import models.Appointment;
import models.Patient;
import java.util.ArrayList;

public class AppointmentManager {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    //method to check if the doctor is available during given time for an appointment :3
    public boolean availabity(String date, String time) {
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                return false; //ma fihach
            }
        }
        return true; //fiha
    }

    //methode to create the appointment (only when available ofc) :3
    public void createAppointment(Patient patient, String date, String time) {
        if (availabity(date, time)) {
            Appointment newAppointment = new Appointment(patient, date, time);
            appointments.add(newAppointment);
            System.out.println("Appointment scheduled successfully for " + patient.getFname() +" "+patient.getLname()+ " on " + date + " at " + time);
        } else {
            System.out.println("The selected time slot is unavailable. Please choose another time.");
        }
    }

    //method to view existing appointments :3
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

    //delete an appointment after it's been completed :3
    public void markAppointmentAsComplete(Appointment appointment) {
        appointments.remove(appointment);
        System.out.println("Appointment marked as completed and removed from the schedule.");
    }
}
