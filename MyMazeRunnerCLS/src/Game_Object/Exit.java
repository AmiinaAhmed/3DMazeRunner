/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Object;
import MainGame.GameMap;
/**
 *
 * @author Amina A. Abounawara
 */
/**
 * A class representing the 'exit' of the maze.
 *
 
 */
public class Exit  extends GameObject {
     private static final char DEFAULT_ICON = 'E';

   
    public Exit(Position position) {
        super(DEFAULT_ICON, position);
    }

}

