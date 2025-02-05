package my.study.coder.path.leetcode;

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
    return isSymmetricRecursion(root.left, root.right);
  }

  public static boolean solution2(TreeNode root) {
    if (root == null) return true;
    return isSymmetricIterable(root);
  }

  public static boolean isSymmetricRecursion(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    return left.val == right.val
      && isSymmetricRecursion(left.left, right.right)
      && isSymmetricRecursion(left.right, right.left);
  }

  public static boolean isSymmetricIterable(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    result.add(root.val);

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Integer val = null;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        val = node != null ? node.val : null;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(val);
    }
    return false; // todo make this solution
  }
}
