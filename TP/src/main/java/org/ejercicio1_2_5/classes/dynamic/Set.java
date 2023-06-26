package org.ejercicio1_2_5.classes.dynamic;
import org.ejercicio1_2_5.classes.definition.ISet;

import java.util.Objects;
import java.util.Random;

public class Set<T> implements ISet<T> {

    private Node<T> first;
    private int count;

    @Override
    public void add(T a) {
        if (contains(a)) {
            return;
        }

        Node<T> newNode = new Node<>(a, null);

        if (this.first == null) {
            this.first = newNode;
        } else {
            Node<T> current = this.first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        this.count++;
    }

    @Override
    public void remove(T a) {
        if (this.first == null) {
            return;
        }

        if (Objects.equals(this.first.getValue(), a)) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node<T> previous = this.first;
        Node<T> current = previous.getNext();

        while (current != null) {
            if (Objects.equals(current.getValue(), a)) {
                previous.setNext(current.getNext());
                this.count--;
                return;
            }

            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public boolean contains(T a) {
        Node<T> current = this.first;

        while (current != null) {
            if (Objects.equals(current.getValue(), a)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacío");
            return null;
        }

        int randomIndex = new Random().nextInt(this.count);
        Node<T> current = this.first;

        for (int i = 0; i < randomIndex; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set<?> set = (Set<?>) o;
        return count == set.count && Objects.equals(first, set.first);
    }
}
