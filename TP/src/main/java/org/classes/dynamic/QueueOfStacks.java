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
}
