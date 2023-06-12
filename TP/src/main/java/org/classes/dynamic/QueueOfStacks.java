package org.classes.dynamic;
import java.util.Random;

public class QueueOfStacks<T> extends Queue{
    private int n;
    public QueueOfStacks(int n){
        this.n = n;
        for(int i=0;i<n;i++){
            Stack<Integer> stack = new Stack<Integer>();
            this.add(stack);
        }
    }
    public int getN(){
        return this.n;
    }
    public void copy(QueueOfStacks<T> destination) throws Exception {
        QueueOfStacks<T> tempQueueOfStacks = new QueueOfStacks<>(destination.getN());

        // Copy elements from the original queueOfStacks to the destination queueOfStacks
        while (!this.isEmpty()) {
            Stack<T> originalStack = (Stack<T>) this.getFirst().getValue();
            Stack<T> copiedStack = new Stack<>();

            // Copy elements from the original stack to the copied stack
            Stack<T> tempStack = new Stack<>();
            while (!originalStack.isEmpty()) {
                T value = originalStack.getTop().getValue();
                copiedStack.add(value);
                tempStack.add(value);
                originalStack.remove();
            }

            // Restore the original stack
            while (!tempStack.isEmpty()) {
                originalStack.add(tempStack.getTop().getValue());
                tempStack.remove();
            }

            // Add the copied stack to the destination QueueOfStacks
            tempQueueOfStacks.add(copiedStack);
            destination.add(copiedStack);
            this.remove();
        }

        // Restore the original QueueOfStacks
        while (!tempQueueOfStacks.isEmpty()) {
            this.add(tempQueueOfStacks.getFirst().getValue());
            tempQueueOfStacks.remove();
        }
    }
}
