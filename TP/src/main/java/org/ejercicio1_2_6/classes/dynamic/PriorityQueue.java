package org.ejercicio1_2_6.classes.dynamic;
public class PriorityQueue<T> {

    private PriorityNode<T> first;

    public void enqueue(T item, int priority) {
        PriorityNode<T> newNode = new PriorityNode<>(item, priority,null);

        if (first == null) {
            first = newNode;
        } else {
            if (newNode.getPriority() < first.getPriority()) {
                newNode.setNext(first);
                first = newNode;
            } else {
                PriorityNode<T> current = first;
                while (current.getNext() != null && newNode.getPriority() >= current.getNext().getPriority()) {
                    current = current.getNext();
                }
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            }
        }
    }

    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }

        T item = first.getValue();
        first = first.getNext();
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
