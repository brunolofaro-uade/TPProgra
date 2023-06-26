package org.ejercicio6.punto3;

public class Queue implements IQueue {

    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void add(int number) {
        Node node = new Node(number);

        if (isEmpty()) {
            this.front = node;
            this.rear = node;
            node.setNext(node);
            node.setPrevious(node);
        } else {
            node.setPrevious(this.rear);
            node.setNext(this.front);
            this.rear.setNext(node);
            this.front.setPrevious(node);
            this.rear = node;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede descolar una cola vacía");
        }

        Node nodeToRemove = this.front;

        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.getNext();
            this.rear.setNext(this.front);
            this.front.setPrevious(this.rear);
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.front == null && this.rear == null);
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        return this.front.getValue();
    }

    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        return this.rear.getValue();
    }
}
