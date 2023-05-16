package org.example;
import org.classes.dynamic.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        QueueOfStacks<Integer> queueOfStacks = new QueueOfStacks(2);
        PopulateStacks(queueOfStacks,3);
        printQueueOfStacks(queueOfStacks);
        //System.out.println(trace(queueOfStacks,3));
        //printQueueOfStacks(queueOfStacks);
    }

    public static <T> void PopulateStacks(QueueOfStacks<T> queueOfStacks, int n) throws Exception {
        QueueOfStacks<T> tmpQueueOfStacks = new QueueOfStacks<T>(queueOfStacks.getN());
        while(!queueOfStacks.isEmpty()){
            Stack<Integer> stack = (Stack) queueOfStacks.getFirst().getValue();
            for(int i = 0; i<n; i++){
                Random random = new Random();
                stack.add(random.nextInt(9));
            }
            tmpQueueOfStacks.add(stack);
            queueOfStacks.remove();
        }
        while(!tmpQueueOfStacks.isEmpty()){
            Stack<T> stack = (Stack) tmpQueueOfStacks.getFirst().getValue();
            queueOfStacks.add(stack);
            tmpQueueOfStacks.remove();
        }
    }

    //TODO: Make non destructive.
    static int trace(QueueOfStacks queueOfStacks, int dimensions) throws Exception {
        int acum = 0;
        Queue tempQueueOfStacks = new Queue();
        for (int i = 0; i < dimensions; i++) {
            Stack stack = (Stack) queueOfStacks.getFirst().getValue();
            tempQueueOfStacks = new Queue(); //store the stacks in a temp queue to restore them.
            tempQueueOfStacks.add(stack);
            acum+=getElementInNPosition(stack, i);
            queueOfStacks.remove();
            while(!tempQueueOfStacks.isEmpty()){
            queueOfStacks.add(tempQueueOfStacks.getFirst());//restore the stacks
                tempQueueOfStacks.remove();
            }
        }
        return acum;
    }

    static int getElementInNPosition(Stack stack, int n) throws Exception {
        Stack tempStack = new Stack();
        for(int i=0;i<n;i++){
            tempStack.add(stack.getTop().getValue());
            stack.remove();
        }
        int value = (int) stack.getTop().getValue();
        for(int i=0;i<n;i++){
            stack.add(tempStack.getTop().getValue());
            tempStack.remove();
        }
        return value;
    }
    static void printStack(Stack stack) throws Exception {
        Stack temp = new Stack();
        while(!stack.isEmpty())
        {
            int value = (int)stack.getTop().getValue();
            System.out.println(value);
            temp.add(value);
            stack.remove();
        }
        while(!temp.isEmpty())
        {
            int value = (int) temp.getTop().getValue();
            stack.add(value);
            temp.remove();
        }
    }
    static void printQueueOfStacks(QueueOfStacks queueOfStacks) throws Exception {
        Queue temp = new Queue();
        while(!queueOfStacks.isEmpty()) {
            Stack stack = (Stack) queueOfStacks.getFirst().getValue();
            printStack(stack);
            System.out.println("\n");
            temp.add(stack);
            queueOfStacks.remove();
        }
        while(!temp.isEmpty())
        {
            Stack stack = (Stack) temp.getFirst().getValue();
            queueOfStacks.add(stack);
            temp.remove();
        }
    }
}