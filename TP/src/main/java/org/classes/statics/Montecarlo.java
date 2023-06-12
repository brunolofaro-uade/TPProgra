package org.classes.statics;
import java.util.ArrayList;
import java.util.List;

public class Montecarlo {
    private Coordinate delimiter;
    private List<Coordinate> coordinates;

    public Montecarlo(Coordinate delimiter) {
        this.delimiter = delimiter;
        this.coordinates = new ArrayList<>();
    }

    public void addCoordinate(Coordinate coordinate) {
        if (coordinate.getX() >= 0 && coordinate.getY() >= 0 && coordinate.getX() <= delimiter.getX()
                && coordinate.getY() <= delimiter.getY()) {
            coordinates.add(coordinate);
        }
    }

    public int getNumberOfCoordinates(){
        return this.coordinates.size();
    }
}
