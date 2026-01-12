package my.study.coder.path.leetcode;

import static java.lang.System.*;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/description/?page=1&difficulty=EASY">9. Palindrome Number</a>
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 */
public class PalindromeRunner {
    public static void main(String[] args) {
        int x = 121;
        out.println("Is palindrome " + x + " - " + isPalindrome(x));
        x = 123;
        out.println("Is palindrome " + x + " - " + isPalindrome(x));
        x = -121;
        out.println("Is palindrome " + x + " - " + isPalindrome(x));
        x = 10;
        out.println("Is palindrome " + x + " - " + isPalindrome(x));
    }

    private static boolean isPalindrome(int x) {
        int r;
        int sum = 0;
        int temp;
        temp = x;

        while (x > 0) {
            r = x % 10;
            sum = (sum * 10) + r;
            x = x / 10;
        }

        return sum == temp;
    }
}