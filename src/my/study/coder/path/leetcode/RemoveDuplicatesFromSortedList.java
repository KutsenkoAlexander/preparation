package my.study.coder.path.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/?page=1&difficulty=EASY">83. Remove Duplicates From Sorted List</a>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        ListNode headListNodeOne = initListNode(new int[]{1, 1, 2});
        ListNode headListNodeTwo = initListNode(new int[]{1, 1, 2, 3, 3});
        ListNode headListNodeThree = initListNode(new int[]{1, 1, 1, 3, 3});

        System.out.println("Given the head of a sorted linked list with duplicates.\n");
        System.out.println(headListNodeOne);
        System.out.println(headListNodeTwo);
        System.out.println(headListNodeThree);
        System.out.println("\nReturn the linked list sorted as well without duplicates.\n");
        System.out.println(deleteDuplicates(headListNodeOne));
        System.out.println(deleteDuplicates(headListNodeTwo));
        System.out.println(deleteDuplicates(headListNodeThree));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    private static ListNode initListNode(int[] arr) {
        ListNode head = null;
        ListNode tail = null;

        for (int number : arr) {
            ListNode newNode = new ListNode(number);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
