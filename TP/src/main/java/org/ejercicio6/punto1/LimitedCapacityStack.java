package org.ejercicio6.punto1;

public class LimitedCapacityStack implements IStack {
    private Node first;
    private int maximumCapacity;
    private int currentSize;

    public LimitedCapacityStack(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.currentSize = 0;
    }

    @Override
    public void add(int a) {
        if (this.currentSize < this.maximumCapacity) {
            this.first = new Node(a, this.first);
            this.currentSize++;
        } else {
            throw new IllegalStateException("No se puede agregar un valor a la pila debido a que "
                    + "llegó a su capacidad máxima");
        }
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
        this.currentSize--;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
