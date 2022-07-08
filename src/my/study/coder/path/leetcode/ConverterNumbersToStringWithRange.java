package my.study.coder.path.leetcode;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Given a list of ints. It is necessary to convert this set into a string, folding numbers adjacent to the number series into ranges.

 Examples:
 [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
 [1,4,3,2] => "1-4"
 [1,4] => "1,4"
 [1,2] => "1-2"
 */
public class ConverterNumbersToStringWithRange {
    public static void main(String[] args) {
        int[] nums = {2,10,-10,-9,-1,-2,2,0,0,1,-2,9,-10};// result (-10)-(-9),(-2)-2,9-10
        out.println(converter(nums));
    }

    private static String converter(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Array should not be null");
        }

        if (nums.length == 0) {
            return "";
        }

        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        boolean isRange = false;

        for (int i = 0; i < nums.length; i++)
            if (i == nums.length - 1) {
                sb.append(nums[i]);
            } else {

                boolean isPositive = nums[i] >= 0;
                boolean isPositiveNeighbor = (nums[i + 1] - nums[i]) == 1;
                boolean isNegativeNeighbor = (nums[i] - nums[i + 1]) == -1;

                if ((nums[i + 1] - nums[i]) != 0 || (nums[i] - nums[i + 1]) != 0) {
                    if (isPositive && isPositiveNeighbor) {
                        if (!isRange) {
                            sb.append(nums[i]);
                            sb.append("-");
                            isRange = true;
                        }
                    } else if (!isPositive && isNegativeNeighbor) {
                        if (!isRange) {
                            sb.append("(");
                            sb.append(nums[i]);
                            sb.append(")");
                            sb.append("-");
                            isRange = true;
                        }

                    } else {
                        if (isPositive) {
                            sb.append(nums[i]);
                        } else {
                            sb.append("(");
                            sb.append(nums[i]);
                            sb.append(")");
                        }
                        sb.append(",");
                        isRange = false;

                    }
                }
            }

        return  sb.toString();
    }
}
