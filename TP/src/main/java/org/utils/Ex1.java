package org.utils;

import org.classes.dynamic.Node;
import org.classes.dynamic.Queue;
import org.classes.dynamic.QueueOfStacks;
import org.classes.dynamic.Stack;

import java.util.Random;

public class Ex1 {
    public static void Excercise1() throws Exception {
        int dimentions = 3;
        QueueOfStacks<Integer> queueOfStacks1 = new QueueOfStacks(dimentions);
        QueueOfStacks<Integer> queueOfStacks2 = new QueueOfStacks(dimentions);
        QueueOfStacks<Integer> result = new QueueOfStacks(dimentions);
        PopulateStacks(queueOfStacks1,dimentions);
        PopulateStacks(queueOfStacks2,dimentions);
        QueueOfStacks<Integer> copy = new QueueOfStacks<>(0);
        queueOfStacks1.copy(copy);
        System.out.println("queueOfStacks1");
        printQueueOfStacks(queueOfStacks1);
        System.out.println("queueOfStacks2");
        printQueueOfStacks(queueOfStacks2);
        System.out.println("sum");
        printQueueOfStacks(matrixSum(queueOfStacks1,queueOfStacks2));
        //System.out.println("the trace is :" + trace(copy,dimentions));
    }

    public static <T> void PopulateStacks(QueueOfStacks<T> queueOfStacks, int n) throws Exception {
        QueueOfStacks<T> tmpQueueOfStacks = new QueueOfStacks<T>(0);
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
    public static int trace(QueueOfStacks queueOfStacks, int dimensions) throws Exception {
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

    public static int getElementInNPosition(Stack stack, int n) throws Exception {
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
    public static void printStack(Stack stack) throws Exception {
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
    public static void printQueueOfStacks(QueueOfStacks queueOfStacks) throws Exception {
        Queue temp = new Queue();
        while(!queueOfStacks.isEmpty()) {
            Stack stack = (Stack) queueOfStacks.getFirst().getValue();
            printStack(stack);
            System.out.println();
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
    public static QueueOfStacks<Integer> matrixSum(QueueOfStacks<Integer> matrix1, QueueOfStacks<Integer> matrix2) throws Exception {
        QueueOfStacks sumQueueOfStacks = new QueueOfStacks(0);
        Node<Stack<Integer>> node1 = matrix1.getFirst();
        Node<Stack<Integer>> node2 = matrix2.getFirst();
        //recorro las queues
        do{
            Stack sumStack = new Stack();
            Stack<Integer> tmpStack1 = new Stack<Integer>();
            Stack<Integer> tmpStack2 = new Stack<Integer>();
            Stack stack1 = new Stack();
            //recorro los stacks
            do{
                node1 = matrix1.getFirst();//get the next stack in the queue
                node2 = matrix2.getFirst();
                stack1 = node1.getValue();
                Stack stack2 = node2.getValue();
                tmpStack1.add((Integer)stack1.getTop().getValue());//get the integer inside the stack Node
                tmpStack2.add((Integer)stack2.getTop().getValue());//get the integer inside the stack Node
                stack1.remove();
                stack2.remove();
            }while(!stack1.isEmpty());
            do{//fix the order of the elements in the stack
                int num1 = tmpStack1.getTop().getValue();
                int num2 = tmpStack2.getTop().getValue();
                tmpStack1.remove();
                tmpStack2.remove();
                sumStack.add( num1 + num2 );
            }while(!tmpStack1.isEmpty());
            sumQueueOfStacks.add(sumStack);
            matrix1.remove();
            matrix2.remove();
        }while(!matrix1.isEmpty());
        return sumQueueOfStacks;
    }
}
