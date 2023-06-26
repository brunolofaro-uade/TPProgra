package org.ejercicio6.punto2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Set implements ISet {

    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            return;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return;
            }
        }
        candidate.setNext(new Node(a, null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node backup = this.first;
        Node candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        return count == set.count && Objects.equals(first, set.first);
    }

    public boolean isSubset(Set candidate) {
        boolean subset = true;

        ArrayList<Integer> setBackup = new ArrayList<>();

        while (!candidate.isEmpty() && subset != false) {
            int valueToCheck = candidate.choose();

            setBackup.add(valueToCheck);
            candidate.remove(valueToCheck);

            if (!this.contains(valueToCheck)) {
                subset = false;
            }
        }

        if (!setBackup.isEmpty()) {
            for (Integer number : setBackup) {
                candidate.add(number);
            }
        }

        return subset;
    }

    public boolean contains(int number) {
        Node candidate = this.first;
        while (candidate != null) {
            if (candidate.getValue() == number) {
                return true;
            }
            candidate = candidate.getNext();
        }
        return false;
    }

    public Set getComplement(Set candidate) {
        if (!this.isSubset(candidate)) {
            throw new IllegalArgumentException("El conjunto de entrada no es subconjunto de esta "
                    + "instancia");
        }

        Set complement = new Set();
        ArrayList<Integer> setBackup = new ArrayList<>();

        while (!this.isEmpty()) {
            int valueToCheck = this.choose();

            if (!candidate.contains(valueToCheck)) {
                complement.add(valueToCheck);
            }

            setBackup.add(valueToCheck);
            this.remove(valueToCheck);
        }

        if (!setBackup.isEmpty()) {
            for (Integer number : setBackup) {
                this.add(number);
            }
        }

        return complement;
    }
}
