import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class FifoLifoDemo {
    public static void main(String[] args) {
        // ---------- FIFO using Queue ----------
        Queue<String> fifoQueue = new LinkedList<>();
        fifoQueue.add("A");
        fifoQueue.add("B");
        fifoQueue.add("C");

        System.out.println("FIFO (Queue) output:");
        while (!fifoQueue.isEmpty()) {
            System.out.println(fifoQueue.poll()); // Removes elements in the order they were added
        }

        // ---------- LIFO using Stack ----------
        Stack<String> lifoStack = new Stack<>();
        lifoStack.push("A");
        lifoStack.push("B");
        lifoStack.push("C");

        System.out.println("\nLIFO (Stack) output:");
        while (!lifoStack.isEmpty()) {
            System.out.println(lifoStack.pop()); // Removes elements in reverse order
        }
    }
}