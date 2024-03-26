package hws.hw4;

/**
 * HW4 creating scrabble.
 *
 * @author Will Ponczak
 * @version 02/18/2024
 */

public class Hand {

    static final int MAX_SIZE = 8;
    private Letter[] hand;
    private int size;

    /**
     * Initialize the size and hand.
     */

    public Hand() {
        hand = new Letter[MAX_SIZE];
        this.size = MAX_SIZE;
    }

    /**
     * Initialize the size.
     *
     * @param size size.
     */

    public Hand(int size) {
        this.size = size;
        if (this.size < 0) {
            this.size = 0;
        } else if (this.size > MAX_SIZE) {
            this.size = MAX_SIZE;
        }
        hand = new Letter[this.size];

    }

    /**
     * Initialize the size.
     *
     * @return int size.
     */

    public int getSize() {
        return this.size;

    }

    /**
     * Initialize the size.
     *
     * @param index index.
     * @return Letter.
     */

    public Letter getLetter(int index) {
        return hand[index];
    }

    /**
     * Initialize the size.
     *
     * @param letter size.
     * @param index index.
     * @return boolean.
     */

    public boolean insert(Letter letter, int index) {

        if (index < 0 || index >= this.size) {
            return false;
        }

        if (this.hand[index] == null) {
            this.hand[index] = letter;
            return true;
        }
        return false;

    }

    /**
     * Initialize the size.
     *
     * @param index index.
     * @return Letter.
     */

    public Letter remove(int index) {
        if (index >= 0 && index < this.hand.length) {
            Letter rand = this.hand[index];
            this.hand[index] = null;
            return rand;

        }
        return null;
    }

    /**
     * Initialize the size.
     *
     * @param letter letter.
     * @return int
     */

    public int indexOf(char letter) {

        for (int i = 0; i < hand.length; i++) {

            if (hand[i] != null && hand[i].getLetter() == letter) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Initialize the size.
     *
     * @return String.
     */

    public String toString() {
        String str = "";

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                str = str + "-";
                return str.substring(0, str.length());
            } else {
                str = str + hand[i].getLetter() + ":" + hand[i].getPoints()
                        + ",";
            }
        }
        return str.substring(0, str.length() - 1);
    }
}
