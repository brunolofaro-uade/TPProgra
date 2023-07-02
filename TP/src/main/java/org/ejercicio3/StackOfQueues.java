package org.ejercicio3;

import org.ejercicio3.interfaces.IStackOfQueues;

public class StackOfQueues implements IStackOfQueues {

    private QueueNode first;

    @Override
    public void add(Queue a) {
        this.first = new QueueNode(a, this.first);
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public Queue getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope de una pila vacia");
            return null;
        }
        return this.first.getValue();
    }
}
