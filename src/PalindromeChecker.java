import java.util.Stack;

public class PalindromeChecker {

    // Enum to choose algorithm
    public enum Algorithm {
        ITERATIVE,
        RECURSIVE,
        STACK
    }

    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Normalize string (ignore spaces, punctuation, and case)
    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Iterative two-pointer palindrome check
    private boolean isPalindromeIterative(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Recursive palindrome check
    private boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    // Stack-based palindrome check
    private boolean isPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // Public method to choose algorithm dynamically
    public boolean checkPalindrome(Algorithm algo) {
        String normalized = normalize(this.text);

        switch (algo) {
            case ITERATIVE:
                return isPalindromeIterative(normalized);
            case RECURSIVE:
                return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
            case STACK:
                return isPalindromeStack(normalized);
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algo);
        }
    }

    // Demo
    public static void main(String[] args) {
        String text = "A man, a plan, a canal, Panama";
        PalindromeChecker checker = new PalindromeChecker(text);

        System.out.println("Iterative: " + checker.checkPalindrome(Algorithm.ITERATIVE));
        System.out.println("Recursive: " + checker.checkPalindrome(Algorithm.RECURSIVE));
        System.out.println("Stack: " + checker.checkPalindrome(Algorithm.STACK));
    }
}
