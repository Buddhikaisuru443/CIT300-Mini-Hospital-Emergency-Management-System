# CIT300 Demo Video Script (5-10 minutes)

## 1. Introduction - 30 to 45 seconds

"Hello, my name is [YOUR NAME]. This is my CIT300 Data Structures and Algorithms individual mid assignment. My project is a Mini Hospital Emergency Management System implemented in Java.

The main purpose is to simulate patient registration, emergency treatment requests, completed treatments, and patient visit history using four different data structures."

## 2. Explain the four data structures - about 1.5 minutes

### BST
"I use a Binary Search Tree for patient records. Patient ID is the key. Smaller IDs are stored on the left and larger IDs on the right. In-order traversal displays patients in ascending Patient ID order."

### Queue
"I use a queue for emergency patients. It follows FIFO, so the first patient added to the waiting queue is the first patient called for treatment."

### Stack
"I use a stack for completed treatment records. It follows LIFO, so the most recently completed treatment is the first record popped."

### Singly Linked List
"Each patient has a singly linked list containing previous hospital visits. Each visit is a node, and the nodes are connected through a next reference."

## 3. Show GitHub - about 45 seconds

Open the GitHub repository.

Show:

- Repository name
- Java source files
- README
- Commit history

Say:

"I developed the project progressively and used Git commits to record the implementation stages."

Only show commits that you actually made.

## 4. Run the system - about 3 minutes

### BST
1. Select option 4.
2. Explain that the displayed patients are sorted by Patient ID because of in-order traversal.
3. Select option 2 and search for Patient ID 1003.
4. Select option 3 and delete a patient.
5. Select option 4 again.

### Queue
1. Select option 7.
2. Explain the waiting order.
3. Select option 6.
4. Explain that the first waiting patient is removed, demonstrating FIFO.

### Stack
1. Select option 10.
2. Select option 9.
3. Explain that the most recently completed treatment is popped first.

### Linked List
1. Select option 14 for Patient ID 1001.
2. Add a visit using option 11.
3. Search the visit using option 13.
4. Display the history again using option 14.
5. Remove the visit using option 12.

## 5. Testing - about 30 seconds

Run `HospitalSystemTest`.

Say:

"I also created a test class to verify BST search and deletion, queue FIFO behavior, stack LIFO behavior, and linked list operations."

## 6. Design decisions - about 30 seconds

"The four structures were selected because each matches the problem naturally. The BST is useful for patient lookup by ID, the queue is appropriate for emergency arrival order, the stack represents the latest completed treatment first, and the linked list stores the patient's sequential visit history."

## 7. Reflection - about 30 seconds

"Through this assignment I learned how different data structures solve different real-world problems. I also improved my understanding of pointers or references, node-based structures, traversal, insertion, deletion, searching, FIFO, LIFO, and testing."

## Important

Use your own voice and show your own development environment and GitHub account. Do not claim a commit or implementation step that you did not actually perform.
