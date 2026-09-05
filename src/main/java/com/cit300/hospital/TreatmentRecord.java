package com.cit300.hospital;

/**
 * Stores information about a completed treatment.
 */
public class TreatmentRecord {
    private final int patientId;
    private final String patientName;
    private final String treatmentDate;
    private final String doctorName;
    private final String treatment;
    private final String outcome;

    public TreatmentRecord(int patientId, String patientName,
                           String treatmentDate, String doctorName,
                           String treatment, String outcome) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDate = treatmentDate;
        this.doctorName = doctorName;
        this.treatment = treatment;
        this.outcome = outcome;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getOutcome() {
        return outcome;
    }

    @Override
    public String toString() {
        return String.format(
                "Patient ID: %d | Name: %s | Date: %s | Doctor: %s | Treatment: %s | Outcome: %s",
                patientId, patientName, treatmentDate, doctorName, treatment, outcome
        );
    }
}
