package org.ejercicio1_2_5.utils;
import org.ejercicio1_2_5.classes.dynamic.Stack;
import org.ejercicio1_2_5.classes.statics.Coordinate;
import org.ejercicio1_2_5.classes.statics.Montecarlo;

import java.util.Random;

public class Ex5 {
    public static void Excercise5() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(2);
        stack.add(1);
        stack.add(5);
        stack.add(3);
        stack.add(2);

        Stack<Integer> orderedStack = orderAndRemoveDuplicates(stack);
        while (!orderedStack.isEmpty()) {
            System.out.println(orderedStack.getTop().getValue());
            orderedStack.remove();
        }

        Coordinate delimiter = new Coordinate(7.0, 7.0);
        Montecarlo montecarlo = new Montecarlo(delimiter);

        Random random = new Random();

        int totalDots = 1000;
        int dotsInside = 0;

        for (int i = 0; i < totalDots; i++) {
            double x = random.nextDouble() * delimiter.getX();
            double y = random.nextDouble() * delimiter.getY();
            Coordinate coordinate = new Coordinate(x, y);
            montecarlo.addCoordinate(coordinate);

            if (coordinate.getX() * coordinate.getX() + coordinate.getY() * coordinate.getY() <=
                    delimiter.getX() * delimiter.getX()) {
                dotsInside++;
            }
        }

        double piApproximation = (dotsInside / (double) totalDots) * 4;
        System.out.println("Approximation of Pi: " + piApproximation);
    }
    public static Stack<Integer> orderAndRemoveDuplicates(Stack<Integer> stack) throws Exception {
        Stack<Integer> orderedStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            Integer element = stack.getTop().getValue();
            stack.remove();

            if (!tempStackContains(tempStack, element)) {
                insertInOrder(orderedStack, element);
                tempStack.add(element);
            }
        }

        return orderedStack;
    }

    private static boolean tempStackContains(Stack<Integer> stack, int value) throws Exception {
        Stack<Integer> tempStack = copyStack(stack);

        while (!tempStack.isEmpty()) {
            if (tempStack.getTop().getValue() == value) {
                return true;
            }
            tempStack.remove();
        }
        return false;
    }

    private static Stack<Integer> copyStack(Stack<Integer> stack) throws Exception {
        Stack<Integer> copiedStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        // Copy elements from original stack to copied stack
        while (!stack.isEmpty()) {
            int element = stack.getTop().getValue();
            tempStack.add(element);
            copiedStack.add(element);
            stack.remove();
        }

        // Restore original stack
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.getTop().getValue());
            tempStack.remove();
        }

        return copiedStack;
    }

    private static void insertInOrder(Stack<Integer> stack, int value) throws Exception {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty() && stack.getTop().getValue() < value) {
            tempStack.add(stack.getTop().getValue());
            stack.remove();
        }

        stack.add(value);

        while (!tempStack.isEmpty()) {
            stack.add(tempStack.getTop().getValue());
            tempStack.remove();
        }
    }
}
