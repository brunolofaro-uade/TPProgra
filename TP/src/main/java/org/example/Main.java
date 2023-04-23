package org.example;
import org.classes.dynamic.*;

public class Main {
    public static void main(String[] args) throws Exception {
        QueueOfStacks queueOfStacks = new QueueOfStacks(3);
        trace(queueOfStacks,3);
        //print queueOfStacks
        /*
        while(!queueOfStacks.isEmpty()) {
            Stack stack = (Stack) queueOfStacks.getFirst().getValue();
            while(!stack.isEmpty()){
                System.out.println((Integer) stack.getTop().getValue());
                stack.remove();
            }
            System.out.println("\n");
            queueOfStacks.remove();
        }*/
    }

    static int trace(QueueOfStacks queueOfStacks, int dimensions) throws Exception {
        int acum = 0;
        Queue tempQueueOfStacks = new Queue();
        for (int i = 0; i < dimensions; i++) {
            Stack stack = (Stack) queueOfStacks.getFirst().getValue();
            tempQueueOfStacks = new Queue(); //store the stacks in a temp queue to restore them.
            tempQueueOfStacks.add(stack);
            //acum+=getElementInNPosition(queueOfStacks, i);
            queueOfStacks.remove();
            while(!tempQueueOfStacks.isEmpty()){
            queueOfStacks.add(tempQueueOfStacks.getFirst());//restore the stacks
                tempQueueOfStacks.remove();
            }
        }
        return acum;
    }
}