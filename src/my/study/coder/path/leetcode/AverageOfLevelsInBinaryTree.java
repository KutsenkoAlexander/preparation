package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class AverageOfLevelsInBinaryTree {

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
        sum += node != null ? node.getVal() : 0;

        if (node.getLeft() != null) {
          queue.add(node.getLeft());
        }

        if (node.getRight() != null) {
          queue.add(node.getRight());
        }
      }
      result.add(sum / size);
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.setLeft(new TreeNode(9));
    TreeNode right1 = new TreeNode(20);
    root.setRight(right1);
    right1.setLeft(new TreeNode(15));
    right1.setRight(new TreeNode(7));

    System.out.println(Arrays.toString(averageOfLevels(root).toArray()));
  }
}
