package my.study.coder.path.leetcode;

import static java.lang.System.out;

/**
 * #28 Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strStr() and Java's indexOf().
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        out.println(kmpSearch(haystack, needle));
    }

    private static int kmpSearch(String haystack, String needle) {
        int index = -1;

        if (needle == null || needle.isEmpty()) {
            index = 0;
        }

        int[] prefixFunctionValues = prefixFunction(needle);

        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                index = i - j;
                break;
            } else if (i < haystack.length() && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = prefixFunctionValues[j - 1];
                } else {
                    i++;
                }
            }
        }

        return index;
    }
    private static int[] prefixFunction(String needle) {
        var values = new int[needle.length()];

        for (int i = 1; i < needle.length(); i++) {
            int j = 0;
            while (i + j < needle.length() && needle.charAt(j) == needle.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }

        return values;
    }
}
