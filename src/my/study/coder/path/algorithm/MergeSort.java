package my.study.coder.path.algorithm;

import java.util.Arrays;
import static java.lang.System.out;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 1, 6, 7, 2, 9, 4, 10, 1, 9, 3, 55};
        out.println("BEFORE");
        out.println(Arrays.toString(array));

        mergeSort(array);
        out.println("AFTER");
        out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int n = array.length;

        if (n <= 1) {
            return;
        }

        int midIndex = n / 2;

        int[] arrayLeft = new int[midIndex];
        int[] arrayRight = new int[n - midIndex];

        System.arraycopy(array, 0, arrayLeft, 0, midIndex);

        if (n - midIndex >= 0) {
            System.arraycopy(array, midIndex, arrayRight, 0, n - midIndex);
        }

        mergeSort(arrayLeft);
        mergeSort(arrayRight);

        merge(array, arrayLeft, arrayRight, midIndex, n - midIndex);
    }

    public static void merge(int[] src, int[] arrayLeft, int[] arrayRight, int startLeft, int startRight) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < startLeft && j < startRight) {
            if (arrayLeft[i] <= arrayRight[j]) {
                src[k++] = arrayLeft[i++];
            } else {
                src[k++] = arrayRight[j++];
            }
        }
        while (i < startLeft) {
            src[k++] = arrayLeft[i++];
        }
        while (j < startRight) {
            src[k++] = arrayRight[j++];
        }
    }
}
