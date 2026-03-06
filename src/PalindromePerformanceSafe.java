import java.util.Stack;

public class PalindromePerformanceSafe {

    public enum Algorithm {
        ITERATIVE, RECURSIVE, STACK
    }

    private String text;

    public PalindromePerformanceSafe(String text) {
        this.text = text;
    }

    // Normalize string (ignore spaces, punctuation, and case)
    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Iterative palindrome check
    private boolean iterative(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Recursive palindrome check
    private boolean recursive(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return recursive(str, left + 1, right - 1);
    }

    // Stack-based palindrome check
    private boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }

    // Public method to check palindrome with algorithm selection
    public boolean checkPalindrome(Algorithm algo) {
        String normalized = normalize(this.text);

        // Safety check for recursion
        if (algo == Algorithm.RECURSIVE && normalized.length() > 10000) {
            System.out.println("Skipping recursive algorithm: string too large for recursion.");
            algo = Algorithm.ITERATIVE; // fallback to safe iterative method
        }

        switch (algo) {
            case ITERATIVE:
                return iterative(normalized);
            case RECURSIVE:
                return recursive(normalized, 0, normalized.length() - 1);
            case STACK:
                return stackMethod(normalized);
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algo);
        }
    }

    // Measure execution time for an algorithm
    public long measureTime(Algorithm algo) {
        long start = System.nanoTime();
        checkPalindrome(algo);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        // Test string: adjust size to test performance
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) sb.append("a"); // 100k 'a's
        String testString = sb.toString();

        PalindromePerformanceSafe checker = new PalindromePerformanceSafe(testString);

        System.out.println("Iterative result: " + checker.checkPalindrome(Algorithm.ITERATIVE));
        System.out.println("Recursive result: " + checker.checkPalindrome(Algorithm.RECURSIVE));
        System.out.println("Stack result: " + checker.checkPalindrome(Algorithm.STACK));

        System.out.println("\nExecution times (nanoseconds):");
        System.out.println("Iterative: " + checker.measureTime(Algorithm.ITERATIVE));
        System.out.println("Recursive: " + checker.measureTime(Algorithm.RECURSIVE));
        System.out.println("Stack: " + checker.measureTime(Algorithm.STACK));
    }
}