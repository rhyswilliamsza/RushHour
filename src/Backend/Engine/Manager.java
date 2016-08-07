package Backend.Engine;

import Backend.Pieces.Car;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Manager {
    private static int boardColumns;
    private static int boardRows;
    private static Car[] carArray;

    public Manager(String inputFileString) {
        InputFile inputFile = new InputFile(inputFileString);
        this.boardRows = inputFile.getM();
        this.boardColumns = inputFile.getN();
        this.carArray = inputFile.getCarArray();
    }

    public static Car[][] to2DArray () {
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

    public static boolean isValid() {

        //Check for at least one block
        if (carArray.length == 0) {
            return false;
        }

        //Check for Overlap
        boolean[][] checkOverlap = new boolean[boardRows][boardColumns];
        for (int i = 0; i < carArray.length; i++) {
            Car currentCar = carArray[i];
            for (int r = 0; r < currentCar.getHeight(); r++) {
                for (int c = 0; c < currentCar.getWidth(); c++) {
                    if (checkOverlap[(boardRows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c]) {
                        return false;
                    } else {
                        checkOverlap[(boardRows - 1) - currentCar.getRow() - r][currentCar.getColumn() + c] = true;
                    }
                }
            }
        }

        for (int i = 0; i < checkOverlap.length; i++) {
            for (int j = 0; j < checkOverlap[i].length; j++) {
                System.out.print(checkOverlap[i][j] + " ");
            }
            System.out.println();
        }
        return true;
    }

    public static int getBoardColumns() {
        return boardColumns;
    }

    public static int getBoardRows() {
        return boardRows;
    }
}
