package org.ejercicio1_2_5.classes.definition;

import org.ejercicio1_2_5.classes.dynamic.Node;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueue <T>{

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     * @param a valor a acolar.
     */
    void add(T a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    Node getFirst() throws Exception;

}
