/*	Sonia Sharma
	ICS3U
	Simple For Loops
	March 15th, 2021
	Description: This program is designed to print as many Fibonacci numbers as the user asks for by using a for loop.
    			 Fibonacci Sequence: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,...
*/

import java.util.Scanner; // import Scanner class
public class FibonacciNums 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream
    
    //Initialize
    int a = 1, b = 1, sum =0;// initialize variables; a = first recent value in fibonacci sequence, b = first recent value in sequence, sum = sum of a & b depending on user's input 
    
    // User Input
    System.out.print(" Enter the amount of Fibonacci numbers you’d like to output: ");
    int num = keyb.nextInt();// get user's num; the amount of fibonacci numbers they'd like to output
    
    // Conditions
    if(num==0)
    {// if the user enters 0, don't output anything
      
    }// if statement 
        
    for (int count = 1; count<=num; count = count + 1)
    {// for loop to iterate to num(user input), displaying the sum of the previous 2 numbers stored in variable "a"
      System.out.print(" "+a+",");
      sum = a + b; // let "sum" equal to the sum of "a" and "b" 
      a = b;// update "a" to equal "b"
      b = sum;// update "b" to equal "sum"
    }// for loop 
    
  }// main method
}// FibonacciNums class
