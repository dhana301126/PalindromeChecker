public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string
        String text = "racecar";

        // Normalize the string (convert to lowercase)
        String normalizedText = text.toLowerCase();

        // Reverse the string
        String reversedText = new StringBuilder(normalizedText).reverse().toString();

        // Check if palindrome
        if (normalizedText.equals(reversedText)) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}