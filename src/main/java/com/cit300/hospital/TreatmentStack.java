package com.cit300.hospital;

/**
 * Custom LIFO stack for completed treatment records.
 */
public class TreatmentStack {

    private static class Node {
        private final TreatmentRecord record;
        private Node next;

        private Node(TreatmentRecord record) {
            this.record = record;
        }
    }

    private Node top;
    private int size;

    /**
     * Pushes a completed treatment record onto the top.
     */
    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Pops the most recently completed treatment record.
     */
    public TreatmentRecord pop() {
        if (top == null) {
            return null;
        }

        TreatmentRecord record = top.record;
        top = top.next;
        size--;
        return record;
    }

    /**
     * Displays records from most recent to oldest.
     */
    public void displayStack() {
        if (top == null) {
            System.out.println("Treatment history stack is empty.");
            return;
        }

        Node current = top;
        System.out.println("Completed treatment records (LIFO order):");

        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
