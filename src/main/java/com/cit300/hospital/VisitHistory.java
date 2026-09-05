package com.cit300.hospital;

/**
 * Custom singly linked list for a patient's previous visits.
 */
public class VisitHistory {

    private static class Node {
        private final Visit data;
        private Node next;

        private Node(Visit data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    /**
     * Adds a visit to the end of the list.
     */
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Removes the visit with the specified ID.
     * @return true if a visit was removed
     */
    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }

        if (head.data.getVisitId() == visitId) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getVisitId() == visitId) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Searches for a visit by ID.
     */
    public Visit searchVisit(int visitId) {
        Node current = head;

        while (current != null) {
            if (current.data.getVisitId() == visitId) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Displays all visits from oldest node to newest node.
     */
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
