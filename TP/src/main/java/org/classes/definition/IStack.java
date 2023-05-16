package org.classes.definition;

import org.classes.dynamic.Node;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IStack <T> {

    /**
     * Postcondicion: Apila (coloca en el tope) un valor.
     * @param a valor a apilar.
     */
    void add(T a);

    /**
     * Precondicion: La pila no esta vacia.
     * Postcondicion: Desapila (quita el tope).
     */
    void remove();

    /**
     * @return <code>true</code> si la pila esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el tope.
     */
    Node getTop() throws Exception;

}
