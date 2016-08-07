package Backend.Pieces;

import java.awt.*;
import java.util.List;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Car {
    public static final int MOVES_UP = 1;
    public static final int MOVES_DOWN = 2;
    public static final int MOVES_LEFT = 3;
    public static final int MOVES_RIGHT = 4;
    private boolean redCar = false;
    private int width;
    private int height;
    private int column;
    private int row;
    private List<Integer> moveDirection;
    private Color carColour;

    public Car (int width, int height, int row, int column, List<Integer> moveDirection, boolean redCar) {
        this.width = width;
        this.height = height;
        this.column = column;
        this.row = row;
        this.moveDirection = moveDirection;
        this.redCar = redCar;

        if (redCar) {
            carColour = Color.RED;
        } else {
            carColour = Color.GREEN;
        }
    }

    public boolean movesRight () {
        return moveDirection.contains(Car.MOVES_RIGHT);
    }

    public boolean movesLeft () {
        return moveDirection.contains(Car.MOVES_LEFT);
    }

    public boolean movesUp () {
        return moveDirection.contains(Car.MOVES_UP);
    }

    public boolean movesDown () {
        return moveDirection.contains(Car.MOVES_DOWN);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
