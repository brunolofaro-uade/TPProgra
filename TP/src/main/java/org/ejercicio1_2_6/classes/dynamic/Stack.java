package org.ejercicio1_2_6.classes.dynamic;

import org.ejercicio1_2_6.classes.definition.IStack;

public class Stack <T> implements IStack<T> {

    private Node<T> first;
    private int size;
    public Stack(){
        this.first = null;
        this.size = 0;
    }
    @Override
    public void add(T a) {
        this.first = new Node<T>((T)a, this.first);
        this.size++;
    }

    @Override
    public void remove() {
        if(this.first == null || this.size == 0) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
        this.size--;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public Node<T> getTop() throws Exception {
        if(this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            throw new Exception();
        }
        return this.first;
    }

    public int getSize() {
        return this.size;
    }
}
