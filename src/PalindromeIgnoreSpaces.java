public class PalindromeIgnoreSpaces {
    public static void main(String[] args) {
        String text = "A man, a plan, a canal, Panama";

        // Normalize string: remove non-alphanumeric characters and convert to lowercase
        String normalizedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check palindrome using two-pointer approach
        int left = 0;
        int right = normalizedText.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (normalizedText.charAt(left) != normalizedText.charAt(right)) {
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