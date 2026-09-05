package com.cit300.hospital;

/**
 * Custom Binary Search Tree using Patient ID as the key.
 */
public class PatientBST {

    private static class Node {
        private final Patient patient;
        private Node left;
        private Node right;

        private Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    /**
     * Inserts a patient using Patient ID as the BST key.
     * @return false when a duplicate ID already exists
     */
    public boolean insert(Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return true;
        }

        Node current = root;

        while (true) {
            if (patient.getPatientId() == current.patient.getPatientId()) {
                return false;
            }

            if (patient.getPatientId() < current.patient.getPatientId()) {
                if (current.left == null) {
                    current.left = new Node(patient);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(patient);
                    return true;
                }
                current = current.right;
            }
        }
    }

    /**
     * Searches the tree by Patient ID.
     */
    public Patient search(int patientId) {
        Node current = root;

        while (current != null) {
            if (patientId == current.patient.getPatientId()) {
                return current.patient;
            }

            if (patientId < current.patient.getPatientId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    /**
     * Deletes a patient from the BST.
     */
    public boolean delete(int patientId) {
        if (search(patientId) == null) {
            return false;
        }

        root = deleteRecursive(root, patientId);
        return true;
    }

    private Node deleteRecursive(Node node, int patientId) {
        if (node == null) {
            return null;
        }

        if (patientId < node.patient.getPatientId()) {
            node.left = deleteRecursive(node.left, patientId);
        } else if (patientId > node.patient.getPatientId()) {
            node.right = deleteRecursive(node.right, patientId);
        } else {
            // Case 1: no left child
            if (node.left == null) {
                return node.right;
            }

            // Case 2: no right child
            if (node.right == null) {
                return node.left;
            }

            // Case 3: two children
            // Replace the node itself with a new node containing the
            // in-order successor patient. This avoids changing the
            // immutable Patient ID of the existing Patient object.
            Node successor = findMin(node.right);
            Node replacement = new Node(successor.patient);
            replacement.left = node.left;
            replacement.right = deleteRecursive(node.right, successor.patient.getPatientId());

            return replacement;
        }

        return node;
    }

    private Node findMin(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    /**
     * Displays patients in ascending order of Patient ID.
     */
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node node) {
        if (node == null) {
            return;
        }

        inOrderRecursive(node.left);
        System.out.println(node.patient);
        inOrderRecursive(node.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
