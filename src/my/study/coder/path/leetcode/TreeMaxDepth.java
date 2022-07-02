package my.study.coder.path.leetcode;

import static java.lang.System.*;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Examples:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Input: root = [1,null,2]
 * Output: 2
 */
public class TreeMaxDepth {
    public static void main(String[] args) {
        out.println(calculateMaxDepth(
                new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        ));
        out.println(calculateMaxDepth(
                new TreeNode(1, null, new TreeNode(2))
        ));
    }

    private static int calculateMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = calculateMaxDepth(root.left);
        int rightLevel = calculateMaxDepth(root.right);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
