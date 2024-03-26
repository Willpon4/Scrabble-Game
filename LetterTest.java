package hws.hw4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LetterTest {

    @Test
    public void testConstructor() {
        Letter a = new Letter('D', 4);
        Letter b = new Letter('B', 2);

        assertEquals('D', a.getLetter());
        assertEquals('B', b.getLetter());

        assertEquals(4, a.getPoints());
        assertEquals(2, b.getPoints());
    }

    @Test
    public void testGetLetter() {
        Letter a = new Letter('D', 4);
        Letter b = new Letter('B', 2);

        assertEquals('D', a.getLetter());
        assertEquals('B', b.getLetter());
    }

    @Test
    public void testGetPoints() {
        Letter a = new Letter('D', 4);
        Letter b = new Letter('B', 2);

        assertEquals(4, a.getPoints());
        assertEquals(2, b.getPoints());
    }

    @Test
    public void testEquals() {
        Letter a = new Letter('D', 4);
        Letter b = new Letter('B', 2);
        Letter c = new Letter('A', 1);
        Letter d = new Letter('R', 8);
        Letter t = new Letter('D', 4);
        Letter g = new Letter('B', 2);
        Letter a1 = new Letter('D', 3);
        Letter b1 = new Letter('B', 10);
        Letter a2 = new Letter('D', 10);
        Letter b2 = new Letter('B', 3);

        assertTrue(a.equals(t));
        assertTrue(b.equals(g));
        assertFalse(c.equals(t));
        assertFalse(d.equals(a));
        assertFalse(b2.equals(a1));
        assertFalse(a2.equals(b1));
        assertFalse(b1.equals(g));
        assertFalse(b1.equals("a"));

    }

    @Test
    public void testToString() {
        Letter a = new Letter('D', 4);
        Letter b = new Letter(' ', 4);
        Letter c = new Letter('D', 0);

        assertEquals("D:4", a.toString());
        assertEquals(" :4", b.toString());
        assertEquals("D:0", c.toString());

    }

    @Test
    public void testSets() {
        Letter a = new Letter('D', 4);

        a.setLetter('D');
        a.setPoints(4);
    }
}
