/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;
import java.util.Scanner;
import Game_Object.Player;

/**
 *
 * @author Amina A. Abounawara
 */
public class StartGame {
     private GameMap gameMap;
     private Player player;
     private LoadLevel loadLevel;
     private Display display;
        public StartGame() {
        init();
        startLoadLevel();
    }
    private void init() {
        Scanner input = new Scanner(System.in);
        int mazeHeight = 0, mazeWidth = 0;
       
        int choice;
        do {
           System.out.println("#Enter [1] For Base Level.\n#Enter [2] For Medium Level.\n#Enter [3] For Advanced Level.\n#Enter [4] For Make Your Own Maze.");
            while (!input.hasNextInt()) {
                System.out.print("That's not a number! Enter again: ");
                input.next();
            }
            choice = input.nextInt();
        } while (choice != 1 && choice != 2 && choice !=3 && choice != 4);
        if (choice == 1) {
         mazeHeight = mazeWidth = 10;
        }
        else if (choice == 2) {
         mazeHeight = mazeWidth = 15;
        }
        else if (choice == 3){
         mazeHeight = mazeWidth = 20;
        }
        else{
             do {
            System.out.print("Enter maze height (min 5): ");
            while (!input.hasNextInt()) {
                System.out.print("That's not a number! Enter again: ");
                input.next();
            }
            mazeHeight = input.nextInt();
        } while (mazeHeight < 5);
        do {
            System.out.print("Enter maze width (min 5): ");
            while (!input.hasNextInt()) {
                System.out.print("That's not a number! Enter again: ");
                input.next();
            }
            mazeWidth = input.nextInt();
        } while (mazeWidth < 5);
        }
        gameMap = new GameMap(mazeHeight, mazeWidth);
        player = new Player(gameMap.getRandomPosition());
        display = new Display(gameMap.getMap(),player);
        display.gameIntroMessage();
        
//        display = new Display(gameMap.getMap());
//        player = new Player(gameMap.getRandomPosition());
//        display = new Display(gameMap.getMap(), player);
//        display.gameIntroMessage();
    }
    
    private void startLoadLevel() {
        loadLevel = new LoadLevel(gameMap, player, display);
        display.createCoveredMap();
    }
}
