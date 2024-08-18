package my.study.coder.path.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class AverageOfLevelsInBinaryTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      double sum = 0.0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node != null ? node.val : 0;

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(sum / size);
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    TreeNode right1 = new TreeNode(20);
    root.right = right1;
    right1.left = new TreeNode(15);
    right1.right = new TreeNode(7);

    System.out.println(Arrays.toString(averageOfLevels(root).toArray()));
  }
}
