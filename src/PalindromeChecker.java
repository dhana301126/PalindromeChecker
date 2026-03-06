public class PalindromeChecker {

    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Normalize string: remove non-alphanumeric characters and convert to lowercase
    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Iterative method to check palindrome
    public boolean isPalindrome() {
        String normalizedText = normalize(this.text);

        int left = 0;
        int right = normalizedText.length() - 1;

        while (left < right) {
            if (normalizedText.charAt(left) != normalizedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Recursive method to check palindrome
    public boolean isPalindromeRecursive() {
        return isPalindromeRecursiveHelper(normalize(this.text), 0, normalize(this.text).length() - 1);
    }

    private boolean isPalindromeRecursiveHelper(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveHelper(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("RaceCar");
        System.out.println("\"RaceCar\" is palindrome? " + checker1.isPalindrome());

        PalindromeChecker checker2 = new PalindromeChecker("A man, a plan, a canal, Panama");
        System.out.println("\"A man, a plan, a canal, Panama\" is palindrome? " + checker2.isPalindromeRecursive());
    }
}