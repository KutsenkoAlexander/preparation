package my.study.coder.path.leetcode;

import java.util.Iterator;

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

class ListNode<T> implements Iterable<T> {

    private static class Node<T> {
        private final T element;
        private Node<T> next;
        private Node(T element) {
            this.element = element;
        }
        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }
    }

    private Node<T> head;
    private Node<T> tail;

    void add(T element) {
        Node<T> newNode = Node.valueOf(element);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void revers() {
        if (head == null) {
            return;
        }

        tail = head;
        ListNode.Node<T> current = head.next;
        head.next = null;

        while (current != null) {
            ListNode.Node<T> next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
