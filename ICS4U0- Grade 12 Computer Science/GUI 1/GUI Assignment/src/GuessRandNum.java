/*	Name: Sonia Sharma
 
  	Due Date: February 15th, 2021
  	
	Course Code: ICS4U0
	
	Assignment Name: GUI Assignment 
	
	Description: 
	This program is a GUI game that allows the user to guess a randomly generated number from 1-6 by the computer, 
	by clicking any 6 of the buttons corresponding to their choice.
	This program also allows the user to quit the game at any time and start a new round.
	The scrollable text area displays the users results/prompts every time they choose a number(displays if their guess was correct or not). 
	If the user loses the game after 3 tries or wins the game, a new round will automatically start 
	If user wants to start a new round in the middle of the game, the correct answer will display and new round will start
	The number of tries left and amount of games won are displayed in the text labels and are updated after each round
 */

// Import required classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

//GuessRandNum class
public class GuessRandNum 
{
	// Declare Global Variables
	static int tries=3, gamesWon, gamesLost, randNum;// integer variables static; one instance of each  
	static JLabel promptLabel, gamesWonLabel, triesLeftLabel, gamesLostLabel;// label variables
	static JButton button1, button2, button3, button4, button5, button6;// button variables
	static JButton quitButton, resetButton;// button variables
	static JTextArea displayResults;// text area variable
	static volatile boolean roundRunning;// boolean variable
	static Random generator = new Random(); // randomly generates a number

