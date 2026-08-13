public class Two_StringPalindrome {
    public static void main(String[] args) {
        String str = "markram";
        System.out.println("Original String: " + str);

        System.out.println("Is Palindrome: " + isPalindrome(str)); // #1 extends from One_ReverseString class

        System.out.println("Is Palindrome (using loop): " + checkPalindrome(str)); // #2 Fastest

        System.out.println("Is Palindrome (using recursion): " + checkPalindromeUsingRecursion(str)); // #3

        System.out.println("Is Palindrome (using StringBuilder): " + checkPalindromeUsingStringBuilder(str)); // #4
    }

    public static boolean isPalindrome(String str) {
        String reversedStr = One_ReverseString.usingStringBuilder(str);
        return str.equals(reversedStr);
    }

    public static boolean checkPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        int left = 0, right = str.length()-1;

        while (left < right) {
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean checkPalindromeUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return checkPalindromeUsingRecursion(str.substring(1, str.length() - 1));
    }

    public static boolean checkPalindromeUsingStringBuilder(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }
}
