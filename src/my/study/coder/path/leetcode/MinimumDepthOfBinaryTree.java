package my.study.coder.path.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int depth = 1;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        if (node == null) {
          return depth;
        }

        if (node.left == null && node.right == null) {
          return depth;
        }

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }

      depth++;
    }

    return depth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);

    TreeNode left1 = new TreeNode(9);
    root.left = left1;
    left1.right = new TreeNode(123);
    left1.left = new TreeNode(666);

    TreeNode right1 = new TreeNode(20);
    root.right = right1;
    right1.left = new TreeNode(15);
    right1.right = new TreeNode(7);

    System.out.println(minDepth(root));
  }
}
