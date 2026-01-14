package my.study.coder.path.leetcode.domain;

import java.util.StringJoiner;

public class SimpleListNode {
    private int val;
    private SimpleListNode next;

    public SimpleListNode(int val) {
        this.val = val;
    }

    public SimpleListNode(int val, SimpleListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public SimpleListNode getNext() {
        return next;
    }

    public void setNext(SimpleListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleListNode.class.getSimpleName() + "{", "}")
                .add("val=" + val)
                .add("next=" + next)
                .toString();
    }
}