	// drawGUI Method; displays the interface of the GUI and button functions
	public static void drawGUI()
	{
		JPanel panel;// declare panel variable which will store components

		// Label Components
		promptLabel = new JLabel ("Click to Guess a Number from 1-6\n:", JLabel.CENTER);// instantiate a label with the text set to center justified on the label
		promptLabel.setFont (new Font ("Poppins", Font.BOLD, 14));// set font and size of text label

		triesLeftLabel = new JLabel("Tries Left: 3");// instantiate a label with the text displaying the amount of tries user has left
		triesLeftLabel.setFont(new Font("Poppins", Font.PLAIN, 13));// set font and size of text label
		triesLeftLabel.setForeground(Color.red);// set color of text label

		gamesWonLabel = new JLabel("Games Won: 0");// instantiate a label with the text displaying the amount of games user won
		gamesWonLabel.setFont(new Font("Poppins", Font.PLAIN, 13));// set font and size of text text label
		gamesWonLabel.setForeground(Color.blue);// set color of text label

		gamesLostLabel = new JLabel("Games Lost: 0");// instantiate a label with the text displaying the amount of games user lost
		gamesLostLabel.setFont(new Font("Poppins", Font.PLAIN, 13));// set font and size of text text label
		gamesLostLabel.setForeground(Color.magenta);// set color of text label

		// Button Components
		button1 = new JButton ("1"); //instantiate a button with the label text of 1
		button2 = new JButton ("2"); //instantiate a button with the label text of 2
		button3 = new JButton ("3"); //instantiate a button with the label text of 3
		button4 = new JButton ("4"); //instantiate a button with the label text of 4
		button5 = new JButton ("5"); //instantiate a button with the label text of 5
		button6 = new JButton ("6"); //instantiate a button with the label text of 6
		quitButton = new JButton ("Quit Game"); //instantiate a button with the label text of Quit Game
		resetButton = new JButton ("Restart Game"); //instantiate a button with the label text of Restart Game

		// Text Area Components
		displayResults = new JTextArea (10,20);// instantiate displayResults text area; dimensions 10x20
		JScrollPane scrollPane = new JScrollPane (displayResults);// add the text area to a scroll component, so if more data than fit into set size a scroll bar is presented
		displayResults.setEditable (false);// make text area as read only

		// Add components to panel
		panel = new JPanel ();// instantiate the panel
		panel.add (promptLabel);// add components to the panel
		panel.add(triesLeftLabel);// displays amount of tries user has left
		panel.add(gamesWonLabel);// displays amount of games user won
		panel.add(gamesLostLabel);// displays amount of games user lost
		panel.add(scrollPane);// allows user to scroll through the text area
		panel.add (button1);// button 1 displayed on panel
		panel.add (button2);// button 2 displayed on panel
		panel.add (button3);// button 3 displayed on panel
		panel.add (button4);// button 4 displayed on panel
		panel.add (button5);// button 5 displayed on panel
		panel.add (button6);// button 6 displayed on panel
		panel.add(quitButton);// quit button displayed on panel
		panel.add(resetButton);// reset button displayed on panel

		// Frame Details
		JFrame frame = new JFrame ("Guess a Number Game"); // instantiate the frame with a title
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize (300, 370);// dimensions of frame: 300x370
		frame.getContentPane().add(panel); //add the panel with components to the frame

		//Button 1 is clicked
		button1.addActionListener (new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses button1, run the following code
				int userInput = Integer.parseInt(button1.getText());// stores value of user's choice of button into variable
				if (userInput==randNum)
				{// if user's guess through button selected is equal to the random number, run the following if statement
					correctGuess();// run correct guess method
				}// if bracket
				else 
				{// else, run the following else statement
					incorrectGuess();// call incorrect guess method
				}// else bracket
				button1.setEnabled(false);// disables user to press the button again until new round starts
			}// action performed bracket
		});// button 1 action listener

		//Button 2 is clicked
		button2.addActionListener (new ActionListener ()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses button2, run the following code
				int userInput = Integer.parseInt(button2.getText());// stores value of user's choice of button into variable
				if (userInput==randNum)
				{// if user's guess through button selected is equal to the random number, run the following if statement
					correctGuess();// run correct guess method
				}// if statement bracket

				else 
				{// else, run the following else statement
					incorrectGuess();// call incorrect guess method
				}// else statement bracket
				button2.setEnabled(false);// disables user to press the button again until new round starts
			}
		});

		//Button 3 is clicked
		button3.addActionListener(new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses button3, run the following code
				int userInput = Integer.parseInt(button3.getText());// stores value of user's choice of button into variable
				if (userInput==randNum)
				{// if user's guess through button selected is equal to the random number, run the following if statement
					correctGuess();// run correct guess method
				}// if statement bracket
				
				else 
				{// else, run the following else statement
					incorrectGuess();// call incorrect guess method
				}// else statement bracket
				button3.setEnabled(false);// disables user to press the button again until new round starts
			}
				});

		//Button 4 is clicked
		button4.addActionListener(new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses button3, run the following code
				int userInput = Integer.parseInt(button4.getText());// stores value of user's choice of button into variable
				if (userInput==randNum)
				{// if user's guess through button selected is equal to the random number, run the following if statement
					correctGuess();// run correct guess method
				}// if statement bracket
				
				else 
				{// else, run the following else statement
					incorrectGuess();// call incorrect guess method
				}// else statement bracket
				button4.setEnabled(false);// disables user to press the button again until new round starts
			}
				});

		//Button 5 is clicked
		button5.addActionListener(new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses button3, run the following code
				int userInput = Integer.parseInt(button5.getText());// stores value of user's choice of button into variable
				if (userInput==randNum)
				{// if user's guess through button selected is equal to the random number, run the following if statement
					correctGuess();// run correct guess method
				}// if statement bracket
				
				else 
				{// else, run the following else statement
					incorrectGuess();// call incorrect guess method
				}// else statement bracket
				button5.setEnabled(false);// disables user to press the button again until new round starts
			}
				});

		//Button 6 is clicked
		button6.addActionListener(new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses button3, run the following code
				int userInput = Integer.parseInt(button6.getText());// stores value of user's choice of button into variable
				if (userInput==randNum)
				{// if user's guess through button selected is equal to the random number, run the following if statement
					correctGuess();// run correct guess method
				}// if statement bracket
				
				else 
				{// else, run the following else statement
					incorrectGuess();// call incorrect guess method
				}// else statement bracket
				button6.setEnabled(false);// disables user to press the button again until new round starts
			}
				});

		// Quit Button is clicked
		quitButton.addActionListener(new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses quitButton, run the following code
				System.exit(0);// exit the entire program
			}
		});

		// Reset Button is clicked
		resetButton.addActionListener(new ActionListener()// adding action listener to the button component and creating a specific action performed method (override) for the button
		{
			public void actionPerformed (ActionEvent e)
			{// when user presses resetButton, run the following code
				
				if (tries<3)
				{// if user's tries are less than 3, run the following if statement
					displayResults.append("\nThe correct answer was: "+ randNum + "\n"+"\n------NEW ROUND------\n");// display the correct answer along with a prompt that new round is starting
					gamesLost++;// increment the user's loss
					gamesLostLabel.setText("Games Lost: "+gamesLost);// update user's loss in games lost label
				}// if statement bracket

				else if (tries==3) 
				{// else, if user's tries are 3, run the following else if statement 
					displayResults.append("\nRestarting game...."+"\n"+"\n------NEW ROUND------\n");// only prompt the user that a new round is starting
				}// else if statement bracket
				roundRunning = false;// don't run current round and automatically start a new round
			}
		});

		// Visibility of frame
		frame.setVisible(true);

	}// main bracket

	// runGame Method; when method is called, it allows the game to run. 
	public static void runGame() 
	{
		roundRunning = true;// round is currently running
		randNum = generator.nextInt(6)+1;// randomly generate a number from 1-6 and store it in variable
		while(roundRunning)// while game is running, run the empty loop, else, exit while loop when the round has ended, which allows a new number to generate
		{
		}// while loop bracket
		
	}// runGame bracket
	
	// Reset method; method is called when the round is over 
	public static void resetGame() 
	{
		tries = 3;// reset amount of tries to 3
		triesLeftLabel.setText("Tries Left: "+tries);// update amount of tries left
		gamesLostLabel.setText("Games Lost: "+gamesLost);// displays updated amount of games lost
		gamesWonLabel.setText("Games Won: "+gamesWon);// displays updated amount of games won
		button1.setEnabled(true);// enable the user to click button
		button2.setEnabled(true);// enable the user to click button
		button3.setEnabled(true);// enable the user to click button
		button4.setEnabled(true);// enable the user to click button
		button5.setEnabled(true);// enable the user to click button
		button6.setEnabled(true);// enable the user to click button
		roundRunning = false;// don't run current round and automatically start a new round
	}// playAgain bracket

	//Incorrect Guess Method; method called when user's guess of random number is incorrect
	private static void incorrectGuess()
	{
		if(tries<=3 && tries !=0) 
		{// if users tries are less than or equal to 3 and not equal to 0, run the if statement
			tries=tries-1;// decrement amount of tries 
			triesLeftLabel.setText("Tries Left: "+tries);// display updated amount of tries left in tries left text label
			displayResults.append("Wrong!\n");// tells the user that their guess is incorrect
		}//if statement bracket

		if (tries==0)
		{// if user has 0 tries left, run the following if statement
			displayResults.append("\nYou lost the game :(\nThe correct answer was: "+randNum+"\n"+"\n------NEW ROUND------\n");// tells the user that they lost the game
			gamesLost++;// increment user's losses
			gamesLostLabel.setText("Games Lost: "+gamesLost);// display updated amount of games lost in games lost text label

			button1.setEnabled(false);// disable the user to click button
			button2.setEnabled(false);// disable the user to click button
			button3.setEnabled(false);// disable the user to click button
			button4.setEnabled(false);// disable the user to click button
			button5.setEnabled(false);// disable the user to click button
			button6.setEnabled(false);// disable the user to click button
			roundRunning = false;// don't run current round and automatically start a new round
		}// if statement bracket

	}// incorrectGuess bracket

	//Correct Guess Method; method called when user's guess of the random number is correct
	private static void correctGuess()
	{
		displayResults.append("\nCorrect! Good Job!!"+"\n"+"\n------NEW ROUND------\n");// display prompt that user got the correct answer and indicate new round is starting
		gamesWon++;// increment user's wins
		gamesWonLabel.setText("Games Won: "+gamesWon);// display updated amount of games won in games won text label
		button1.setEnabled(false);// disable the user to click button
		button2.setEnabled(false);// disable the user to click button
		button3.setEnabled(false);// disable the user to click button
		button4.setEnabled(false);// disable the user to click button
		button5.setEnabled(false);// disable the user to click button
		button6.setEnabled(false);// disable the user to click button
		roundRunning = false;// don't run current round and automatically start a new round
	}// correctGuess bracket

	// Main Method
	public static void main (String[] args)
	{// call methods here
		drawGUI();// call draw gui method; allows the components and button conditions to run
		while(true) 
		{// run the following loop, until it's false 
			resetGame();// call reset game method which automatically restarts a new round after a win or loss
			runGame();// call run game method which initially generates a number and runs in a while loop until roundRunning is false. Then, method runs again and generates a new random num
		}// while loop bracket

	}// main bracket

}// class bracket
