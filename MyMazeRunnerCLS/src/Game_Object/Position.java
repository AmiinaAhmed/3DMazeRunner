/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Object;

/**
 *
 * @author Amina A. Abounawara
 */
/**
 * An immutable class encapsulating the x-coordinate and y-coordinate of a {@link GameObject} in the game map.
 *
 *
 */
public final class Position {

    private final int x;
    private final int y;

    /**
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate
     *
     * @return the x-coordinate
     */
    int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate
     *
     * @return the y-coordinate
     */
    int getY() {
        return y;
    }

    /**
     * Compares this Position to the specified object.
     * The result is true if and only if the argument is not null and is a Position object
     * that represents the same x and y coordinate as this object.
     *
     * @param obj the object to compare this Position against
     * @return true if the given object represents a Position equivalent to this Position object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Position)) {
            return false;
        } else {
            Position position = (Position) obj;
            return this.x == position.x && this.y == position.y;
        }
    }

    /**
     * Returns a String object representing this Position's coordinates.
     * The x and y coordinates are separated by a comma and returned as a string.
     *
     * @return a String representation of this Position's coordinates
     */
    @Override
    public String toString() {
        return x + ", " + y;
    }
}
