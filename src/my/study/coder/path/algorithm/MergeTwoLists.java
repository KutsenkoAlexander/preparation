package my.study.coder.path.algorithm;

import java.util.StringJoiner;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6))));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(8))));

        System.out.println(mergeTwoLists(list1, list2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "{", "}")
                    .add("val=" + val)
                    .add("next=" + next)
                    .toString();
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            tail.next = list1;
            tail = list1;
            list1 = list1.next;
        }
        while (list2 != null) {
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }
        return head.next;
    }
}
