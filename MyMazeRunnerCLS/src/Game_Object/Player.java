/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Object;

/**
 *  A class representing the 'player' of this game.
 * @author Amina A. Abounawara
 */
public class Player extends GameObject  {

    public static final int NO_TRIES = 3 ;
    private static final char DEFAULT_ICON = 'P';
    private static final int INITIAL_VISIBILITY = 2;
    private int visibility;
    private int healthLevel;
   // private boolean hasTorch;

    /**
     * @param position the {@link Position} of this game object
     */
    public Player(Position position) {
        super(DEFAULT_ICON, position);
        this.visibility = INITIAL_VISIBILITY;
        this.healthLevel = NO_TRIES;
       // this.hasTorch = false;
    }

    /**
     * Returns the {@link #visibility} of this Player object.
     * Visibility is the number of blocks that is not covered up and is visible to the player.
     *
     * @return the {@link #visibility} of this Player object
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * Returns the {@link #healthLevel} of this Player object.
     *
     * @return the {@link #healthLevel} of this Player object
     */
    public int getHealthLevel() {
        return healthLevel;
    }

    /**
     * Reduces the {@link #healthLevel} of this Player object.
     *
     * @param value the value to be reduced
     */
    public void reduceHealthLevelBy(int value) {
        healthLevel -= value;
    }
 
}
