package my.study.coder.path.leetcode;

public class IsSameTree {

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
    if (p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
