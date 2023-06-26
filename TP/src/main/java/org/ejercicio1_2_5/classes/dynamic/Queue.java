package org.ejercicio1_2_5.classes.dynamic;

import org.ejercicio1_2_5.classes.definition.IQueue;

public class Queue <T> implements IQueue<T> {

    private Node<T> first;

    @Override
    public void add(T a) {
        Node<T> node = new Node<T>((T) a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        Node<T> candidate = this.first;
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
    public Node<T> getFirst() throws Exception {
        if(this.first == null) {
            System.out.println("No se puede obtener el tope una cola vacia");
            throw new Exception();
        }
        return this.first;
    }
}
