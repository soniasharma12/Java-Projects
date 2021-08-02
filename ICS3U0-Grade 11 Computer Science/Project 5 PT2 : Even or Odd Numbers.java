 
 /*	Sonia Sharma
	ICS3U
	Simple For Loops
	March 15th, 2021
	Description: This program is designed to ask the user for the starting value of their number sequence, and the ending number of their sequence. 
    			 Then it'll ask the user if they want even,odd, or both even and odd numbers printed
*/

import java.util.Scanner; // import Scanner class
public class EvenOddNums 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream
    
    // User Input
    
    System.out.print(" Enter your starting value: ");
    int startV = keyb.nextInt();// get user's starting value
    
    System.out.print(" Enter your ending value: ");
    int endV = keyb.nextInt();// get user's ending value
    
    System.out.print(" Do you want even, odd, or both numbers?(even/odd/both): ");
    String typeNum = keyb.next();// get type of numbers user's want to output; if they want all even, odd, or both even and odd numbers printed
    
    
    // For Loop condition 1; to get entire numbers list from start value till end value
    
    System.out.print(" Here are your numbers: ");// beginning statement before displaying numbers list
    
    for(int i = startV; i<=endV; i = i+1)
    {//for loop printing all numbers starting at the start value, till the end value, updating by an increment of 1 
      System.out.print(i+", ");
    }// for loop-1
    
    
    // For Loop condition 2; to get the numbers list based on either the user wants even, odd, or both even and odd numbers 
    
    String even = "even", odd = "odd", both = "both"; // declare string variables to store user's answer; if they want to print out all even, odd, or both numbers.
    if (typeNum.equals(even)||typeNum.equals(odd))// beginning statement before displaying numbers list
    {// if user enters "even" or "odd", print the following statement including their input for the type of numbers they'd like to output
      System.out.print("\n Here are your "+typeNum+" numbers: "+"\n");
    }// if statement
    else
    { //else, if the user enters "both", print the following statement
       System.out.print("\n Here are your numbers: "+"\n");
    }// else statement
    
    for(int j = startV; j<=endV; j = j+1)
    {//for loop printing the type of numbers user wants to output(even/odd/both) starting at the start value, till the end value, updating by an increment of 1
      
      if(typeNum.equals(even)&& j%2==0||typeNum.equals(both))
      {// if the user enters "even" or "both" and if any of the numbers in their sequence (from start value till end value) are divisible by 2, print all the even numbers. 
        System.out.println(" "+j); 
      }// if statement -even
      
      else if(typeNum.equals(odd)&& j%2!=0||typeNum.equals(both))
      {// else, if the user enters "odd" or "both" and if any of the numbers in their sequence (from start value till end value) are not divisible by 2, print all the odd numbers. 
        System.out.println(" "+j);
      }// else if statement-odd
        
    }// for loop-2 
        
    
  }// main method
}// EvenOddNums class

