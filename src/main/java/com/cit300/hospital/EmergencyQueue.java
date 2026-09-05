package com.cit300.hospital;

/**
 * Custom FIFO queue for emergency patients.
 */
public class EmergencyQueue {

    private static class Node {
        private final Patient patient;
        private Node next;

        private Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    /**
     * Enqueue: adds patient to the rear.
     */
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    /**
     * Dequeue: removes patient from the front.
     */
    public Patient dequeue() {
        if (front == null) {
            return null;
        }

        Patient patient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return patient;
    }

    /**
     * Displays all currently waiting patients.
     */
    public void displayQueue() {
        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        Node current = front;
        System.out.println("Patients waiting in emergency queue:");

        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}
