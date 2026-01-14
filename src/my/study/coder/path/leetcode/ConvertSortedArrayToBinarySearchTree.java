package my.study.coder.path.leetcode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?page=1&difficulty=EASY">108. Convert Sorted Array To Binary Search Tree</a>
 */
public class ConvertSortedArrayToBinarySearchTree {
    static void main() {
        var numbs = new int[]{-10,-3,0,5,9};
        System.out.println(buildSubBst(numbs, 0, numbs.length - 1));
    }

    private static TreeNode buildSubBst(int[] numbs, int start, int end) {
        if (start > end) {
            return null;
        }
        var mid = (start + end) / 2;
        var midNode = new TreeNode(numbs[mid]);
        midNode.left = buildSubBst(numbs, start, end - 1);
        midNode.right = buildSubBst(numbs, mid + 1, end);
        return  midNode;
    }
}
