# CIT300 - Mini Hospital Emergency Management System

## Student Assignment
**Course:** CIT300 - Data Structures and Algorithms  
**Project:** Mini Hospital Emergency Management System  
**Language:** Java  
**Application Type:** Console-based application

## 1. Project Overview

This project simulates the basic workflow of a hospital emergency unit. It demonstrates how different data structures can be used to solve different problems inside the system.

The project implements:

1. **Binary Search Tree (BST)** - stores patient records using Patient ID as the key.
2. **Queue** - manages emergency patients using FIFO order.
3. **Stack** - stores completed treatment records using LIFO order.
4. **Singly Linked List** - stores previous visits for each patient.

## 2. Patient Record - Binary Search Tree

Each patient contains:

- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

Operations:

- Insert/register patient
- Search patient by Patient ID
- Delete patient
- In-order traversal

The in-order traversal displays patients in ascending order of Patient ID.

## 3. Emergency Patient Queue

The queue uses the FIFO (First-In, First-Out) principle.

Operations:

- Enqueue a patient
- Dequeue the next patient
- Display all waiting patients
- Handle an empty queue

Example:

`Patient A -> Patient B -> Patient C`

The first patient removed is Patient A.

## 4. Treatment History - Stack

Completed treatments are stored in a custom stack using LIFO (Last-In, First-Out).

Operations:

- Push a completed treatment
- Pop the most recently completed treatment
- Display treatment history
- Handle an empty stack

## 5. Patient Visit History - Singly Linked List

Every Patient object contains a custom `VisitHistory`.

Each Visit contains:

- Visit ID
- Visit Date
- Doctor Name
- Diagnosis
- Treatment

Operations:

- Add visit
- Remove visit
- Search visit
- Display visit history

## 6. Project Structure

```text
CIT300-Mini-Hospital-Emergency-Management-System/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── cit300/
│   │               └── hospital/
│   │                   ├── Main.java
│   │                   ├── HospitalSystem.java
│   │                   ├── Patient.java
│   │                   ├── Visit.java
│   │                   ├── VisitHistory.java
│   │                   ├── PatientBST.java
│   │                   ├── EmergencyQueue.java
│   │                   ├── TreatmentRecord.java
│   │                   └── TreatmentStack.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── cit300/
│                   └── hospital/
│                       └── HospitalSystemTest.java
│
├── .gitignore
└── README.md
```

## 7. Requirements

Install:

- JDK 17 or later
- IntelliJ IDEA, Eclipse, VS Code, or another Java IDE
- GitHub Desktop (recommended for beginners) or Git

## 8. How to Run

### Using IntelliJ IDEA

1. Open the project folder.
2. Mark `src/main/java` as the source root if IntelliJ does not detect it automatically.
3. Open `Main.java`.
4. Click the Run button.
5. The application opens in the console.

### Using Command Prompt / Terminal

From the project root:

```bash
javac -d out src/main/java/com/cit300/hospital/*.java
java -cp out com.cit300.hospital.Main
```

To run the tests:

```bash
javac -d out src/main/java/com/cit300/hospital/*.java src/test/java/com/cit300/hospital/HospitalSystemTest.java
java -cp out com.cit300.hospital.HospitalSystemTest
```

## 9. Demonstration Flow

A good demonstration sequence is:

1. Display patient records to show BST in-order traversal.
2. Search for Patient ID 1003.
3. Delete a patient and display the BST again.
4. Display the emergency queue.
5. Dequeue the first emergency patient to demonstrate FIFO.
6. Display the treatment history.
7. Pop the latest treatment to demonstrate LIFO.
8. Add a visit to Patient ID 1001.
9. Search for the visit.
10. Display the patient's visit history.
11. Remove the visit and display the history again.
12. Run `HospitalSystemTest` and show that all tests pass.

## 10. Design Decisions

### BST
Patient ID is used as the key because it should uniquely identify a patient. A BST allows searching, insertion, and deletion based on the key.

### Queue
Emergency patients must be handled in arrival order, so FIFO is appropriate.

### Stack
Completed treatments are stored with the most recent treatment on top, allowing the latest record to be accessed first.

### Singly Linked List
A patient's previous visits form a sequential history. A linked list is suitable because visits can be added and removed without shifting an array.

## 11. Empty Structure Handling

The program safely handles:

- Searching for a patient that does not exist
- Dequeue on an empty queue
- Pop on an empty stack
- Searching/removing a missing visit
- Displaying an empty visit history

## 12. Testing

`HospitalSystemTest.java` checks:

- BST insertion, search and deletion
- Queue FIFO behavior
- Stack LIFO behavior
- Linked list add/search/remove operations
- Empty queue and stack behavior

