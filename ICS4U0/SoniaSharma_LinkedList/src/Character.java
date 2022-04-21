/*
/* *********** Assignment Information **********
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: Linked List V2
 * Due Date: March 11th, 2022
 * Description: This is the Character class which represents a character of the linked list, along with a pointer to the next 
 * character and previous character in the list
 * 
 */

public class Character
{// Character class with 3 attributes
	char userInput;// stores user's input
	Character previous, next;// two attributes that store references to the previous character and next character in list
	
	// Character Constructor; takes user's input
	public Character (char userInput)
	{
		this.userInput = userInput;
		this.previous = null; 
		this.next = null;
	}
	
	public Character() 
	{
		// empty constructor
	}
	
	// getters and setters
	public char getWord() 
	{
		return this.userInput;
	}

	public void setWord (char userInput)
	{
		this.userInput = userInput;
	}

	// getPrevious method gets the previous char of the list
	public Character getPrevious()
	{
		return this.previous;
	}

	// setPreviousChar method sets the previous char to the character specified in the method argument
	public void setPreviousChar(Character CharLink1)
	{
		this.previous = CharLink1;
	}
	
	// getNext method gets the next character of the list
	public Character getNext() 
	{
		return this.next;
	}
	
	// setNextChar method sets the next char to the specified character in the method argument
	public void setNextChar(Character CharLink2) 
	{
		this.next = CharLink2;
	}
	
}// Character object class
