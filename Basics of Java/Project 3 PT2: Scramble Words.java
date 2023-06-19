
/*  Sonia Sharma
	ICS3U
	While Loops Assignment
	Feb. 25th, 2021
	Description: Scramble Words is a program designed to quiz the user by prompting 8 random letters which can form a word. 
    			 The user has 3 guesses/tries to guess the word. If the user isn't able to guess it within the 3 tries, 
                 the computer will reveal the word! Good luck :)
*/

import java.util.Scanner; // import Scanner class
public class ScrambleWords 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream 

    // Initialize Variables
    String userGuess="", answer="aviation"; // user's guess of the word, and the right answer 
    int tries = 3; // the limited amount of tries user has 
    
    // Welcome Statement + Start
    System.out.print(" Welcome to the Scramble Words Quiz! Type start whenever you're ready: ");
    String pressSrt = keyb.next(); // get user to enter start when they're ready

	// While Loop Condition
    while(tries > 0 && !userGuess.equals(answer))
    {// boolean expression; while amount of tries has not reached it's limit(0) & user's guess is not equal to the answer
      
      System.out.print(" What 8-letter word can be created with these given letters; i t a o n v i a : ");
      userGuess = keyb.next(); // get user's guess
      
      if (!userGuess.equals(answer))
      { // repeated action; if user's guess is  wrong (not equal to the answer)
        tries= tries-1; // updater; decrement tries
        System.out.println(" Wrong! You have " + tries + " tries left.");
      } // if statement 
      
      else if (userGuess.equals(answer))
      { // else, if the user's guess is right(equal to the answer)
        System.out.print(" Amazing job!");
      } // else if statement
      
    } // while loop
    
    // execute the answer once the loop has ended(if user has reached the limit of tries or got the right answer)
    System.out.println (" The correct answer is "+answer);

  }// main method
}// ScrambleWords class
