package app;


// A generic SinglyLinkedList class that stores elements in ascending order.
public class SinglyLinkedList<T extends Comparable<T>> {
    // Pointers to the first and last nodes of the list.
    private Node<T> front;
    private Node<T> tail;
    // The size of the list to keep track of the number of elements.
    private int size;

    // A static inner class for the Node.
    public static class Node<T> {
        // The data stored within the node.
        T data;
        // The reference to the next node in the list.
        Node<T> next;

        // Node constructor initializes the node with data.
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Default constructor for an empty list.
    public SinglyLinkedList() {
        this.front = null;
        this.tail = null;
        this.size = 0;
    }

    // Copy constructor creates a new list as a copy of an existing list.
    public SinglyLinkedList(SinglyLinkedList<T> aList) {
        this();
        Node<T> current = aList.front;
        while (current != null) {
            this.insert(current.data);
            current = current.next;
        }
    }

    // Returns the data at the front of the list.
    public T front() {
        return (this.front != null) ? this.front.data : null;
    }

    // Returns the data at the tail of the list.
    public T back() {
        return (this.tail != null) ? this.tail.data : null;
    }

    // Inserts a new value into the list in the correct position to maintain order.
    public void insert(T val) {
        Node<T> newNode = new Node<>(val);
        // If the list is empty or the new value is less than the front value, insert at the front.
        if (this.front == null || val.compareTo(this.front.data) < 0) {
            newNode.next = this.front;
            this.front = newNode;
        } else {
            // Otherwise, find the correct position and insert the new node.
            Node<T> current = this.front;
            while (current.next != null && val.compareTo(current.next.data) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        // If the new node is inserted at the end, update the tail reference.
        if (newNode.next == null) {
            this.tail = newNode;
        }
        this.size++;
    }

    // Removes the front element from the list.
    public void pop_front() {
        if (this.front != null) {
            this.front = this.front.next;
            // If the list is now empty, update the tail reference.
            if (this.front == null) {
                this.tail = null;
            }
            this.size--;
        }
    }

    // Removes the last element from the list.
    public void pop_back() {
        if (this.front == null) {
            return;
        }
        if (this.front == this.tail) {
            // If there's only one element, clear the list.
            this.front = this.tail = null;
        } else {
            // Otherwise, find the second-to-last node and update its next reference.
            Node<T> current = this.front;
            while (current.next != this.tail) {
                current = current.next;
            }
            current.next = null;
            this.tail = current;
        }
        this.size--;
    }

    // Checks if the list is empty.
    public boolean isEmpty() {
        return this.front == null;
    }

    // Returns the number of elements in the list.
    public int size() {
        return this.size;
    }

    // Reverses the order of the elements in the list.
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = this.front;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // After reversing, the front becomes the tail and vice versa.
        this.tail = this.front;
        this.front = prev;
    }

    // Merges another list into this one, maintaining the ascending order.
    public void merge(SinglyLinkedList<T> aList) {
        Node<T> current = aList.front;
        while (current != null) {
            this.insert(current.data);
            current = current.next;
        }
    }
    // Method to find an element in the list
    public Node<T> find(T key) {
        Node<T> current = front;
        while (current != null) {
            if (current.data.equals(key)) {
                return current; // Found the key
            }
            current = current.next;
        }
        return null; // Key not found
    }

}
