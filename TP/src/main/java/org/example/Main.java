package org.example;
import org.classes.dynamic.*;

public class Main {
    public static void main(String[] args) throws Exception {
        QueueOfStacks queueOfStacks = new QueueOfStacks(3);
        //print queueOfStacks
        while(!queueOfStacks.isEmpty()) {
            Node queueNode = (Node) queueOfStacks.getFirst().getValue();
            Stack stack = (Stack) queueNode.getValue();
            while(!stack.isEmpty()){
                Node stackNode = (Node) stack.getTop().getValue();
                int node1Val = (Integer) stackNode.getValue();
                System.out.println(node1Val);
                stack.remove();
            }
            System.out.println("\n");
            queueOfStacks.remove();
        }
    }
}