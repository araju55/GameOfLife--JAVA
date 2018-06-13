/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package life;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author p0073862
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {        
        Game game = new Game(70,70);
        readFromFile(game, "new.txt");
        Display display = new Display(game, 10,1);
        display.start();
    }
    
    public static void readFromFile(Game game, String file) throws FileNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);
        Scanner scan = new Scanner(fileIn);
        while(scan.hasNextInt()) {
            if (scan.hasNextInt()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            game.makeCellLive(x, y); 
            } else {
               String type = scan.next();
               if (type.equals("Glider")) {
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    game.makeCellLive(x, y);
                    game.makeCellLive(x + 1, y);
                    game.makeCellLive(x + 2, y);
                    game.makeCellLive(x, y + 1);
                    game.makeCellLive(x + 1, y + 2);
               }

               if (type.equals("LWSpaceShip")) {
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    game.makeCellLive(x + 1, y);
                    game.makeCellLive(x + 4, y);
                    game.makeCellLive(x, y + 1);
                    game.makeCellLive(x, y + 2);
                    game.makeCellLive(x + 4, y + 2);
                    game.makeCellLive(x, y + 3);
                    game.makeCellLive(x + 1, y + 3);
                    game.makeCellLive(x + 2, y + 3);
                    game.makeCellLive(x + 3, y + 3);
                }
            }    
        }
    }
}