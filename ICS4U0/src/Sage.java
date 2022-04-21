/*
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: A2 Inheritance 
 * Due Date: March 7th, 2022
 * Description: This program is designed to build a character of Sage type
 */

// Sage Character Class inherits from BaseCharacter class
public class Sage extends BaseCharacter 
{// sub class 

	public String healPowVar;
	
	// Overload method for creating character of type Sage
	public Sage (String nameVar, String levelVar, String hitPointsVar, String healPowVar)
	{
		this.nameVar = nameVar;
		this.levelVar = levelVar;
		this.hitPointsVar = hitPointsVar;
		this.healPowVar = healPowVar;
	}// sage method
	
	public Sage()
	{
		// declare class method
	}// sage class method
	
	// set heal power field method
	public void setHealPow (String newHealPowVar)
	{
		healPowVar = newHealPowVar;
	}// set heal pow
	
	// get heal power field method
	public String getHealPow ()
	{
		return healPowVar;
	}// get heal pow
	
	// class description method; returns what this class contains and overrides the method called in BaseCharacter class
	@Override
	public String classDescription() 
	{
		return "This class is of Sage type; inherits abilities from BaseCharacter class and has heal power";
	}
}// Sage class
	