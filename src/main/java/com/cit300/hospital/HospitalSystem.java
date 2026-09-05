package com.cit300.hospital;

/**
 * Coordinates the four required data structures.
 */
public class HospitalSystem {
    private final PatientBST patientBST = new PatientBST();
    private final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private final TreatmentStack treatmentStack = new TreatmentStack();

    public boolean registerPatient(Patient patient) {
        return patientBST.insert(patient);
    }

    public Patient findPatient(int patientId) {
        return patientBST.search(patientId);
    }

    public boolean deletePatient(int patientId) {
        return patientBST.delete(patientId);
    }

    public void displayPatients() {
        patientBST.inOrderTraversal();
    }

    public void addToEmergencyQueue(Patient patient) {
        emergencyQueue.enqueue(patient);
    }

    public Patient callNextEmergencyPatient() {
        return emergencyQueue.dequeue();
    }

    public void displayEmergencyQueue() {
        emergencyQueue.displayQueue();
    }

    public void completeTreatment(TreatmentRecord record) {
        treatmentStack.push(record);
    }

    public TreatmentRecord undoLastCompletedTreatment() {
        return treatmentStack.pop();
    }

    public void displayTreatmentHistory() {
        treatmentStack.displayStack();
    }

    public boolean hasWaitingPatients() {
        return !emergencyQueue.isEmpty();
    }

    public boolean hasTreatmentHistory() {
        return !treatmentStack.isEmpty();
    }

    public int waitingCount() {
        return emergencyQueue.size();
    }

    public int treatmentHistoryCount() {
        return treatmentStack.size();
    }
}
