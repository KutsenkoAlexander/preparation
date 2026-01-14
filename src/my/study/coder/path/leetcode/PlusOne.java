package my.study.coder.path.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/plus-one/?page=1&difficulty=EASY">66. Plus One</a>
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{2, 2, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 1, 1})));
        System.out.println("---------------------------");
        System.out.println(Arrays.toString(plusOne2(new int[]{2, 2, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne2(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne2(new int[]{9, 1, 1})));
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    private static int[] plusOne2(int[] digits) {
        int index = digits.length - 1;
        while (digits[index] == 9) {
            digits[index] = 0;
            index--;

            if (index < 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                break;
            }
        }
        if (index >= 0) {
            digits[index]++;
        }
        return digits;
    }
}
