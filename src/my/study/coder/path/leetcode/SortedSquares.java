package my.study.coder.path.leetcode;

import java.util.Arrays;

public class SortedSquares {
  public static void main(String[] args) {
    int[] nums = {-4,-1,0,3,10};
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(sortedSquares(nums)));
  }

  public static int[] sortedSquares(int[] nums) {

    int size = nums.length;
    int left = 0;
    int right = size - 1;

    int[] result = new int[size];

    for (int i = size - 1; i >= 0; i--) {

      int leftNumPow = nums[left] * nums[left];
      int rightNumPow = nums[right] * nums[right];

      if (leftNumPow > rightNumPow) {
        result[i] = leftNumPow;
        left++;
      } else {
        result[i] = rightNumPow;
        right--;
      }
    }

    return result;
  }
}
