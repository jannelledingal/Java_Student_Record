package student_record;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LinearDataStructures {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose Data Structure:");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Linked List");
            System.out.println("4. Circular Linked List");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stackMenu(sc);
                    break;
                case 2:
                    queueMenu(sc);
                    break;
                case 3:
                    linkedListMenu(sc);
                    break;
                case 4:
                    circularLinkedListMenu(sc);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Stack Operations
    private static void stackMenu(Scanner sc) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("\n--- Stack Operations ---");
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    System.out.println("Pushed " + val + " into stack.");
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        int popped = stack.pop();
                        System.out.println("Popped: " + popped);
                    }
                    break;
                case 3:
                    System.out.print("Stack contents: ");
                    for (int i = stack.size() - 1; i >= 0; i--) {
                        System.out.print(stack.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }

    // Queue Operations
    private static void queueMenu(Scanner sc) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("\n--- Queue Operations ---");
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    queue.offer(val);
                    System.out.println("Enqueued " + val + " into queue.");
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        int dequeued = queue.poll();
                        System.out.println("Dequeued: " + dequeued);
                    }
                    break;
                case 3:
                    System.out.print("Queue contents: ");
                    for (int q : queue) {
                        System.out.print(q + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }

    // Linked List Operations
    private static void linkedListMenu(Scanner sc) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("\n--- Linked List Operations ---");
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert at end");
            System.out.println("2. Delete at beginning");
            System.out.println("3. Display");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    list.addLast(val);
                    System.out.println("Inserted " + val + " at end.");
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        int removed = list.removeFirst();
                        System.out.println("Deleted " + removed + " from beginning.");
                    }
                    break;
                case 3:
                    System.out.print("Linked List contents: ");
                    for (int l : list) {
                        System.out.print(l + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }

    // Circular Linked List Implementation
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    static class CircularLinkedList {
        Node last = null;

        void insert(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last;
            } else {
                newNode.next = last.next;
                last.next = newNode;
                last = newNode;
            }
            System.out.println("Inserted " + data);
        }

        void delete() {
            if (last == null) {
                System.out.println("Circular Linked List is empty.");
                return;
            }
            Node first = last.next;
            if (last == first) {
                System.out.println("Deleted " + first.data);
                last = null;
            } else {
                System.out.println("Deleted " + first.data);
                last.next = first.next;
            }
        }

        void display() {
            if (last == null) {
                System.out.println("Circular Linked List is empty.");
                return;
            }
            System.out.print("Circular Linked List contents: ");
            Node temp = last.next;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != last.next);
            System.out.println();
        }
    }

    // Circular Linked List Operations
    private static void circularLinkedListMenu(Scanner sc) {
        CircularLinkedList cll = new CircularLinkedList();
        System.out.println("\n--- Circular Linked List Operations ---");
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    cll.insert(val);
                    break;
                case 2:
                    cll.delete();
                    break;
                case 3:
                    cll.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }
}