package my.study.coder.path.leetcode.reverslinkedlist;

import static java.lang.System.out;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>();

        for (int i = 0; i < 10; i++) {
            listNode.add(i);
        }

        listNode.forEach(out::println);
        out.println("-----------------------");
        listNode.revers();
        listNode.forEach(out::println);
    }
}
