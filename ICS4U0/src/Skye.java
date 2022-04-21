/*
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: A2 Inheritance 
 * Due Date: March 7th, 2022
 * Description: This program is designed to build a character of Skye Type
 */

// Skye Character Class inherits from Yoru class
public class Skye extends Yoru 
{ //sub  sub class 

	public String supSpeedVar;
	
	// Overload method for creating character of type Skye
	public Skye(String nameVar, String levelVar, String hitPointsVar, String resPowVar, String supSpeedVar)
	{
		// set fields
		this.nameVar = nameVar;
		this.levelVar = levelVar;
		this.hitPointsVar = hitPointsVar;
		this.resPowVar = resPowVar;
		this.supSpeedVar = supSpeedVar;
	}// skye method
	
	// declare class method
	public Skye()
	{
		
	}// skye class method
	
	// set super speed method
	public void setSupSpeed (String newSupSpeedVar)
	{
		supSpeedVar = newSupSpeedVar;
	}// set super speed
	
	public String getSupSpeed()
	{
		return supSpeedVar;
	}// get super speed
	
	// class description method; returns what this class contains and overrides the method called in Yoru class
	@Override
	public String classDescription()
	{
		return "This class is of Skye type; inherits abilities from BaseCharacter class and has res power and super speed";
	}
	
}// Skye class

