/*	Sonia Sharma
	ICS3U
	More Looping Problems
	March 1st, 2021
	Description: This program is designed to determine the user's overall mood from their input message 
*/

import java.util.Scanner; // import Scanner class
public class HappyOrSad 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream 
    
    // User Input
    System.out.print(" Enter your message: ");
    String message = keyb.nextLine();// get user's message
    
    // Initialize:
    int lenOfMsg=message.length();// get length of user's message
    int happy=0, sad=0, count = 0;// declare variables
    
    while(count<lenOfMsg)
    {// while count is less than the length of user's message
      
      if(message.charAt(count) == ':' && message.charAt(count+1) == '-')
      {// if user's message at count is equal to ":" and at count+1 is equal to "-"
        
        if(count+2<lenOfMsg)
        {// if count+2 is less than the length of user's message

          if(message.charAt(count+2) == ')')
          {// if user's message at count+2 is a smile
            happy = happy + 1;// increment happy                
          }// if statement in loop -3
            
          else if(message.charAt(count+2) == '(')
          {// else if user's message at count+2 is a frown
            sad = sad+1;// increment sad                    
          }// else-if statement in loop
                     
          
        }// if statement in loop -2
          
        
      }// if statement in loop -1
      
      count = count + 1;// updater; increment count
      
    }// while loop
    
	// run the following conditions once while loop ends
    if(happy==0 && sad==0)
    {// if the user is not happy nor sad 
      System.out.print(" None");
    }// if statement 
    
    else if(happy>sad)
    {// else if user's mood is happy 
      System.out.print(" Happy");
    }// else if statement-1
    
    else if(happy==sad)
    {// else if user's mood is both happy and sad
      System.out.print(" Unsure");
    }// else if statement-2     
    
    else
    {// if user's mood is sad 
      System.out.print(" Sad");
    }// else if statement

    
  }// main method
}// HappyOrSad class
