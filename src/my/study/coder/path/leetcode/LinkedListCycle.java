package my.study.coder.path.leetcode;
import java.util.StringJoiner;

public class LinkedListCycle {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(3);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(0);
    ListNode listNode4 = new ListNode(-4);

    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode2;

    System.out.println(hasCycle(listNode1));
  }

  public static boolean hasCycle(ListNode head) {

    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) return true;
    }

    return false;
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
}
