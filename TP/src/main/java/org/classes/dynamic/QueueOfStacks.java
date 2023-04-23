package org.classes.dynamic;
import java.util.Random;

public class QueueOfStacks extends Queue{
    int n;
    public QueueOfStacks(int n){
        this.n = n;
        Random random = new Random();

        for(int i=0;i<n;i++){
            Stack stack = new Stack();
            for(int j=0;j<n;j++){
                //stack.add(random.nextInt(9));
                stack.add(j+i);
            }
            this.add(stack);
        }
    }
}
