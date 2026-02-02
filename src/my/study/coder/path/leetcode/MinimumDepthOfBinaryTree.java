package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/?page=1&difficulty=EASY">104. Minimum Depth Of Binary Tree</a>
 */
public class MinimumDepthOfBinaryTree {

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

        if (node.getLeft() == null && node.getRight() == null) {
          return depth;
        }

        if (node.getLeft() != null) {
          queue.add(node.getLeft());
        }

        if (node.getRight() != null) {
          queue.add(node.getRight());
        }
      }

      depth++;
    }

    return depth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);

    TreeNode left1 = new TreeNode(9);
    root.setLeft(left1);
    left1.setRight(new TreeNode(123));
    left1.setLeft(new TreeNode(666));

    TreeNode right1 = new TreeNode(20);
    root.setRight(right1);
    right1.setLeft(new TreeNode(15));
    right1.setRight(new TreeNode(7));

    System.out.println(minDepth(root));
  }
}
