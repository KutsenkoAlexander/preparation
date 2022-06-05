package my.study.coder.path.algorithm;

import java.util.Arrays;

import static java.lang.System.out;

public class InsertSelectingSorting {
    public static void main(String[] args) {
        int[] array = {5, 8, 1, 6, 7, 2, 9, 4, 10, 1, 9, 3};
        insertSortingAlgorithm(array);
        out.println(Arrays.toString(array));
    }

    private static void insertSortingAlgorithm(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = minIndex(array, i);
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    private static int minIndex(int[] array, int startPosition) {
        int minIndex = startPosition;
        int minValue = array[startPosition];

        for (int i = startPosition + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static int maxIndex(int[] array, int startPosition) {
        int minIndex = startPosition;
        int minValue = array[startPosition];

        for (int i = startPosition + 1; i < array.length; i++) {
            if (array[i] > minValue) {
                minValue = array[i];
                minIndex = i;
            }

        }

        return minIndex;
    }
}
