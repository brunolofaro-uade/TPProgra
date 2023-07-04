package org.ejercicio6.punto4;

import java.util.Objects;

public class Node {

    private int value;
    private Node next;
    private int repetitionCount;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
        this.repetitionCount = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void addRepetition() {
        this.repetitionCount++;
    }

    public void subtractRepetition() {
        this.repetitionCount--;
    }

    public int getRepetitionCount() {
        return this.repetitionCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        boolean equals = getValue() == node.getValue()
                && getRepetitionCount() == node.getRepetitionCount()
                && Objects.equals(getNext(), node.getNext());

        return equals;
    }
}
