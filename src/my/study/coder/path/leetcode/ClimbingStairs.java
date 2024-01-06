package my.study.coder.path.leetcode;

public class ClimbingStairs {
  public static void main(String[] args) {
    System.out.println(climbStairs(2));
    System.out.println(climbStairs(3));
    System.out.println(climbStairs(4));
    System.out.println(climbStairs(5));
    System.out.println(climbStairs(6));
    System.out.println(climbStairs(7));
    System.out.println(climbStairs(8));
    System.out.println(climbStairs(9));
    System.out.println(climbStairs(45));
    System.out.println(climbStairs(46));
    System.out.println(climbStairs(0));
  }

  private static int climbStairs(int n) {
    if (n >= 1 && n <= 45) {
      int[] array = new int[n + 1];
      array[0] = 1;
      array[1] = 2;
      for (int i = 2; i <= n; i++) {
        array[i] = array[i - 1] + array[i - 2];
      }
      return array[n - 1];
    }
    return 0;
  }
}
