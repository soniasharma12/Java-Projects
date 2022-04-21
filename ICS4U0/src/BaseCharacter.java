/*
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: A2 Inheritance 
 * Due Date: March 7th, 2022
 * Description: This program is the parent class where the 3 object classes will inherit from 
 */

// Base Character Class
public class BaseCharacter 
{
	public String nameVar;// stores character's name
	public String levelVar;// stores character's level
	public String hitPointsVar;// stores character's hitPoints

	//Create Character Method
	public BaseCharacter (String name, String level, String hitPoints)
	{
		this.nameVar = name; // store character's name as user's input
		this.levelVar = level;// store character's level as user's input
		this.hitPointsVar = hitPoints;// store character's hitPoints as user's hitPoints
	}// base character bracket
	
	public BaseCharacter()
	{
		// declare class method
	}// base character class method
	
	// Overload 
	public BaseCharacter (String nameVar) 
	{
		this.nameVar = nameVar;
	}// base character 
	
	// set name field method
	public void setName (String newNameVar)
	{
		 nameVar = newNameVar;
	}// set name

	// set level field method
	public void setLevel (String newLevelVar)
	{
		levelVar = newLevelVar;
	}// set level
	
	// set hitpoints field method
	public void setHitPoints (String newHitPointsVar)
	{
		hitPointsVar = newHitPointsVar;
	}// set hitpoints
	
	// get name field method
	public String getName()
	{
		return nameVar;
	}// get name
	
	// get level field method
	public String getLevel()
	{
		return levelVar;
	}// get level
	
	// get hitpoints field method
	public String getHitPoints()
	{
		return hitPointsVar;
	}// get hitpoints
	
	// class description method; returns what this class contains
	public String classDescription() 
	{
		return "This class is of BaseCharacter type; contains character's name, level, and hitpoints";
	}
}// BaseCharacter class 

