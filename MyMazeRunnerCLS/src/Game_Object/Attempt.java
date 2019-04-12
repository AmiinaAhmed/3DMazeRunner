package Game_Object;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * class Attempt increase the tries of player  
 * @author Amina A. Abounawara
 */
public class Attempt extends GameObject{
    //static final int VISIBILITY_BOOST = 2;
    private static final char DEFAULT_ICON = '%';
    /**
     * @param position the {@link Position} of this game object
     */
    public Attempt(Position position) {
        super(DEFAULT_ICON, position);
    }
}

