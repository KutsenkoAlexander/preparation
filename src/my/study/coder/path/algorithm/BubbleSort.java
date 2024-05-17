package my.study.coder.path.algorithm;

import java.util.Arrays;

import static java.lang.System.out;

public class BubbleSort {
  public static void main(String[] args) {
    int[] array = {5, 8, 1, 6, 7, 2, 9, 4, 10, 1, 9, 3, 55};
    out.println("BEFORE");
    out.println(Arrays.toString(array));

    bubbleSort(array);
    out.println("AFTER");
    out.println(Arrays.toString(array));
  }

  private static void bubbleSort(int[] array) {

    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;
      for (int i = 1; i < array.length - 1; i++) {
        if (array[i] < array[i - 1]) {
          int temp = array[i];
          array[i] = array[i - 1];
          array[i - 1] = temp;
          isSorted = false;
        }
      }
    }
  }
}
