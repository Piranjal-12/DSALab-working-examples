class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // 1. Find the length of the Singly Linked List (SLL)
    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // 2. Print the middle node of the Singly Linked List (SLL)
    public void printMiddle() {
        int length = getLength();
        if (length == 0) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        int middleIndex = length / 2;

        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }

        System.out.println("Middle node data: " + current.data);
    }

    // 3. Reverse the Singly Linked List (SLL) - Retain the original list
    public SinglyLinkedList reverse() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            reversedList.appendToFront(current.data);
            current = current.next;
        }
        return reversedList;
    }

    // Helper method to insert at the front of the reversed list
    private void appendToFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 4. Remove duplicates from a sorted Singly Linked List (SLL)
    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // 5. Merge two sorted Singly Linked Lists
    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.append(current1.data);
                current1 = current1.next;
            } else {
                mergedList.append(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.append(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.append(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    // 6. Delete the complete Singly Linked List (SLL)
    public void deleteList() {
        head = null;
        System.out.println("The list has been deleted.");
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.append(1);
        list.append(2);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original List:");
        list.printList();

        // Task 1: Find the length of the list
        System.out.println("Length of the list: " + list.getLength());

        // Task 2: Print the middle node of the list
        list.printMiddle();

        // Task 3: Reverse the list (and retain the original list)
        SinglyLinkedList reversedList = list.reverse();
        System.out.println("Reversed List:");
        reversedList.printList();

        // Task 4: Remove duplicates from the sorted list
        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.printList();

        // Task 5: Merge two sorted lists
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.append(6);
        list2.append(7);
        list2.append(8);
        SinglyLinkedList mergedList = SinglyLinkedList.merge(list, list2);
        System.out.println("Merged List:");
        mergedList.printList();

        // Task 6: Delete the complete list
        list.deleteList();
        list.printList();
    }
}

