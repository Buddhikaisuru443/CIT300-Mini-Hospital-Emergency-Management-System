package com.cit300.hospital;

import java.util.Scanner;

/**
 * Console-based entry point for the Mini Hospital Emergency Management System.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final HospitalSystem hospital = new HospitalSystem();

    public static void main(String[] args) {
        loadSampleData();

        System.out.println("==============================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> hospital.displayPatients();
                case 5 -> addPatientToQueue();
                case 6 -> callNextPatient();
                case 7 -> hospital.displayEmergencyQueue();
                case 8 -> completeTreatment();
                case 9 -> undoLastTreatment();
                case 10 -> hospital.displayTreatmentHistory();
                case 11 -> addVisit();
                case 12 -> removeVisit();
                case 13 -> searchVisit();
                case 14 -> displayVisitHistory();
                case 15 -> running = false;
                default -> System.out.println("Invalid choice. Please select 1-15.");
            }

            if (running) {
                pause();
            }
        }

        System.out.println("Thank you for using the Mini Hospital System.");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("--------------- MAIN MENU ----------------");
        System.out.println("PATIENT RECORDS (BST)");
        System.out.println("1. Register new patient");
        System.out.println("2. Search patient");
        System.out.println("3. Delete patient");
        System.out.println("4. Display patients (ascending Patient ID)");
        System.out.println();
        System.out.println("EMERGENCY QUEUE");
        System.out.println("5. Enqueue patient");
        System.out.println("6. Dequeue / call next patient");
        System.out.println("7. Display waiting queue");
        System.out.println();
        System.out.println("TREATMENT HISTORY (STACK)");
        System.out.println("8. Complete treatment / Push record");
        System.out.println("9. Pop last completed treatment");
        System.out.println("10. Display treatment history");
        System.out.println();
        System.out.println("PATIENT VISIT HISTORY (SINGLY LINKED LIST)");
        System.out.println("11. Add visit");
        System.out.println("12. Remove visit");
        System.out.println("13. Search visit");
        System.out.println("14. Display visit history");
        System.out.println();
        System.out.println("15. Exit");
        System.out.println("-------------------------------------------");
    }

    private static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");

        int id = readInt("Patient ID: ");
        if (hospital.findPatient(id) != null) {
            System.out.println("A patient with this ID already exists.");
            return;
        }

        String name = readText("Patient Name: ");
        int age = readInt("Age: ");
        String contact = readText("Contact Number: ");
        String condition = readText("Medical Condition: ");

        Patient patient = new Patient(id, name, age, contact, condition);

        if (hospital.registerPatient(patient)) {
            System.out.println("Patient registered successfully.");
        } else {
            System.out.println("Patient registration failed.");
        }
    }

    private static void searchPatient() {
        System.out.println("\n--- Search Patient ---");
        int id = readInt("Enter Patient ID: ");

        Patient patient = hospital.findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println("Patient found:");
            System.out.println(patient);
        }
    }

    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");
        int id = readInt("Enter Patient ID: ");

        if (hospital.deletePatient(id)) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void addPatientToQueue() {
        System.out.println("\n--- Add Patient to Emergency Queue ---");
        int id = readInt("Enter Patient ID: ");

        Patient patient = hospital.findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found. Register the patient first.");
            return;
        }

        hospital.addToEmergencyQueue(patient);
        System.out.println("Patient added to emergency queue.");
    }

    private static void callNextPatient() {
        System.out.println("\n--- Call Next Emergency Patient ---");

        Patient patient = hospital.callNextEmergencyPatient();

        if (patient == null) {
            System.out.println("Emergency queue is empty.");
        } else {
            System.out.println("Next patient for treatment:");
            System.out.println(patient);
        }
    }

    private static void completeTreatment() {
        System.out.println("\n--- Complete Treatment ---");
        int patientId = readInt("Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        String date = readText("Treatment Date (YYYY-MM-DD): ");
        String doctor = readText("Doctor Name: ");
        String treatment = readText("Treatment Given: ");
        String outcome = readText("Treatment Outcome: ");

        TreatmentRecord record = new TreatmentRecord(
                patient.getPatientId(),
                patient.getPatientName(),
                date,
                doctor,
                treatment,
                outcome
        );

        hospital.completeTreatment(record);
        System.out.println("Treatment completed and pushed onto the stack.");
    }

    private static void undoLastTreatment() {
        System.out.println("\n--- Pop Last Completed Treatment ---");

        TreatmentRecord record = hospital.undoLastCompletedTreatment();

        if (record == null) {
            System.out.println("Treatment history stack is empty.");
        } else {
            System.out.println("Removed most recent treatment:");
            System.out.println(record);
        }
    }

    private static void addVisit() {
        System.out.println("\n--- Add Patient Visit ---");
        int patientId = readInt("Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID: ");
        if (patient.getVisitHistory().searchVisit(visitId) != null) {
            System.out.println("A visit with this ID already exists for this patient.");
            return;
        }

        String date = readText("Visit Date (YYYY-MM-DD): ");
        String doctor = readText("Doctor Name: ");
        String diagnosis = readText("Diagnosis: ");
        String treatment = readText("Treatment: ");

        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        patient.getVisitHistory().addVisit(visit);

        System.out.println("Visit added successfully.");
    }

    private static void removeVisit() {
        System.out.println("\n--- Remove Patient Visit ---");
        int patientId = readInt("Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID to remove: ");

        if (patient.getVisitHistory().removeVisit(visitId)) {
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit not found.");
        }
    }

    private static void searchVisit() {
        System.out.println("\n--- Search Patient Visit ---");
        int patientId = readInt("Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);

        if (visit == null) {
            System.out.println("Visit not found.");
        } else {
            System.out.println("Visit found:");
            System.out.println(visit);
        }
    }

    private static void displayVisitHistory() {
        System.out.println("\n--- Patient Visit History ---");
        int patientId = readInt("Patient ID: ");

        Patient patient = hospital.findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Visit history for " + patient.getPatientName() + ":");
        patient.getVisitHistory().displayVisits();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    /**
     * Sample data makes the program easier to demonstrate.
     * You can delete this method before submission if your lecturer expects an empty start.
     */
    private static void loadSampleData() {
        Patient p1 = new Patient(1003, "Kamal Perera", 45, "0711234567", "Chest pain");
        Patient p2 = new Patient(1001, "Nadeesha Silva", 29, "0772345678", "Fever");
        Patient p3 = new Patient(1005, "Amal Fernando", 62, "0763456789", "Breathing difficulty");
        Patient p4 = new Patient(1002, "Saman Kumara", 37, "0754567890", "Fracture");

        hospital.registerPatient(p1);
        hospital.registerPatient(p2);
        hospital.registerPatient(p3);
        hospital.registerPatient(p4);

        p2.getVisitHistory().addVisit(new Visit(
                501, "2026-08-01", "Dr. Silva", "Viral fever", "Medication"
        ));
        p2.getVisitHistory().addVisit(new Visit(
                502, "2026-08-20", "Dr. Perera", "Follow-up", "Continue medication"
        ));

        hospital.addToEmergencyQueue(p1);
        hospital.addToEmergencyQueue(p3);

        hospital.completeTreatment(new TreatmentRecord(
                1002, "Saman Kumara", "2026-08-28", "Dr. Nimal",
                "Fracture treatment", "Stable"
        ));
        hospital.completeTreatment(new TreatmentRecord(
                1001, "Nadeesha Silva", "2026-08-29", "Dr. Silva",
                "Fever treatment", "Recovered"
        ));
    }
}
