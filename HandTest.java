package hws.hw4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HandTest {

    @Test
    public void testConstructor() {
        Hand hand = new Hand();
        assertEquals(Hand.MAX_SIZE, hand.getSize(),
                "Constructor should create a hand of size MAX_SIZE");

        hand = new Hand(-5);
        assertEquals(0, hand.getSize(),
                "Constructor with negative size should create a hand of size 0");

        hand = new Hand(5);
        assertEquals(5, hand.getSize(),
                "Constructor with valid size should create a hand of that size");

        hand = new Hand(Hand.MAX_SIZE + 7);
        assertEquals(Hand.MAX_SIZE, hand.getSize(),
                "Hand size should not exceed the MAX_SIZE");
    }

    @Test
    public void testGetLetter() {
        Hand hand = new Hand();
        Letter letter = new Letter('a', 1);
        hand.insert(letter, 0);
        assertEquals(letter, hand.getLetter(0),
                "Should return the letter object at a first index");
    }

    @Test
    public void testInsert() {
        Hand hand = new Hand();
        Letter letter = new Letter('a', 1);
        assertTrue(hand.insert(letter, 0),
                "Should be successful for a valid index");
        assertEquals(letter, hand.getLetter(0),
                "Inserted letter should be found at the specified index");
        assertFalse(hand.insert(letter, -1),
                "Should be unsuccessful for a negative index");
        assertFalse(hand.insert(letter, Hand.MAX_SIZE),
                "Should be unsuccessful for index MAX_SIZE");
    }

    @Test
    public void testInsertOccupied() {
        Hand hand = new Hand();
        Letter letter1 = new Letter('a', 1);
        Letter letter2 = new Letter('b', 2);
        hand.insert(letter1, 0);
        assertFalse(hand.insert(letter2, 0),
                "Cannot insert a new letter at an existing letter index");
    }

    @Test
    public void testRemove() {
        Hand hand = new Hand();
        Letter letter1 = new Letter('a', 1);
        Letter letter2 = new Letter('b', 2);
        hand.insert(letter1, 0);
        hand.insert(letter2, 3);
        assertEquals(letter1, hand.remove(0),
                "Removed letter should match the previously inserted letter at the index");
        assertNull(hand.getLetter(0),
                "A letter should not be found at the index after removal");
        assertEquals(letter2, hand.remove(3),
                "Removed letter should match the previously inserted letter at the index");
        assertNull(hand.getLetter(3),
                "A letter should not be found at the index after removal");
        // the following calls should not throw an out of bounds exception
        assertNull(hand.remove(-1),
                "trying to remove a letter at a negative index");
        assertNull(hand.remove(Hand.MAX_SIZE),
                "trying to remove a letter at index MAX_SIZE");
    }

    @Test
    public void testIndexOf() {
        Hand hand = new Hand();
        Letter letter = new Letter('a', 1);
        hand.insert(letter, 0);
        assertEquals(0, hand.indexOf('a'),
                "Index of existing letter should be correct");
        assertEquals(-1, hand.indexOf('z'),
                "Index of non-existing letter should be -1");
    }

    @Test
    public void testToString() {
        Hand hand = new Hand(2);
        Letter letter = new Letter('a', 1);
        Letter letter1 = new Letter('b', 4);
        hand.insert(letter, 0);
        hand.insert(letter1, 1);
        assertEquals("a:1,b:4", hand.toString(),
                "String representation of a non-empty hand should be correct");
    }

    @Test
    public void testToStringNull() {
        Hand hand = new Hand(2);
        Letter letter = new Letter('a', 1);
        hand.insert(letter, 0);
        assertEquals("a:1,-", hand.toString(),
                "String representation of an empty letter in a hand should be -");
    }
}
