package my.study.coder.path.leetcode;

import my.study.coder.path.leetcode.domain.SimpleListNode;

public class LinkedListCycle {

  public static void main(String[] args) {
    SimpleListNode simpleListNode1 = new SimpleListNode(3);
    SimpleListNode simpleListNode2 = new SimpleListNode(2);
    SimpleListNode simpleListNode3 = new SimpleListNode(0);
    SimpleListNode simpleListNode4 = new SimpleListNode(-4);

    simpleListNode1.setNext(simpleListNode2);
    simpleListNode3.setNext(simpleListNode4);
    simpleListNode4.setNext(simpleListNode2);
    simpleListNode2.setNext(simpleListNode3);

    System.out.println(hasCycle(simpleListNode1));
    System.out.println(hasCycle(new SimpleListNode(3)));

    SimpleListNode simpleListNode5 = new SimpleListNode(1);
    SimpleListNode simpleListNode6 = new SimpleListNode(2);

    simpleListNode5.setNext(simpleListNode6);
    simpleListNode6.setNext(simpleListNode5);

    System.out.println(hasCycle(simpleListNode5));
  }

  public static boolean hasCycle(SimpleListNode head) {

    if (head == null || head.getNext() == null) {
      return false;
    }

    SimpleListNode slow = head;
    SimpleListNode fast = head;

    while(fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if(slow == fast) return true;
    }

    return false;
  }
}
