package com.cit300.hospital;

/**
 * Simple self-test class.
 * Run this class to verify the four required structures.
 */
public class HospitalSystemTest {

    public static void main(String[] args) {
        testBST();
        testQueue();
        testStack();
        testLinkedList();

        System.out.println("\nAll data structure tests passed.");
    }

    private static void testBST() {
        PatientBST bst = new PatientBST();

        bst.insert(new Patient(50, "P50", 20, "000", "A"));
        bst.insert(new Patient(30, "P30", 21, "000", "B"));
        bst.insert(new Patient(70, "P70", 22, "000", "C"));

        assertCondition(bst.search(30) != null, "BST search failed");
        assertCondition(bst.search(99) == null, "BST missing search failed");
        assertCondition(bst.delete(50), "BST deletion failed");
        assertCondition(bst.search(50) == null, "BST delete verification failed");

        System.out.println("BST test passed.");
    }

    private static void testQueue() {
        EmergencyQueue queue = new EmergencyQueue();

        Patient first = new Patient(1, "First", 20, "000", "A");
        Patient second = new Patient(2, "Second", 21, "000", "B");

        queue.enqueue(first);
        queue.enqueue(second);

        assertCondition(queue.dequeue() == first, "Queue FIFO order failed");
        assertCondition(queue.dequeue() == second, "Queue second dequeue failed");
        assertCondition(queue.dequeue() == null, "Empty queue handling failed");

        System.out.println("Queue test passed.");
    }

    private static void testStack() {
        TreatmentStack stack = new TreatmentStack();

        TreatmentRecord first = new TreatmentRecord(
                1, "First", "2026-01-01", "Dr A", "T1", "OK"
        );
        TreatmentRecord second = new TreatmentRecord(
                2, "Second", "2026-01-02", "Dr B", "T2", "OK"
        );

        stack.push(first);
        stack.push(second);

        assertCondition(stack.pop() == second, "Stack LIFO order failed");
        assertCondition(stack.pop() == first, "Stack second pop failed");
        assertCondition(stack.pop() == null, "Empty stack handling failed");

        System.out.println("Stack test passed.");
    }

    private static void testLinkedList() {
        VisitHistory history = new VisitHistory();

        history.addVisit(new Visit(
                101, "2026-01-01", "Dr A", "D1", "T1"
        ));
        history.addVisit(new Visit(
                102, "2026-01-02", "Dr B", "D2", "T2"
        ));

        assertCondition(history.searchVisit(101) != null, "Linked list search failed");
        assertCondition(history.removeVisit(101), "Linked list removal failed");
        assertCondition(history.searchVisit(101) == null, "Linked list delete verification failed");
        assertCondition(history.size() == 1, "Linked list size failed");

        System.out.println("Singly linked list test passed.");
    }

    private static void assertCondition(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
