package my.study.coder.path.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/submissions/1895397496/?page=1&difficulty=EASY">242. Valid Anagram</a>
 */
public class ValidAnagram {
    static void main() {
        var s = "anagram";
        var t = "nagaram";
        System.out.printf("'%s' and '%s' is anagram: %s%n", s, t, solution(s, t));
        s = "rat";
        t = "car";
        System.out.printf("'%s' and '%s' is anagram: %s%n", s, t, solution(s, t));
    }

    private static boolean solution(String s, String t) {
        var sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        var tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }
}
