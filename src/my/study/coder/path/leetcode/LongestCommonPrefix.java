package my.study.coder.path.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/?page=1&difficulty=EASY">14. Longest Common Prefix</a>
 */
public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    String result = strs[0];

    for (int i = 0; i < strs.length; i++) {
      while (strs[i].indexOf(result) != 0) {
        result = result.substring(0, result.length() - 1);
        if (result.isEmpty()) {
          return "";
        }
      }
    }
    return result;
  }
}
