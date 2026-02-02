package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/?page=1&difficulty=EASY">1038. Binary Search Tree to Greater Sum Tree</a>
 */
public class BinarySearchTreeToGreaterSumTree {

    private static int sum = 0;

    static void main() {
        /*
               4
             /  \
            1    6
           / \  / \
          0  2 5   7
              \     \
              3     8
        */
        var firstTreeNode = initTreeNode(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        var result = solution(firstTreeNode);
        System.out.println(Arrays.toString(toArray(result))); // converts TreeNode to int array
    }

    private static TreeNode initTreeNode(Integer[] nums) {
        var root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode current = queue.poll();
            if (i < nums.length && nums[i] != null) {
                current.setLeft(new TreeNode(nums[i]));
                queue.offer(current.getLeft());
            }
            i++;
            if (i < nums.length && nums[i] != null) {
                current.setRight(new TreeNode(nums[i]));
                queue.offer(current.getRight());
            }
            i++;
        }
        return root;
    }

    private static TreeNode solution(TreeNode root) {
        calculateSum(root);
        return root;
    }

    private static void calculateSum(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        calculateSum(currentNode.getRight());
        sum += currentNode.getVal();
        currentNode.setVal(sum);
        calculateSum(currentNode.getLeft());
    }

    private static Object[] toArray(TreeNode root) {
        if (root == null) {
            return new Object[]{};
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root.getVal());

        while (root != null) {
            queue.offer(root.getLeft().getVal());
            result.add(root.getVal());
            result.add(root.getLeft().getVal());
            result.add(getRightVal(root.getRight()));
        }

        return queue.toArray();
    }

    private static int getRightVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var r = root.getVal();
        r = getRightVal(root.getRight());
        return r;
    }
}
