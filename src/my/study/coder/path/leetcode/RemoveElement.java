package my.study.coder.path.leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,30,30,3,0,4,30}, 30));
        System.out.println(removeElement(new int[]{1}, 1));
        System.out.println(removeElement(new int[]{20}, 5));
        System.out.println(removeElement(new int[]{4,5}, 5));
        System.out.println(removeElement(new int[]{4,4,0,1,0,2}, 0));
        System.out.println(removeElement(new int[]{2,2,2,0,0}, 0));
        System.out.println(removeElement(new int[]{2,0,4}, 0));
        System.out.println(removeElement(new int[]{2,2,0,2,3,4,0,0,2}, 0));
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[count];
                nums[count] = nums[j];
                nums[j] = temp;
                count++;
            }
        }
        return count;
    }
}
