package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.SimpleListNode;

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

        SimpleListNode headListNodeOne = initListNode(new int[]{1, 1, 2});
        SimpleListNode headListNodeTwo = initListNode(new int[]{1, 1, 2, 3, 3});
        SimpleListNode headListNodeThree = initListNode(new int[]{1, 1, 1, 3, 3});

        System.out.println("Given the head of a sorted linked list with duplicates.\n");
        System.out.println(headListNodeOne);
        System.out.println(headListNodeTwo);
        System.out.println(headListNodeThree);
        System.out.println("\nReturn the linked list sorted as well without duplicates.\n");
        System.out.println(deleteDuplicates(headListNodeOne));
        System.out.println(deleteDuplicates(headListNodeTwo));
        System.out.println(deleteDuplicates(headListNodeThree));
    }

    private static SimpleListNode deleteDuplicates(SimpleListNode head) {
        SimpleListNode temp = head;
        while (temp != null && temp.getNext() != null) {
            if (temp.getVal() == temp.getNext().getVal()) {
                temp.setNext(temp.getNext().getNext());
            } else {
                temp = temp.getNext();
            }
        }
        return head;
    }

    private static SimpleListNode initListNode(int[] arr) {
        SimpleListNode head = null;
        SimpleListNode tail = null;

        for (int number : arr) {
            SimpleListNode newNode = new SimpleListNode(number);
            if (head == null) {
                head = newNode;
            } else {
                tail.setNext(newNode);
            }
            tail = newNode;
        }
        return head;
    }
}
