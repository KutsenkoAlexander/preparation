package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/same-tree/description/?page=1&difficulty=EASY">100. Same Tree</a>
 */
public class SameTree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(isSameTree(root1, root1));

    TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
    TreeNode root3 = new TreeNode(1, null, new TreeNode(3));
    System.out.println(isSameTree(root2, root3));

    TreeNode root4 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
    TreeNode root5 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
    System.out.println(isSameTree(root4, root5));
  }

  private static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.getVal() != q.getVal()) return false;
    return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
  }
}
