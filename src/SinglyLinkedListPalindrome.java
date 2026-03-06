import java.util.Stack;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListPalindrome {
    public static void main(String[] args) {
        // Hardcoded string
        String text = "racecar";

        // Create singly linked list from string
        Node head = null;
        Node tail = null;
        for (char ch : text.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Push all characters onto a stack
        Stack<Character> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        // Compare linked list nodes with stack elements
        current = head;
        boolean isPalindrome = true;
        while (current != null) {
            if (current.data != stack.pop()) {
                isPalindrome = false;
                break;
            }
            current = current.next;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}