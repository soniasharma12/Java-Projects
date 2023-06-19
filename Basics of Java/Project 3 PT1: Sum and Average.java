
/*  Sonia Sharma
	ICS3U
	While Loops Assignment
	Feb. 25th, 2021
	Description: This program is designed to calculate the sum and average of the number(s) given by the user, as long as they're positive! 
    			 If the user's does decide to enter a negative number, the program will terminate and output the calculations based on the 
                 positive numbers!
*/

import java.util.Scanner; // import Scanner class
public class SumAvg 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream 
    
	// Initialize Variables 
    int totNum = 0,number=0, sumNum=0; 
    double avg=0;
        
    
	// Introduce User   
    System.out.println(" Welcome to the Sum n' Avg Game!");
    System.out.print("\n Before we get started, please enter your first name: ");
    String name = keyb.next(); // get user's name
    System.out.println(" Hi "+name+"! Now let's get started!");
    
    
	// While Loop    
    while(number >= 0)
    {// repeated action; while user's number is positive or zero (greater than or equal to 0) 
      System.out.print("\n Enter a number that is positive or zero(enter a negative value to end the program): ");
      number = keyb.nextInt();// get user's number
      
      if(number >= 0)
      {// if the user enters a positive number
        sumNum = sumNum + number;// sum of number's given by the user(add only positive numbers)
        double sumNumDoub = sumNum; // convert sum of positive integers to double, so we could calculate the average as a double value(decimal value)
        totNum = totNum+1;// count total numbers given by the user but only those that are positive 
        avg = sumNumDoub/totNum;// calculate the average of positive numbers 
      }// if statement
      
  	 }// while loop
    
    // execute the following print statements once user has entered a negative number
    System.out.print("\n You have entered "+totNum+" number(s)");
    System.out.print("\n The sum of the numbers you've entered is "+sumNum);
    System.out.print("\n The average of the numbers you've entered is "+avg);
    
  }// main method
}// SumAvg class

