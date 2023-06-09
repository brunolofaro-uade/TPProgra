package org.utils;
import org.classes.statics.Coordinate;
import org.classes.statics.Montecarlo;
import org.classes.statics.Coordinate;

import java.util.Random;

public class Ex6 {
    public static void Excercise6(){
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
}
