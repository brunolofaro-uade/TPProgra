package org.ejercicio6.punto4;

/**
 * Precondición: para usar cualquiera de estos métodos, la estructura debe estar inicializada.
 */
public interface ISet<T> {

    /**
     * Postcondición: Agrega un valor al conjunto.
     *
     * @param value valor a agregar.
     */
    void add(T value);

    /**
     * Postcondición: Quita el elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param value valor a quitar.
     */
    void remove(T value);
    /**
     * @return <code>true</code> si el conjunto está vacío, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve un elemento del conjunto.
     */
    T choose();
}
