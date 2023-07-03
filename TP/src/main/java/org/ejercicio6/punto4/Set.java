package org.ejercicio6.punto4;

import org.ejercicio6.punto4.ISet;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Set<T> implements ISet {

    private Pair<T> first;
    private int count;

    @Override
    public void add(T value, int quantity) {
        Pair<T> newPair = new Pair<>(value, quantity);

        if (this.first == null) {
            this.first = newPair;
            this.count++;
            return;
        }

        if (this.first.equals(newPair)) {
            return;
        }

        Pair<T> candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.equals(newPair)) {
                return;
            }
        }
        candidate.setNext(newPair);
        this.count++;
    }

    @Override
    public void remove(T value) {
        if (this.first == null || (this.first.getNext() == null && this.first.equals(value))) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.equals(value)) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.equals(value)) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Pair<T> backup = this.first;
        Pair<T> candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.equals(value)) {
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
    public Pair<T> choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacío");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Pair<T> candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set<?> set = (Set<?>) o;
        return count == set.count && Objects.equals(first, set.first);
    }

    public boolean isSubset(Set<T> candidate) {
        boolean subset = true;

        ArrayList<Pair<T>> setBackup = new ArrayList<>();

        while (!candidate.isEmpty() && subset) {
            Pair<T> pairToCheck = candidate.choose();

            setBackup.add(pairToCheck);
            candidate.remove(pairToCheck);

            if (!this.contains(pairToCheck)) {
                subset = false;
            }
        }

        if (!setBackup.isEmpty()) {
            for (Pair<T> pair : setBackup) {
                candidate.add(pair);
            }
        }

        return subset;
    }

    public boolean contains(Pair<T> pair) {
        Pair<T> candidate = this.first;
        while (candidate != null) {
            if (candidate.equals(pair)) {
                return true;
            }
            candidate = candidate.getNext();
        }
        return false;
    }
}
