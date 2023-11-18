package app;

import app.SinglyLinkedList.Node;

public class Driver {
	public static void main(String[] args) {
		// Create a new SinglyLinkedList instance
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Test isEmpty on an empty list
        if (list.isEmpty()) {
            System.out.println("Test passed: List is empty initially.");
        } else {
            System.out.println("Test failed: List should be empty initially.");
        }
        System.out.println();
        // Test size on an empty list
        if (list.size() == 0) {
            System.out.println("Test passed: Size of empty list is 0.");
        } else {
            System.out.println("Test failed: Size of empty list should be 0.");
        }
        System.out.println();
        // Insert elements and time the insert operation
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        for (int i = 0; i < 1000; i++) {
            list.insert((int) (Math.random() * 1000));
        }
        stopwatch.stop();
        System.out.println("Time taken to insert 1000 elements: " + stopwatch);
        System.out.println();
        // Test size after insertions
        if (list.size() == 1000) {
            System.out.println("Test passed: Size is correct after insertions.");
        } else {
            System.out.println("Test failed: Size is incorrect after insertions.");
        }
        System.out.println();
        // Test if the list is not empty
        if (!list.isEmpty()) {
            System.out.println("Test passed: List is not empty after insertions.");
        } else {
            System.out.println("Test failed: List should not be empty after insertions.");
        }
        System.out.println();
        // Test front and back methods
        Integer firstElement = list.front();
        Integer lastElement = list.back();
        if (firstElement != null && lastElement != null && firstElement.compareTo(lastElement) <= 0) {
            System.out.println("Test passed: Front and back elements are correct.");
        } else {
            System.out.println("Test failed: Front and back elements are incorrect.");
        }
        System.out.println();

        // Test pop_front and pop_back
        int sizeBefore = list.size();
        list.pop_front();
        list.pop_back();
        if (list.size() == sizeBefore - 2) {
            System.out.println("Test passed: pop_front and pop_back work correctly.");
        } else {
            System.out.println("Test failed: pop_front and pop_back do not work correctly.");
        }
        System.out.println();
        // Test reverse
        firstElement = list.front();
        lastElement = list.back();
        list.reverse();
        if (list.front().equals(lastElement) && list.back().equals(firstElement)) {
            System.out.println("Test passed: reverse works correctly.");
        } else {
            System.out.println("Test failed: reverse does not work correctly.");
            System.out.println("front:" +list.front()+ " last element: "+ lastElement);
        }
        System.out.println();
        // Test merge
        SinglyLinkedList<Integer> anotherList = new SinglyLinkedList<>();
        anotherList.insert(500);
        System.out.println("old list + New list = "+ list.size()+ " + "+ anotherList.size()+ " = "+ (list.size() + anotherList.size()));
        list.merge(anotherList);
        if (list.size() == sizeBefore - 2 + 1) {
            System.out.println("Test passed: merge works correctly.");
        } else {
            System.out.println("Test failed: merge does not work correctly.");
            System.out.println("List size now: "+ list.size()+ " size before: "+ sizeBefore);
            System.out.println("added list size "+ anotherList.size());
            
        }
        System.out.println();
        // Insert specific elements for testing the find method
        list.insert(123);
        list.insert(456);


        // Test find method for 123
        stopwatch.start();
        Node<Integer> foundNode123 = list.find(123);
        stopwatch.stop();
        if (foundNode123 != null && foundNode123.data.equals(123)) {
            System.out.println("Test passed: find method correctly found 123. Time taken: " + stopwatch.elapsedTimeMillis() + ".");
        } else {
            System.out.println("Test failed: find method could not find 123.");
        }

        // Test find method for 456
        stopwatch.start();
        Node<Integer> foundNode456 = list.find(456);
        stopwatch.stop();
        if (foundNode456 != null && foundNode456.data.equals(456)) {
            System.out.println("Test passed: find method correctly found 456. Time taken: " + stopwatch.elapsedTimeMillis() + ".");
        } else {
            System.out.println("Test failed: find method could not find 456.");
        }

        // Test find method for a non-existent element (999)
        stopwatch.start();
        Node<Integer> foundNodeNotFound = list.find(999); // This should not be found
        stopwatch.stop();
        if (foundNodeNotFound == null) {
            System.out.println("Test passed: find method correctly did not find 999. Time taken: " + stopwatch.elapsedTimeMillis() + ".");
        } else {
            System.out.println("Test failed: find method incorrectly found 999.");
        }

        System.out.println("All tests completed.");
    }
}

