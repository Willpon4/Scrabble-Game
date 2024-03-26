package hws.hw6;

import java.io.FileNotFoundException;

import hws.hw4.Letter;
import hws.hw5.EnhancedHand;
import hws.hw5.Board;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * HW6 creating scrabble.
 *
 * @author Will Ponczak
 * @version 03/03/2024
 */
public class ScrabbleUtility {

    /**
     * Save Scrabble into new file.
     *
     * @param board board.
     * @param hand hand
     * @param fileName file.
     */
    public static void saveScrabble(String fileName, Board board,
            EnhancedHand hand) throws FileNotFoundException {
        // Create a new File for the fileName
        // Somehow save this file
        File file = new File(fileName);
        PrintWriter w = new PrintWriter(file);

        // This prints board: in the new file according to instructions
        w.println("board:");
        // This should print the board in the correct format according to
        // instructions
        String bString = board.toString();
        bString = bString.replaceAll(" ", "");
        w.println(bString);
        // This prints hand:
        w.println("hand:");
        // This prints hand in the correct format according to instructions.
        String hString = hand.toString();
        hString = hString.replaceAll(" ", "");
        hString += ",";
        w.println(hString);

        w.close();

    }

    /**
     * Initialize the letter and points.
     *
     * @param board board.
     * @param hand hand.
     * @param fileName file.
     */
    public static void readScrabble(String fileName, Board board,
            EnhancedHand hand) throws FileNotFoundException {
        // create a new file type for FileName
        File file = new File(fileName);
        // Open Scanner which reads files
        Scanner scanner = new Scanner(file);
        // We know that the file will only have 4 line at most
        // So we only have to iterate until 4 because the count starts at 0
        for (int count = 0; count < 4; count++) {
            // Line 1 would be the second line
            // This line has the Board information
            // Located under "Board:"
            if (count == 1) {
                // Create a new array which splits the string by commas
                // dont pay too much attention to the next() part, but you need
                String[] myArray = scanner.next().split(",");
                // So at this point, you have an array of strings
                // which should look like either "-" or "a:1"
                // Now you declare a Letter array which is the same length
                // as the string array
                Letter[] letters = new Letter[myArray.length];
                // now you iterate over each element in the string array
                for (int i = 0; i < myArray.length; i++) {
                    // you actually dont need this line so ignore it
                    System.out.println(myArray[i]);
                    // if the element is NOT a dash (which represents a null)
                    if (!myArray[i].equals("-")) {
                        // You dont need this line either so ignore it
                        System.out.print("HERE");
                        //  here you declare a char variable which gets the
                        // character in the element such as 'a' in "a:4"
                        char myChar = myArray[i].charAt(0);
                        // the next two lines are are actually one line
                        // they just exceed 80 chaarcters
                        // this line gets the integer from the element
                        // and then Integer.parseInt converts it into an int
                        // because it is originally a string
                        int myInt = Integer.
                                parseInt((myArray[i].substring(2, 3)));
                        // then you create a new letter object with the char
                        // and int
                        Letter letter = new Letter(myChar, myInt);
                        // Ignore this line
                        System.out.print(letter.toString());
                        // Now you are saying that in the Letter array which
                        // is declared above, i in that array is equal to the
                        // letter object you made
                        letters[i] = letter;
                        // if the element IS a "-"
                    } else {
                        // creates a Letter object of null
                        Letter letter = null;
                        // adds the null to the Letter array
                        letters[i] = letter;
                    }
                }
                // ignore this for loop
                for (int i = 0; i < letters.length; i++) {
                    // ignore
                    System.out.print(letters[i]);
                }

                // this then puts the letter array into the
                // setEntries method in board
                // you put board.setEntries because board is the parameter
                board.setEntries(letters);

            }
            // this would be the 4th line
            // aka the line with enhancedhand info
            // most of this is the same as before
            if (count == 3) {
                String[] myArray = scanner.next().split(",");
                Letter[] letters1 = new Letter[myArray.length];
                for (int i = 0; i < myArray.length; i++) {
                    // if it is NOT a "-"
                    if (!myArray[i].equals("-")) {
                        // gets character
                        char myChar = myArray[i].charAt(0);
                        // gets int
                        int myInt = Integer.
                                parseInt((myArray[i].substring(2, 3)));
                        // creates letter object with char and int
                        Letter letter = new Letter(myChar, myInt);
                        // adds letter object to letter array
                        letters1[i] = letter;
                        // if IT IS a "-"
                    } else {
                        // same thing as before
                        Letter letter = null;
                        letters1[i] = letter;
                    }
                }
                // here you use the insert method from the
                // enhancedhand file
                for (int i = 0; i < myArray.length; i++) {
                    hand.insert(letters1[i], i);
                }

            }

            // this makes sure that there is no out of bounds exception
            if (count != 3) {
                scanner.nextLine();
            }


        }
        // close the scanner
        scanner.close();
    }
}
