package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/description/">101. Symmetric Tree</a>
 */
public class SymmetricTree {
  public static void main(String[] args) {
    TreeNode case1 = new TreeNode(1,
      new TreeNode(2, new TreeNode(3), new TreeNode(4)),
      new TreeNode(2, new TreeNode(4), new TreeNode(3)));
    System.out.println(solution1(case1));
    System.out.println(solution2(case1));

    TreeNode case2 = new TreeNode(1,
      new TreeNode(2, null, new TreeNode(3)),
      new TreeNode(2, null, new TreeNode(3)));
    System.out.println(solution1(case2));
    System.out.println(solution2(case2));
  }

  public static boolean solution1(TreeNode root) {
    if (root == null) return true;
    return isSymmetricRecursion(root.getLeft(), root.getRight());
  }

  public static boolean solution2(TreeNode root) {
    if (root == null) return true;
    return isSymmetricIterable(root);
  }

  public static boolean isSymmetricRecursion(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    return left.getVal() == right.getVal()
      && isSymmetricRecursion(left.getLeft(), right.getRight())
      && isSymmetricRecursion(left.getRight(), right.getLeft());
  }

  public static boolean isSymmetricIterable(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    result.add(root.getVal());

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Integer val = null;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        val = node != null ? node.getVal() : null;
        if (node.getLeft() != null) {
          queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.add(node.getRight());
        }
      }
      result.add(val);
    }
    return false; // todo make this solution
  }
}
