package org.ejercicio6.punto4;

public class Pair<T> {
    private T value;
    private int quantity;
    private Pair<T> next;

    public Pair(T value, int quantity) {
        this.value = value;
        this.quantity = quantity;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Pair<T> getNext() {
        return next;
    }

    public void setNext(Pair<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return quantity == pair.quantity && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
