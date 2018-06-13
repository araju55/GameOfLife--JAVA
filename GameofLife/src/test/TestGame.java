/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.geometry.Point2D;
import life.Game;

/**
 *
 * @author p0073862
 */
public class TestGame {

    private static Game game = new Game(70, 70);

    public static void main(String[] args) {

        //create a horizontal blinker
        game.makeCellLive(10, 10);
        game.makeCellLive(10, 11);
        game.makeCellLive(10, 12);
        //move through one generation
        game.newGeneration();
        Point2D[] newCells = game.getLiveCells();
        Point2D[] expected = {new Point2D(9,11),new Point2D(10,11),new Point2D(11,11)};
        //check that the horizontal blinker has turned into a vertical one
        assertEqual(newCells, expected);
    }

    private static void assertEqual(Point2D[] actual, Point2D[] expected) {
        if (actual.length != expected.length) {
            System.out.println("TEST FAILED!!!: WRONG NUMBER OF CELLS");
        } else {
            for (int i = 0; i < actual.length; i++) {
                System.out.println("Point " + i + "=" + actual[i]);
                if (!actual[i].equals(expected[i])) {
                    System.out.println("TEST FAILED!!!");
                }
            }
        }

    }
}
