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
public class Board {

    private int width;
    private int height;
    private boolean[][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new boolean[width][height];
    }

    public void clear() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = false;
            }
        }
    }

    public boolean getCell(int x, int y) {
        return cells[x][y];
    }

    public void makeCellLive(int x, int y) {
        cells[x][y] = true;
    }
    
    public Point2D[] getLiveCells(){
        //first count the live cells
        int nbrCells = 0;
        for (int x = 0;x<width;x++) {
            for (int y = 0;y<height;y++) {
                if (cells[x] [y])
                    nbrCells++;
            }
        }
        //now populate an array and return it
        Point2D[] liveCells = new Point2D[nbrCells];
        int i = 0;
        for (int x = 0;x<width;x++) {
            for (int y = 0;y<height;y++) {
                if (cells[x] [y]){
                    liveCells[i] = new Point2D(x,y);
                    i++;
                }
            }
        }
        return liveCells;
    }

}