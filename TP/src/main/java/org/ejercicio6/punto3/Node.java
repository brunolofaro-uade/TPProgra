package org.ejercicio6.punto3;

import java.util.Objects;

public class Node {
    int value;
    Node next;
    Node previous;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
