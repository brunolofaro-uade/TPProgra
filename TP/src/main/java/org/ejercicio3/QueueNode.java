package org.ejercicio3;

public class QueueNode {

    private Queue value;
    private QueueNode next;

    public QueueNode(Queue value, QueueNode next) {
        this.value = value;
        this.next = next;
    }

    public Queue getValue() {
        return value;
    }

    public void setValue(Queue value) {
        this.value = value;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        QueueNode node = (QueueNode) o;
//        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
//    }
}
