public class PalindromeCheck {
    public static void main(String[] args) {
        // Hardcoded string
        String text = "level";

        // Normalize the string (optional: lowercase, remove spaces)
        String normalizedText = text.toLowerCase();

        // Reverse the string
        String reversedText = new StringBuilder(normalizedText).reverse().toString();

        // Compare original and reversed
        if (normalizedText.equals(reversedText)) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}