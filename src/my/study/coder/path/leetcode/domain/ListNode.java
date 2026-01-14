package my.study.coder.path.leetcode.domain;

import java.util.Iterator;

public class ListNode<T> implements Iterable<T> {

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        private Node(T element) {
            this.element = element;
        }

        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T element) {
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
        Node<T> current = head.next;
        head.next = null;

        while (current != null) {
            Node<T> next = current.next;
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

    @Override
    public String toString() {
        return "ListNode{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
