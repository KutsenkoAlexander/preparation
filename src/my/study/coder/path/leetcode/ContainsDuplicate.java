package my.study.coder.path.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/description/?page=1&difficulty=EASY">217. Contains Duplicate</a>
 */
public class ContainsDuplicate {
    static void main() {
        System.out.println("1. false: " + solutionOne(null));
        System.out.println("2. false: " + solutionOne(new int[]{}));
        System.out.println("3. false: " + solutionOne(new int[]{1}));
        System.out.println("4. true: " + solutionOne(new int[]{1,1}));
        System.out.println("5. false: " + solutionOne(new int[]{1,2}));
        System.out.println("6. true: " + solutionOne(new int[]{1,2,3,1}));
        System.out.println("7. false: " + solutionOne(new int[]{1,2,3,4}));
        System.out.println("8. true: " + solutionOne(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println("9. true: " + solutionOne(new int[]{40,1,2,3,4,5,6,7,40,8}));
        //-----------------------------------------------------------------
        System.out.println("-----------------------------------------------------------------");
        //-----------------------------------------------------------------
        System.out.println("10. false: " + solutionTwo(null));
        System.out.println("11. false: " + solutionTwo(new int[]{}));
        System.out.println("12. false: " + solutionTwo(new int[]{1}));
        System.out.println("13. true: " + solutionTwo(new int[]{1,1}));
        System.out.println("14. false: " + solutionTwo(new int[]{1,2}));
        System.out.println("15. true: " + solutionTwo(new int[]{1,2,3,1}));
        System.out.println("16. false: " + solutionTwo(new int[]{1,2,3,4}));
        System.out.println("17. true: " + solutionTwo(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println("18. true: " + solutionTwo(new int[]{40,1,2,3,4,5,6,7,40,8}));
    }

    private static boolean solutionOne(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private static boolean solutionTwo(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
