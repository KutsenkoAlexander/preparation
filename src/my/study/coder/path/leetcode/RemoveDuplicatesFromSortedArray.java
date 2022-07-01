package my.study.coder.path.leetcode;

import static java.lang.System.out;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
 * appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed
 * in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        out.println("Amount of non-duplicated elements: " + removeDuplicates(new int[]{1,1}));
        out.println("Amount of non-duplicated elements: " + removeDuplicates(new int[]{1,2,3}));
        out.println("Amount of non-duplicated elements: " + removeDuplicates(new int[]{1,1,2}));
        out.println("Amount of non-duplicated elements: " + removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int leftIndex = 1;
        int rightIndex = 1;
        int right = nums[rightIndex];
        for (int i = 1; i < nums.length; i++) {
            if (right == nums[i - 1]) {
                rightIndex = i + 1;
                if (rightIndex < nums.length) {
                    right = nums[rightIndex];
                }
            } else {
                nums[leftIndex] = right;
                leftIndex = leftIndex + 1;
                if (rightIndex < nums.length - 1) {
                    rightIndex = rightIndex + 1;
                    right = nums[rightIndex];
                }
            }
        }
        return leftIndex;
    }
}
