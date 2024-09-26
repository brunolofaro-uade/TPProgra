package org.ejercicio1_2_6.classes.definition;

public interface ISet<T> {

    void add(T a);

    void remove(T a);

    boolean contains(T a);

    boolean isEmpty();

    T choose();

    boolean equals(Object o);
}