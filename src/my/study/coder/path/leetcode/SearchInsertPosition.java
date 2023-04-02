package my.study.coder.path.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }

    private static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] array, int startIndex, int endIndex, int element) {
        if (endIndex < startIndex) {
            return endIndex + 1;
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
