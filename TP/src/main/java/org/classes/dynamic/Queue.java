package org.classes.dynamic;

import org.classes.definition.IQueue;

public class Queue <T> implements IQueue {

    private Node first;

    @Override
    public void add(Object a) {
        Node node = new Node(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getFirst() throws Exception {
        if(this.first == null) {
            System.out.println("No se puede obtener el tope una cola vacia");
            throw new Exception();
        }
        return (T) this.first.getValue();
    }
}
