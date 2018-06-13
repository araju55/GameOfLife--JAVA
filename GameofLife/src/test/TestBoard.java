/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.geometry.Point2D;
import life.Board;


public class TestBoard {

    private static Board board = new Board(70, 70);

    public static void main(String[] args) {
        board.makeCellLive(10, 15);
        board.makeCellLive(30, 30);

        testGetCell(10, 15, true);
        testGetCell(15, 10, false);
        testGetCell(30, 30, true);
        testGetCell(40, 40, false);

        Point2D[] expected = {new Point2D(10, 15), new Point2D(30, 30)};
        testGetLiveCells(expected);
    }

    private static void testGetCell(int col, int row, boolean expectedResult) {
        System.out.println("=======================");
        boolean actualResult = board.getCell(col, row);
        System.out.println("Value of cell (" + col + "," + row
                + ") = " + actualResult);
        if (actualResult != expectedResult) {
            System.out.println("TEST FAILED!!!!!!");
        }
        System.out.println("=======================");
    }

    private static void testGetLiveCells(Point2D[] expected) {
        System.out.println("=======================");
        Point2D[] actual = board.getLiveCells();
        System.out.println("Nbr of live cells = " + actual.length);
        if (actual.length != expected.length) {
            System.out.println("TEST FAILED!!!");
        } else {
            for (int i = 0; i < actual.length; i++) {
                System.out.println("Point i = " + actual[i]);
                if (!actual[i].equals(expected[i])) {
                    System.out.println("TEST FAILED!!!");
                }
            }
        }
        System.out.println("=======================");
    }
}
 