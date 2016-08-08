package Backend.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Rhys Williams
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class SolutionManager {

    public static void runSolutionsFile (String filePath) {
        File solutionFile = new File(filePath);
        try {
            Scanner solutionScan = new Scanner (solutionFile);

            while (solutionScan.hasNext()) {

            }

            solutionScan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




}
