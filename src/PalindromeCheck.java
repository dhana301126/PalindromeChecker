import java.util.Stack;

public class PalindromeCheck {
    public static void main(String[] args) {
        // Hardcoded string
        String text = "racecar";

        // Normalize the string (optional: lowercase and remove spaces)
        String normalizedText = text.toLowerCase().replaceAll("\\s+", "");

        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char ch : normalizedText.toCharArray()) {
            stack.push(ch);
        }

        // Build the reversed string by popping characters from stack
        StringBuilder reversedText = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedText.append(stack.pop());
        }

        // Check if palindrome
        if (normalizedText.equals(reversedText.toString())) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}