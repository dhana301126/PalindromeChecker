public class RecursivePalindrome {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String text) {
        // Normalize string: lowercase and remove non-alphanumeric characters
        text = text.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Base case: 0 or 1 character
        if (text.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recursive call on substring excluding first and last characters
        return isPalindrome(text.substring(1, text.length() - 1));
    }

    public static void main(String[] args) {
        String text = "RaceCar";

        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}