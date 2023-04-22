package org.classes.definition;

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
    T getTop() throws Exception;

}
