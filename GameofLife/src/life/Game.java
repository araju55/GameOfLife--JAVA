/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

import javafx.geometry.Point2D;

/**
 *
 * @author p0073862
 */
public class Game {

    private int width;
    private int height;
    private Board currentBoard;
    private Board oldBoard;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        currentBoard = new Board(width, height);
        oldBoard = new Board(width, height);
    }

    public void newGeneration() {
        Board temp = oldBoard;
        oldBoard = currentBoard;
        currentBoard = temp;
        currentBoard.clear();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int nl = getNbrLivingNeighbours(x, y);
                if (oldBoard.getCell(x, y) && (nl == 2 || nl == 3)) {
                    currentBoard.makeCellLive(x, y);
                }
                if (!oldBoard.getCell(x, y) && nl == 3) {
                    currentBoard.makeCellLive(x, y);
                }
            }
        }
    }

    private int getNbrLivingNeighbours(int x, int y) {
        int total = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {

                if (dx != 0 || dy != 0) {

                    if (x + dx >= 0 && y + dy >= 0 && x + dx < width && y + dy < height
                            && oldBoard.getCell(x + dx, y + dy)) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    public Point2D[] getLiveCells() {
        return currentBoard.getLiveCells();
    }

    public void makeCellLive(int x, int y) {
        currentBoard.makeCellLive(x, y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}