package my.study.coder.path.algorithm;

import java.util.Arrays;
import static java.lang.System.out;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {55, 88, 11, 66, 77, 22, 99, 44, 110, 11, 99, 33, 53};
        Arrays.sort(array);
        out.println(Arrays.toString(array));
        int element = 99;
        int index = binarySearch(array, 0, array.length, element);
        out.println("Index of searchable element: " + element + " + is: " + index);
    }

    private static int binarySearch(int[] array, int startIndex, int endIndex, int element) {
        if (endIndex < startIndex) {
            return -1;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        if (array[middleIndex] == element) {
            return middleIndex;
        }

        if (array[middleIndex] > element) {
            return binarySearch(array, startIndex, middleIndex - 1, element);
        } else {
            return binarySearch(array, middleIndex + 1, endIndex, element);
        }
    }
}
