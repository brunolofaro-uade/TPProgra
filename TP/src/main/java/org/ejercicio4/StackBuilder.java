package org.ejercicio4;

public class StackBuilder {
    private Stack stack;

    public StackBuilder() {
        this.reset();
    }

    public void reset() {
        this.stack = new Stack();
    }

    public void add(int number) {
        this.stack.add(number);
    }

    public Stack getResult() {
        Stack builtStack = this.stack;
        this.reset();
        return builtStack;
    }
}
