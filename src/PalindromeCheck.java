public class PalindromeCheck {
    public static void main(String[] args) {
        // Hardcoded string
        String text = "racecar";

        // Normalize the string (lowercase, optional: remove spaces)
        String normalizedText = text.toLowerCase();

        // Convert to character array
        char[] chars = normalizedText.toCharArray();

        // Initialize pointers
        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        // Compare characters from both ends
        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}