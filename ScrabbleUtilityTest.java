package hws.hw6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import hws.hw4.Letter;
import hws.hw5.*;


public class ScrabbleUtilityTest {

    @Test
    public void testAll() throws FileNotFoundException {
        Letter[] array = {null, new Letter('h', 0), new Letter('p', 4), null, null, null, null, null};
        Letter[] otherArray = {new Letter('e', 0), new Letter('l', 1), null, new Letter('z', 3), null, new Letter('d', 3), new Letter('s', 4), new Letter('o', 1)};

        int[] idk = new int[]{0, 0, 0, 1, 0, 0, 0, 0};

        // create/initialize a (expected)board
        Board eBoard = new Board(array, idk, "game.txt");
        // create/initialize a (expected)hand
        EnhancedHand eHand = new EnhancedHand(8);
        for (int i = 0; i < otherArray.length; i++) {
            eHand.insert(otherArray[i], i);
        }
        // write to a file using save scrabble
        ScrabbleUtility.saveScrabble("idk.csv", eBoard, eHand);

        // create/declare a new board actual board
        Letter[] rArray = {null, null, null, null, null, null, null, null};
        Board aBoard = new Board(rArray, idk, "fileName");
        // create/declare a new actual hand
        EnhancedHand aHand = new EnhancedHand(8);

        // read scrabble
        ScrabbleUtility.readScrabble("idk.csv", aBoard, aHand);
        // then check if the expected and actual are the same
        assertEquals(eBoard.toString(), aBoard.toString());
        assertEquals(eHand.toString(), aHand.toString());


    }
}
