package my.study.coder.path.algorithm;

import java.util.Arrays;
import static java.lang.System.out;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 1, 6, 7, 2, 9, 4, 10, 1, 9, 3, 55};
        out.println("BEFORE");
        out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        out.println("AFTER");
        out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int from, int to) {
        if (array.length == 0) {
            return;
        }

        if (from >= to) {
            return;
        }

        int pivot = array[from + (to - from) / 2];

        // dividing an array
        int left = from, right = to;

        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        if (from < right)
            quickSort(array, from, right);

        if (to > left)
            quickSort(array, left, to);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
