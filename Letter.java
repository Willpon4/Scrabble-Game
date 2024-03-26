package hws.hw4;

/**
 * HW4 creating scrabble.
 *
 * @author Will Ponczak
 * @version 02/18/2024
 */

public class Letter {

    private char letter;
    private int points;

    /**
     * Initialize the letter and points.
     *
     * @param letter letter.
     * @param points points
     */

    public Letter(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    /**
     * Update the letter.
     *
     * @param letter letter.
     */

    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Update the points.
     *
     * @param points points.
     */

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Return the letter.
     *
     * @return char.
     */

    public char getLetter() {
        return this.letter;
    }

    /**
     * Return points.
     *
     * @return points.
     */

    public int getPoints() {
        return this.points;

    }

    /**
     * If other == instance vars.
     *
     * @param other object.
     * @return bool.
     */

    public boolean equals(Object other) {
        if (other instanceof Letter) {
            Letter v = (Letter) other;
            if ((v.letter == this.letter) && v.points == this.points) {
                return true;
            }
        }
        return false;

    }

    /**
     * Return string.
     *
     * @return String.
     */

    public String toString() {
        return (this.letter + ":" + this.points);

    }

}
