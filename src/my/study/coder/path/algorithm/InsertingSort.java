package my.study.coder.path.algorithm;

import java.util.Arrays;

public class InsertingSort {
  public static void main(String[] args) {
    int[] arr = { 2, 5, 4, 6, 1 };
    System.out.println(Arrays.toString(arr));
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int current = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > current) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = current;
    }
  }
}
