package Backend.Objects;

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

    public Car copy() {
        Car newCar = new Car(width, height, row, column, moveDirection, redCar);
        newCar.setCarColour(carColour);
        return newCar;
    }

    public void setCarColour(Color carColour) {
        this.carColour = carColour;
    }

    public Car(int width, int height, int row, int column, List<Integer> moveDirection, boolean redCar) {
        this.width = width;
        this.height = height;
        this.column = column;
        this.row = row;
        this.moveDirection = moveDirection;
        this.redCar = redCar;

        if (redCar) {
            carColour = new Color(236, 56, 44);
        } else {
            //Pick Random Colour
            int red = (int) (Math.random() * 200) + 55;
            int green = (int) (Math.random() * 200 + 55);
            int blue = (int) (Math.random() * 200) + 55;

            carColour = new Color(red, green, blue);
        }
    }

    public String toString() {
        if (redCar) {
            return "R";
        } else {
            return "P";
        }
    }

    public boolean movesRight() {
        return moveDirection.contains(Car.MOVES_RIGHT);
    }

    public boolean movesLeft() {
        return moveDirection.contains(Car.MOVES_LEFT);
    }

    public boolean movesUp() {
        return moveDirection.contains(Car.MOVES_UP);
    }

    public boolean movesDown() {
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

    public int getRow() {
        return row;
    }

    public Color getCarColour() {
        return carColour;
    }

    public void moveRight() {
        if (movesRight()) {
            this.column++;
        } else {
            //UIManager.showMessage("You requested an invalid move!");
        }
    }

    public void moveLeft() {
        if (movesLeft()) {
            this.column--;
        } else {
            //UIManager.showMessage("You requested an invalid move!");
        }
    }

    public void moveUp() {
        if (movesUp()) {
            this.row++;
        } else {
            //UIManager.showMessage("You requested an invalid move!");
        }
    }

    public void moveDown() {
        if (movesDown()) {
            this.row--;
        } else {
            //UIManager.showMessage("You requested an invalid move!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (redCar != car.redCar) return false;
        if (width != car.width) return false;
        if (height != car.height) return false;
        if (column != car.column) return false;
        if (row != car.row) return false;
        if (!moveDirection.equals(car.moveDirection)) return false;
        return carColour.equals(car.carColour);

    }

    @Override
    public int hashCode() {
        int result = (redCar ? 1 : 0);
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + column;
        result = 31 * result + row;
        result = 31 * result + moveDirection.hashCode();
        result = 31 * result + carColour.hashCode();
        return result;
    }
}
