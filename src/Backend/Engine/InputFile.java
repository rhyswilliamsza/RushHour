package Backend.Engine;

import Backend.Pieces.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class InputFile {
    private int m;
    private int n;
    boolean redCar = true;
    private List<Car> carList = new ArrayList<>();

    public int getM() {
        return m;
    }
    public int getN() {
        return n;
    }
    public Car[] getCarArray () {
        return carList.toArray(new Car[carList.size()]);
    }

    public InputFile(String fileName) {
        try {
            Scanner fileScan = new Scanner(new File(fileName));

            if (fileScan.hasNext()) {
                //Dimension
                Scanner dimensionScan = new Scanner(fileScan.nextLine()).useDelimiter(" ");
                m = dimensionScan.nextInt();
                n = dimensionScan.nextInt();
                dimensionScan.close();
            }

            while (fileScan.hasNextLine()) {
                //Car Start Position
                Scanner carStartPos = new Scanner(fileScan.nextLine()).useDelimiter(" ");
                int c = carStartPos.nextInt();
                int r = carStartPos.nextInt();
                carStartPos.close();

                //Car Dimensions
                Scanner carDimensions = new Scanner(fileScan.nextLine()).useDelimiter(" ");
                int width = carDimensions.nextInt();
                int height = carDimensions.nextInt();
                carDimensions.close();

                //Car Directions
                String carDirectionString = fileScan.nextLine();
                List<Integer> carDirections = new ArrayList<>();
                if (carDirectionString.contains("right")) {
                    carDirections.add(Car.MOVES_RIGHT);
                }
                if (carDirectionString.contains("left")) {
                    carDirections.add(Car.MOVES_LEFT);
                }
                if (carDirectionString.contains("up")) {
                    carDirections.add(Car.MOVES_UP);
                }
                if (carDirectionString.contains("down")) {
                    carDirections.add(Car.MOVES_DOWN);
                }

                //Generate Red Block
                carList.add(new Car(width, height, r, c ,carDirections, redCar));
                redCar = false;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
