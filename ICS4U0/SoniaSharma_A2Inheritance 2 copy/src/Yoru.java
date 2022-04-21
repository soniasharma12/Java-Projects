/*
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: A2 Inheritance 
 * Due Date: March 7th, 2022
 * Description: This program is designed to build a character of Yoru type
 */

// Yoru Character Class inherits from BaseCharacter class
public class Yoru extends BaseCharacter 
{// sub class 

	public String resPowVar; 
	
	// Overload method for creating character of type Yoru
	public Yoru (String nameVar, String levelVar, String hitPointsVar, String resPowVar)
	{
		// set fields
		this.nameVar = nameVar;
		this.levelVar = levelVar;
		this.hitPointsVar = hitPointsVar;
		this.resPowVar = resPowVar;
	}// yoru method
	
	// declare class method
	public Yoru()
	{
		
	}// yoru class method
	
	// set res power method
	public void setResPow (String newResPow)
	{
		resPowVar = newResPow;
	}// set res pow
	
	//get res power method
	public String getResPow ()
	{
		return resPowVar;
	}// get res pow
	
	// class description method; returns what this class contains and overrides the method called in BaseCharacter class
	@Override
	public String classDescription() 
	{
		return "This class is of Yoru type; inherits abilities from BaseCharacter class and has res power";
	}
		
}// yoru class

