package org.ejercicio1_2_6.utils;

import org.ejercicio1_2_6.classes.dynamic.PriorityQueue;
import org.ejercicio1_2_6.classes.dynamic.Set;
import org.ejercicio1_2_6.classes.dynamic.Stack;

import static org.ejercicio1_2_6.utils.Ex1.printStack;

public class Ex2 {
    public static void Excercise2() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.enqueue("Item 1", 2);
        queue.enqueue("Item 2", 1);
        queue.enqueue("Item 3", 3);

        System.out.println(queue.dequeue()); // Output: Item 3
        System.out.println(queue.dequeue()); // Output: Item 1
        System.out.println(queue.dequeue()); // Output: Item 2

        Set<String> stringSet = new Set<>();

        stringSet.add("Apple");
        stringSet.add("Banana");
        stringSet.add("Orange");

        System.out.println("Set contains Apple: " + stringSet.contains("Apple"));
        System.out.println("Set contains Mango: " + stringSet.contains("Mango"));

        stringSet.remove("Banana");

        System.out.println("Set is empty: " + stringSet.isEmpty());

        String chosenElement = stringSet.choose();
        System.out.println("Chosen element: " + chosenElement);

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        System.out.println("Original Stack:");
        printStack(stack);

        Stack<Integer> invertedStack = invertStack(stack);

        System.out.println("Inverted Stack:");
        printStack(invertedStack);

        Set<Integer> sourceSet = new Set<>();
        sourceSet.add(1);
        sourceSet.add(2);
        sourceSet.add(3);

        Set<Integer> targetSet = new Set<>();
        copySet(sourceSet, targetSet);

        System.out.println("Source Set:");
        printSet(sourceSet);

        System.out.println("Target Set:");
        printSet(targetSet);

    }
    public static <T> Stack<T> invertStack(Stack<T> stack) throws Exception {
        Stack<T> invertedStack = new Stack<>();

        while (!stack.isEmpty()) {
            invertedStack.add(stack.getTop().getValue());
            stack.remove();
        }

        return invertedStack;
    }

    public static <T> void copySet(Set<T> sourceSet, Set<T> targetSet) {
        Set<T> tempSet = new Set<>();

        while (!sourceSet.isEmpty()) {
            T element = sourceSet.choose();
            tempSet.add(element);
            targetSet.add(element);
            sourceSet.remove(element);
        }

        // Restoring the sourceSet
        while (!tempSet.isEmpty()) {
            T element = tempSet.choose();
            sourceSet.add(element);
            tempSet.remove(element);
        }
    }

    public static <T> void printSet(Set<T> set) {
        Set<T> tempSet = new Set<>();

        while (!set.isEmpty()) {
            T element = set.choose();
            tempSet.add(element);
            System.out.println(element);
            set.remove(element);
        }

        while (!tempSet.isEmpty()) {
            T element = tempSet.choose();
            set.add(element);
            tempSet.remove(element);
        }

        System.out.println();
    }
}
