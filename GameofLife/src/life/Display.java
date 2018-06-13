/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author p0073862
 */
public class Display extends Stage {

    private final LifeCanvas canvas;
    private final int cellSize;
    private final int genTime;
    private final Game game;
    private final Timer timer;

    public Display(Game game, int cellSize, int genTime) {
        this.cellSize = cellSize;
        this.genTime = genTime;
        this.game = game;
        canvas = new LifeCanvas(cellSize * game.getWidth(), cellSize * game.getHeight());

        timer = new Timer();

        setScene(new Scene(new Pane(canvas)));
        setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        setTitle("Game of Life");
        show();
    }

    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        game.newGeneration();
                        canvas.draw();
                    }
                });
            }
        }, 0, genTime);
    }

    private class LifeCanvas extends Canvas {

        LifeCanvas(double width, double height) {
            super(width, height);
        }

        protected void draw() {
            GraphicsContext g = getGraphicsContext2D();
            int width = game.getWidth();
            int height = game.getHeight();
            g.clearRect(0, 0, cellSize * width, cellSize * height);

            g.setFill(Color.BLACK);
            Point2D[] liveCells = game.getLiveCells();
            for (Point2D liveCell : liveCells) {
                double x = liveCell.getX();
                double y = liveCell.getY();
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
    }
}
