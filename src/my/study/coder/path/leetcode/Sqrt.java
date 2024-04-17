package my.study.coder.path.leetcode;

public class Sqrt {
  public static void main(String[] args) {
    System.out.println(mySqrt(32));
  }

  private static int mySqrt(final int x) {
    if (x >= 0)  {
      return (int) Math.sqrt(x);
    }
    return 0;
  }
}
