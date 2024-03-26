package hws.hw5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import hws.hw4.Letter;

/**
 * HW5 Board.
 *
 * @author Will Ponczak
 * @version 02/22/2024
 */
public class Board {

    private Letter[] entries;
    private int[] pointMult;
    private ArrayList<String> words;

    /**
     * Constructor.
     *
     * @param multiplier multiplier
     * @param wordsPath wordsPath
     */
    public Board(int[] multiplier, String wordsPath) {
        // why are these highlighted
        entries = new Letter[multiplier.length];
        pointMult = Arrays.copyOf(multiplier, multiplier.length);

        try {
            this.words = WordsUtility.readWords(wordsPath);
        } catch (FileNotFoundException exc) {
            this.words = new ArrayList<String>();
        }
    }

    /**
     * Constructor.
     *
     * @param multiplier multiplier
     * @param board board
     * @param wordsPath words path
     */
    public Board(Letter[] board, int[] multiplier, String wordsPath) {
        entries = new Letter[board.length];
        pointMult = Arrays.copyOf(multiplier, multiplier.length);
        for (int i = 0; i < board.length; i++) {
            entries[i] = board[i];
            pointMult[i] = multiplier[i];
        }

        try {
            this.words = WordsUtility.readWords(wordsPath);
        } catch (FileNotFoundException exc) {
            this.words = new ArrayList<>();
        }

        // How do I create a constructor chain?
    }

    /**
     * Create this.entries.
     *
     * @param entries entries
     */
    public void setEntries(Letter[] entries) {
        if (this.entries.length != entries.length) {
            return;
        }
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
        }

    }

    /**
     * Return this.entries.
     *
     * @return this.entries
     */
    public Letter[] getEntries() {
        return this.entries;

    }

    /**
     * Letter at index.
     *
     * @param index index
     * @return index of the letter
     */
    public Letter getLetter(int index) {
        if (index < 0 || index >= this.entries.length) {
            throw new IllegalArgumentException();
        }
        return this.entries[index];
    }

    /**
     * Score at index.
     *
     * @param index index
     * @return score at index
     */
    public int getLetterScore(int index) {
        if (index < 0 || index >= this.entries.length
                || this.entries[index] == null) {
            return 0;
        }
        return (pointMult[index] * this.entries[index].getPoints());
    }

    /**
     * Get multiplier at index.
     *
     * @param index index
     * @return multiplier at index
     */
    public int getPointMult(int index) {
        if (index < 0 || index >= this.entries.length) {
            throw new IllegalArgumentException();
        }
        return pointMult[index];
    }

    /**
     * Create this.entries.
     *
     * @param letter to find in hand
     * @param index index
     * @return boolean
     */
    public boolean play(Letter letter, int index) {
        if (index >= 0 && index < this.entries.length
                && this.entries[index] == null) {
            this.entries[index] = letter;
            return true;
        }
        return false;
    }

    /**
     * Create word.
     *
     * @return String
     */
    public String readBoardWord() {
        String str = "";
        int index = -1;
        int index2 = 0;
        if (this.entries == null) {
            return "";
        }
        for (int i = 0; i < this.entries.length; i++) {
            if (this.entries[i] != null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "";
        }

        for (int i = (this.entries.length - 1); i >= 0; i--) {
            if (this.entries[i] != null) {
                index2 = i;
                break;
            }
        }

        for (int i = index; i <= index2; i++) {
            if (this.entries[i] == null) {
                this.entries[i] = new Letter('-', 0);
            }
            str = str + this.entries[i].getLetter();
        }
        return str;
    }

    /**
     * Validate the word.
     *
     * @param word word to validate
     * @return true or false
     */
    public boolean wordValidation(String word) {
        if (word == null) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            String newWord = words.get(i);
            if (word.equals(newWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find total score.
     *
     * @return total score
     */
    public int getBoardScore() {
        int num = 0;
        if (wordValidation(readBoardWord())) {
            for (int i = 0; i < this.entries.length; i++) {
                if (this.entries[i] != null) {
                    num += (this.entries[i].getPoints() * pointMult[i]);
                }
            }

        }
        return num;
    }

    /**
     * toString of file.
     *
     * @return String
     */
    public String toString() {
        String str = "";
        String dash = "-, ";
        for (int i = 0; i < this.entries.length; i++) {
            if (this.entries[i] != null) {
                str = str + this.entries[i].toString() + ", ";
            } else {
                str += dash;
            }

        }
        return str;

    }

}
