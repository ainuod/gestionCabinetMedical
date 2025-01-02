package managers;

import models.MedicalRecord;
import models.Patient;
import models.Consultation;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalRecordManager {
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    public MedicalRecord findOrCreateMedicalRecord(Patient patient) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getPatient().getId() == patient.getId()) {
                return record;
            }
        }
        MedicalRecord newRecord = new MedicalRecord(patient);
        medicalRecords.add(newRecord);
        return newRecord;
    }

    public void addConsultation(Patient patient, String diagnosis, String prescription) {
        MedicalRecord record = findOrCreateMedicalRecord(patient);
        record.addConsultation(new Consultation(diagnosis, prescription, LocalDate.now()));
        System.out.println("Consultation added to medical record.");
    }

    public void viewMedicalRecord(Patient patient) {
        MedicalRecord record = findOrCreateMedicalRecord(patient);
        System.out.println(record);
    }
}