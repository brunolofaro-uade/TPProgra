package org.ejercicio4;

import java.util.ArrayList;

public class SetBuilder {
    private Set set;

    public SetBuilder() {
        this.reset();
    }

    public void reset() {
        this.set = new Set();
    }

    public void add(int number) {
        this.set.add(number);
    }

    public void addAll(Set setToAdd) {
        ArrayList<Integer> setBackup = new ArrayList<Integer>();

        while (!setToAdd.isEmpty()) {
            int valueToAdd = setToAdd.choose();
            this.set.add(valueToAdd);
            setBackup.add(valueToAdd);
            setToAdd.remove(valueToAdd);
        }

        for (Integer number : setBackup) {
            setToAdd.add(number);
        }
    }

    public Set getResult() {
        Set builtSet = this.set;
        this.reset();
        return builtSet;
    }
}

