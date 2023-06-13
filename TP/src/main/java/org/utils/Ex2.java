package org.utils;

import org.classes.dynamic.PriorityQueue;

public class Ex2 {
    public static void Excercise2() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.enqueue("Item 1", 2);
        queue.enqueue("Item 2", 1);
        queue.enqueue("Item 3", 3);

        System.out.println(queue.dequeue()); // Output: Item 3
        System.out.println(queue.dequeue()); // Output: Item 1
        System.out.println(queue.dequeue()); // Output: Item 2
    }
}
