package Backend.Engine;

import Backend.Pieces.Car;
import FrontEnd.UIManager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class BoardManager {
    public static final int MOVE_RIGHT = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_UP = 2;
    public static final int MOVE_DOWN = 3;
    private static int boardColumns;
    private static int boardRows;
    private static Car[] carArray;
    private static boolean running = true;

    //BoardManager - Loads Board File from Input
    public BoardManager(String inputFileString) {
        BoardFile boardFile = new BoardFile(inputFileString);
        this.boardRows = boardFile.getM();
        this.boardColumns = boardFile.getN();
        this.carArray = boardFile.getCarArray();

        if (!isValid()) {
            UIManager.showMessage("The board file is corrupt!");
        }
    }

    //Converts array to 2D Array
    public static Car[][] to2DArray() {
        Car[][] board = new Car[boardRows][boardColumns];
        for (int i = 0; i < carArray.length; i++) {
            Car currentCar = carArray[i];
            for (int r = 0; r < currentCar.getHeight(); r++) {
                for (int c = 0; c < currentCar.getWidth(); c++) {
                    board[(boardRows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c] = currentCar;
                }
            }
        }
        return board;
    }

    //Checks validity of current board
    public static boolean isValid() {
        return isValid(carArray);
    }

    //Checks validity of given board
    public static boolean isValid(Car[] checkCarArray) {
        //Check for at least one block
        if (checkCarArray.length == 0) {
            UIManager.showMessage("Sorry, you need at least one red block!");
            return false;
        }

        //Check for Overlap
        try {
            boolean[][] checkOverlap = new boolean[boardRows][boardColumns];
            for (int i = 0; i < checkCarArray.length; i++) {
                Car currentCar = checkCarArray[i];
                for (int r = 0; r < currentCar.getHeight(); r++) {
                    for (int c = 0; c < currentCar.getWidth(); c++) {
                        if (checkOverlap[(boardRows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c]) {
                            running = false;
                            return false;
                        } else {
                            checkOverlap[(boardRows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c] = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            UIManager.showMessage("One of your pieces does not lie on the board!");
        }
        return true;
    }

    public static int getBoardColumns() {
        return boardColumns;
    }

    public static int getBoardRows() {
        return boardRows;
    }

    //Runs move on given c, r with direction moveDirection
    public static void runMove(int c, int r, int moveDirection) {
        Car[] newCarArray = carArray;

        for (int i = 0; i < newCarArray.length; i++) {
            if (newCarArray[i].getRow() == r && newCarArray[i].getColumn() == c) {
                if (moveDirection == MOVE_RIGHT) {
                    newCarArray[i].moveRight();
                }
                if (moveDirection == MOVE_LEFT) {
                    newCarArray[i].moveLeft();
                }
                if (moveDirection == MOVE_DOWN) {
                    newCarArray[i].moveDown();
                }
                if (moveDirection == MOVE_UP) {
                    newCarArray[i].moveUp();
                }
            }
        }

        if (isValid(newCarArray)) {
            carArray = newCarArray;
        } else {
            UIManager.showMessage("That move is invalid!");
        }
        checkWin();
    }

    //Checks if the red block is at the right hand side!
    public static void checkWin() {
        if (carArray[0].getColumn() + carArray[0].getWidth() == boardColumns) {
            UIManager.showMessage("You won!");
        }
    }

    public static boolean isRunning() {
        return running;
    }
}
