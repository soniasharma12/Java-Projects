
/*	Sonia Sharma
	ICS3U
	More Looping Problems
	March 3rd, 2021
	Description: This program is designed to translate the user's word from English into Rovatspraket. 
    			Aditionally, I decided to use indexOf() method within my code so that it would return the position
                of the letter first occuring within the string
*/

import java.util.Scanner;// import scanner class
public class Rovatspraket 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream 
    
    // User Input
    System.out.print(" Enter your word: ");
   	String word = keyb.nextLine();// get user's word
    
    // Initialize
    int count = 0, index = 0;// declare integer variables
    String cons ="bcdfghjklmnpqrstvwxyz", nextCons = "cdfghjklmnpqrstvwxyzz", vowel = "aeiou", closeVowel ="aaeeeiiiiooooouuuuuuu" ;// declare string variables
    String newWord = " "; // Rovatspraket translated word
    
    // While Loop Condition
    while(count<word.length())
    {// while the word length is greater than count
      
      if(vowel.indexOf(word.charAt(count))>=0)
      {// if the position of the vowel is greater or equal to 0
        newWord = newWord + word.charAt(count);// new word will print the letter in the word at count
      }// if statement
      
      else
      {// if the position of the vowel is less than or equal to 0
        index = cons.indexOf(word.charAt(count)); // get index of the posotion of the letter in the word at count
        newWord = newWord + word.charAt(count) + closeVowel.charAt(index) + nextCons.charAt(index);// new word will print the original letter, the closest vowel, and the next consonant to the original letter
      }// else
      
      count = count+1;// updater
      
    }// while
    
    // execute the following statement after while loop
    System.out.println(newWord);// print newWord
    
  }// main method
}// Rovatspraket class
