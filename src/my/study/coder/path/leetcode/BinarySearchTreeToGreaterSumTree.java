package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/?page=1&difficulty=EASY">1038. Binary Search Tree to Greater Sum Tree</a>
 *
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
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
        System.out.println(Arrays.toString(toArray(result).toArray())); // converts TreeNode to int array
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

    //TODO need fix method name + print correct order
    private static Queue<Integer> toArray(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root.getVal());
        if (root.getLeft() != null) {
            queue.addAll(toArray(root.getLeft()));
        } else {
            queue.add(null);
        }
        if (root.getRight() != null) {
            queue.addAll(toArray(root.getRight()));
        } else {
            queue.add(null);
        }
        return queue;
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
