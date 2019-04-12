/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Game_Object.Player;
import Game_Object.Gift;
import Game_Object.Attempt;
import Game_Object.Monster;
import Game_Object.Exit;
/**
 * A class encapsulating the game logic of level one.
 * <p>
 * Level details:
 * <ul>
 * <li>Mission: collect all keys to reach level two</li>
 * <li>Bonus: collect torch to increase visibility</li>
 * <li>Each valid movement costs one drop of blood.
 * Game over when the health level of the player is equals to zero.</li>
 * </ul>
 *
 * @author Amina A. Abounawara
 */
public class LoadLevel {
    static final int NUMBER_OF_GIFTS = 3;
    static final int NUMBER_OF_MONSTERS = 4;
    static final int NUMBER_OF_ATTEMPTS = 1;
    private final GameMap gameMap;
    private final Player player;
    private final Display display;
    private ArrayList<Attempt> attempts;
    private ArrayList<Gift> gifts;
    private Exit exit;
    private ArrayList<Monster> monsters;

    /**
     * @param gameMap the {@link GameMap} object
     * @param player  the {@link Player} object
     * @param display the {@link Display} object
     */
    LoadLevel(GameMap gameMap, Player player, Display display) {
        this.gameMap = gameMap;
        this.player = player;
        this.display = display;
        init();
    }


    /**
     * Initializes level one by adding game objects to the game map.
     */
    private void init() {
        // init game objects
        gameMap.addToMap(player);

       gifts = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_GIFTS; i++) {
           Gift gift = new Gift(gameMap.getRandomPosition());
            gifts.add(gift);
            gameMap.addToMap(gift);
       }
        attempts = new ArrayList<>();
         for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
           Attempt attempt = new Attempt(gameMap.getRandomPosition());
            attempts.add(attempt);
            gameMap.addToMap(attempt);
       }
//      attempt = new Attempt(gameMap.getRandomPosition());
//      gameMap.addToMap(attempt);
      
        monsters = new ArrayList<>();
        for (int j = 0; j < NUMBER_OF_MONSTERS; j++) {
          Monster monster = new Monster(gameMap.getRandomPosition());
            monsters.add(monster);
           gameMap.addToMap(monster);
       }
   exit = new Exit(gameMap.getRandomPosition());
     gameMap.addToMap(exit);

    }

}
