package hws.hw5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hws.hw4.Letter;


public class boardTest {

    @Test
    public void testSetEntries() {
        Letter a = new Letter('A', 1);

        a.setEntries();
    }

    @Test
    public void testGetLetter() {
        Letter a = new Letter('A', 1);
        Letter b = new Letter('C', 1);
        Letter c = new Letter('B', 1);

        assertEquals('A', a.getLetter());
        assertEquals('C', b.getLetter());
        assertEquals('B', c.getLetter());
    }

    @Test
    public void testGetLetterScore() {
        Letter a = new Letter('A', 1);
        Letter b = new Letter('C', 2);
        Letter c = new Letter('B', 3);

        int[] d = new int[1];
        int[] e = new int[2];
        int[] f = new int[3];

        assertEquals(1, a.getLetterScore(1));
    }

    @Test
    public void testGetPointMult() {
        int[] d = new int[1];
        int[] e = new int[2];
        int[] f = new int[3];

        assertEquals(1, d.getPointMult());
    }

    @Test
    public void testToString() {
        Letter[] array = {null, new Letter('a', 10), null, null};
        int[] a = {1, 10, 10, 1};
        String s = "test";

        Board b = new Board(array, a, s);

        assertEquals("-, a:10, -, -, ", b.toString());
    }
}
