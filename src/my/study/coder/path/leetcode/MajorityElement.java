package my.study.coder.path.leetcode;

import java.util.Arrays;

public class MajorityElement {
  public static void main(String[] args) {
    System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
  }

  public static int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
