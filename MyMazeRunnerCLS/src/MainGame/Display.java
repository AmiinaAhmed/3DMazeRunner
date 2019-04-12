/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Game_Object.Player;
import static Maze_Generator.MazeGenerator.EMPTY_SPACE;
import java.lang.reflect.Array;

/**
 *  A class encapsulating the methods required for printing stuffs on the console.
 * @author Amina A. Abounawara
 */
public class Display {
    private final char[][] map;
    private final Player player;
    private final int height;
    private final int width;
    
     Display(char[][] map, Player player) {
        this.map = map;
        this.height = map.length;
        this.width = map[0].length;
        this.player = player;
    }
    void createCoveredMap() {
       
       for(int i=0;i<height;i++){
           for(int j=0;j<width;j++){
               System.out.printf("%s",map[i][j]);
           }
           System.out.println();
       }
        
    }
    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
     void gameIntroMessage() {
       // clearScreen();
        String[] intros = {"Are You Ready To Gaming Now!!! .\n\n",
                "Enjoy Gaming My Friend ...\n",              
                "Press ENTER to continue... "};
        for (String intro : intros) {
            printWithDelay(intro, 40);
            delay(500);
        }
        // wait for player to press enter
        Scanner s = new Scanner(System.in);
        String input;
        do {
            input = s.nextLine();
        } while (!input.equals(""));
    }
    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void printWithDelay(String message, int millis) {
        if (message.length() > 0) {
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                delay(millis);
            }
        }
    }
}
