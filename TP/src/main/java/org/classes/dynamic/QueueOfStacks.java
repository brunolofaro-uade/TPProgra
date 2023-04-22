package org.classes.dynamic;
import java.util.Random;

public class QueueOfStacks extends Queue{
    int n;
    public QueueOfStacks(int n){
        this.n = n;
        Random random = new Random();

        for(int i=0;i<n;i++){
            Stack stack = new Stack<Node>();
            for(int j=0;j<n;j++){
                stack.add(new Node(random.nextInt(9),null));
            }
            this.add(stack);
        }
    }
}
