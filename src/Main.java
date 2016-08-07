import Backend.Engine.Manager;

/**
 * This file was created by Rhys Williams,
 * www.rhyswilliams.co.za
 * me@rhyswilliams.co.za
 */
public class Main {
    public static void main (String[] args) {
        new Backend.Engine.Manager("input.txt");
        System.out.println(Manager.isValid());
    }
}
