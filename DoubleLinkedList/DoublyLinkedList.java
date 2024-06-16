package DoubleLinkedList;



// Class representing a doubly linked list
public class DoublyLinkedList {
    DoublyNode head;  // Head of the list
    DoublyNode tail;  // Tail of the list
    int size;         // Size of the list

    // Method to create a new doubly linked list with a single node
    public void createDLL(int nodeValue) {
        head = new DoublyNode();  // Initialize the head node
        head.value = nodeValue;   // Set the value of the head node
        head.next = null;         // The next pointer of head is null
        head.prev = null;         // The previous pointer of head is null
        tail = head;              // Tail is also the head initially
        size = 1;                 // Size of the list is 1
    }

    // Method to insert a node at a given location in the doubly linked list
    public void insertDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();  // Create a new node
        newNode.value = nodeValue;              // Set the value of the new node
        if (head == null) {  // If the list is empty
            createDLL(nodeValue);  // Create a new list with the node
            return;
        } else if (location == 0) {  // Insert at the beginning
            newNode.next = head;     // New node's next is the current head
            newNode.prev = null;     // New node's prev is null
            head.prev = newNode;     // Current head's prev is the new node
            head = newNode;          // New node is now the head
        } else if (location >= size) {  // Insert at the end
            newNode.next = null;     // New node's next is null
            tail.next = newNode;     // Current tail's next is the new node
            newNode.prev = tail;     // New node's prev is the current tail
            tail = newNode;          // New node is now the tail
        } else {  // Insert in the middle
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {  // Traverse to the position
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;          // New node's prev is the temp node
            newNode.next = tempNode.next;     // New node's next is the temp node's next
            tempNode.next = newNode;          // Temp node's next is the new node
            newNode.next.prev = newNode;      // New node's next node's prev is the new node
        }
        size++;  // Increase the size of the list
    }

    // Method to traverse the list from head to tail
    public void traverseDLL() {
        if (head == null) {  // If the list is empty
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            while (tempNode != null) {  // Traverse till the end of the list
                System.out.print(tempNode.value);
                if (tempNode.next != null) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Method to traverse the list from tail to head
    public void reverseTraverseDLL() {
        if (tail == null) {  // If the list is empty
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            while (tempNode != null) {  // Traverse till the start of the list
                System.out.print(tempNode.value);
                if (tempNode.prev != null) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
        }
        System.out.print("\n");
    }

    // Method to search for a node with a given value
    public boolean searchNode(int nodeValue) {
        if (head != null) {  // If the list is not empty
            DoublyNode tempNode = head;
            int index = 0;
            while (tempNode != null) {  // Traverse the list
                if (tempNode.value == nodeValue) {
                    System.out.println("Node found at location: " + index);
                    return true;  // Node found
                }
                tempNode = tempNode.next;
                index++;
            }
        }
        System.out.println("Node not found");
        return false;  // Node not found
    }

    // Method to delete a node at a given location
    public void deleteNode(int location) {
        if (head == null) {  // If the list is empty
            System.out.println("DLL does not exist");
            return;
        } else if (location == 0) {  // Delete from the beginning
            if (size == 1) {  // If there is only one node
                head = tail = null;  // List becomes empty
                size--;
                return;
            } else {
                head = head.next;  // Head becomes the next node
                head.prev = null;  // New head's prev is null
                size--;
            }
        } else if (location >= size) {  // Delete from the end
            if (size == 1) {  // If there is only one node
                head = tail = null;  // List becomes empty
                size--;
                return;
            } else {
                tail = tail.prev;  // Tail becomes the previous node
                tail.next = null;  // New tail's next is null
                size--;
            }
        } else {  // Delete from the middle
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {  // Traverse to the position
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;  // Bypass the node to be deleted
            tempNode.next.prev = tempNode;       // Update the prev pointer of the next node
            size--;
        }
    }

    // Method to delete the entire doubly linked list
    public void deleteDLL() {
        DoublyNode tempNode = head;
        while (tempNode != null) {  // Traverse the list
            tempNode.prev = null;  // Remove the previous pointer of each node
            tempNode = tempNode.next;
        }
        head = tail = null;  // Set head and tail to null
        System.out.println("The DLL has been deleted");
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(10);          // Create a new doubly linked list with 10
        dll.insertDLL(20, 1);       // Insert 20 at position 1
        dll.insertDLL(30, 2);       // Insert 30 at position 2
        dll.insertDLL(40, 3);       // Insert 40 at position 3
        dll.traverseDLL();          // Traverse the list from head to tail
        dll.reverseTraverseDLL();   // Traverse the list from tail to head
        dll.searchNode(20);         // Search for node with value 20
        dll.deleteNode(2);          // Delete node at position 2
        dll.traverseDLL();          // Traverse the list again
        dll.deleteDLL();            // Delete the entire list
    }
}


