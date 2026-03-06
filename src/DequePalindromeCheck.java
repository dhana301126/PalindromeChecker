import java.util.ArrayDeque;
import java.util.Deque;

public class DequePalindromeCheck {
    public static void main(String[] args) {
        // Hardcoded string
        String text = "racecar";

        // Normalize string: lowercase, remove non-alphanumeric characters
        String normalizedText = text.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Create a deque
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to the deque
        for (char ch : normalizedText.toCharArray()) {
            deque.addLast(ch); // Add to the rear
        }

        // Check palindrome by comparing front and rear
        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}