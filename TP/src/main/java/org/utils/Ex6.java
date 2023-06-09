package org.utils;
import org.classes.statics.Coordinate;
import org.classes.statics.Montecarlo;
import org.classes.statics.Coordinate;
public class Ex6 {
    public static void Excercise6(){
        Coordinate delimiter = new Coordinate(5.0, 5.0);
        Montecarlo montecarlo = new Montecarlo(delimiter);

        Coordinate c1 = new Coordinate(2.0, 3.0);
        Coordinate c5 = new Coordinate(2.0, 3.0);
        Coordinate c2 = new Coordinate(6.0, 4.0);
        Coordinate c3 = new Coordinate(1.0, 6.0);

        montecarlo.addCoordinate(c1);
        montecarlo.addCoordinate(c2);
        montecarlo.addCoordinate(c3);
        montecarlo.addCoordinate(c5);

        System.out.println("Stored Coordinates: " + montecarlo.getNumberOfCoordinates());
    }
}
