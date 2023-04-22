package org.example;
import org.classes.dynamic.*;

public class Main {
    public static void main(String[] args) throws Exception {
        QueueOfStacks queueOfStacks = new QueueOfStacks(3);
        //print queueOfStacks
        while(!queueOfStacks.isEmpty()) {
            Stack stack = (Stack) queueOfStacks.getFirst().getValue();
            while(!stack.isEmpty()){
                System.out.println((Integer) stack.getTop().getValue());
                stack.remove();
            }
            System.out.println("\n");
            queueOfStacks.remove();
        }
    }
}