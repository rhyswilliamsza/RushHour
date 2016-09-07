package Backend.Objects;

import Backend.Engine.BoardManager;
import FrontEnd.UIManager;

import java.util.Arrays;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Board {
    private int columns;
    private int rows;
    private Car[] carArray;

    public Board copy() {
        Board boardCopy = new Board();
        boardCopy.setColumns(columns);
        boardCopy.setRows(rows);
        Car[] newCarArray = new Car[carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            newCarArray[i] = carArray[i].copy();
        }
        boardCopy.setCarArray(newCarArray);

        return boardCopy;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Car[] getCarArray() {
        return carArray;
    }

    public void setCarArray(Car[] carArray) {
        this.carArray = carArray;
    }

    //Converts array to 2D Array
    public Car[][] to2DArray() {
        Car[][] board = new Car[rows][columns];
        for (int i = 0; i < carArray.length; i++) {
            Car currentCar = carArray[i];
            for (int r = 0; r < currentCar.getHeight(); r++) {
                for (int c = 0; c < currentCar.getWidth(); c++) {
                    board[(rows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c] = currentCar;
                }
            }
        }
        return board;
    }

    public boolean isValid() {
        return isValid(carArray);
    }

    /**
     * Check if the provided board is valid
     *
     * @return
     */
    public boolean isValid(Car[] testArray) {
        //Check for at least one block
        if (testArray.length == 0) {
            UIManager.showMessage("Sorry, you need at least one red block!");
            return false;
        }

        //Check for Overlap
        try {
            boolean[][] checkOverlap = new boolean[rows][columns];
            for (int i = 0; i < testArray.length; i++) {
                Car currentCar = testArray[i];
                for (int r = 0; r < currentCar.getHeight(); r++) {
                    for (int c = 0; c < currentCar.getWidth(); c++) {
                        if (checkOverlap[(rows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c]) {
                            return false;
                        } else {
                            checkOverlap[(rows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c] = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return false;
            //UIManager.showMessage("One of your pieces does not lie on the board!");
        }
        return true;
    }

    /**
     * Does a move using c,r, moveDirection.
     * First tries move, and if invalid, notifies of the error.
     *
     * @param c
     * @param r
     * @param moveDirection
     */
    public void runMove(int c, int r, int moveDirection) {
        Car[] newCarArray = carArray;

        for (int i = 0; i < newCarArray.length; i++) {
            if (newCarArray[i].getRow() == r && newCarArray[i].getColumn() == c) {
                if (moveDirection == BoardManager.MOVE_RIGHT) {
                    newCarArray[i].moveRight();
                }
                if (moveDirection == BoardManager.MOVE_LEFT) {
                    newCarArray[i].moveLeft();
                }
                if (moveDirection == BoardManager.MOVE_DOWN) {
                    newCarArray[i].moveDown();
                }
                if (moveDirection == BoardManager.MOVE_UP) {
                    newCarArray[i].moveUp();
                }
            }
        }

        if (isValid(newCarArray)) {
            carArray = newCarArray;
        } else {
            //UIManager.showMessage("That move is invalid!");
        }
        BoardManager.checkWin();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (columns != board.columns) return false;
        if (rows != board.rows) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(carArray, board.carArray);

    }

    @Override
    public int hashCode() {
        int result = columns;
        result = 31 * result + rows;
        result = 31 * result + Arrays.hashCode(carArray);
        return result;
    }

    /**
     * Checks if the player has won
     */
    public boolean checkWin() {
        if (carArray[0].getColumn() + carArray[0].getWidth() == columns) {
            return true;
        }
        return false;
    }
}
