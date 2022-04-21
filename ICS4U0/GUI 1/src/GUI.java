import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;

// GuessRandNum class
public class GUI 
{
	//Declare Variables
	static int z = 0, y = 0, c = 0, randNum, tries=3, gamesWon;// static; one instance of each 
	static String textNumber, textName;
	static JLabel promptLabel1, promptLabel2, triesLeftLabel, gamesWonLabel;
	static JButton button1, button2, button3, button4, button5, button6;
	static JButton quitButton, playAgainButton;
	static JTextArea displayResults, triesLeftTxtArea, gamesWonTxtArea;
	static JComboBox combobox;
	
	static JPanel panel;

	public static void main (String[] args)
	{
		String line;
		
		Random generator = new Random();// random generator
		int randNum = generator.nextInt(6)+1;
		
		
		promptLabel1 = new JLabel ("Click to Guess a Number from 1-6\n:", JLabel.CENTER); //instantiate a label with the text set to right justified on the label
		promptLabel1.setFont (new Font ("Poppins", Font.BOLD, 14));
		promptLabel1.setForeground (Color.black);
		
		/*promptLabel2= new JLabel("In order to guess, click the button corresponding to your number choice\n", JLabel.CENTER);
		promptLabel2.setFont (new Font ("Poppins", Font.BOLD, 10));
		promptLabel2.setForeground (Color.black);*/
		
		triesLeftLabel = new JLabel("\nTries Left:", JLabel.CENTER);
		triesLeftLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
		triesLeftLabel.setForeground(Color.red);
		
		
		gamesWonLabel = new JLabel("Games Won:\n", JLabel.CENTER);
		gamesWonLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
		gamesWonLabel.setForeground(Color.blue);
		
	
		button1 = new JButton ("1"); //instantiate a button with the label text of Submit
		button2 = new JButton ("2"); //instantiate a button with the label text of Submit
		button3 = new JButton ("3"); //instantiate a button with the label text of Submit
		button4 = new JButton ("4"); //instantiate a button with the label text of Submit
		button5 = new JButton ("5"); //instantiate a button with the label text of Submit
		button6 = new JButton ("6"); //instantiate a button with the label text of Submit
		quitButton = new JButton ("Quit Game");
		playAgainButton = new JButton ("Play Again");
		
		ButtonGroup group = new ButtonGroup();
		group.add (button1);
		group.add (button2);
		group.add (button3);
		group.add (button4);
		group.add (button5);
		group.add (button6);
		group.add (quitButton);
		group.add (playAgainButton);


		displayResults = new JTextArea (10,20); //instantiate text area
		JScrollPane scrollPane1 = new JScrollPane (displayResults); // add the text area to a scroll component, so if more data than fit into set size a scroll bar is presented
		displayResults.setEditable (false); //make textarea as read only!
		
		triesLeftTxtArea = new JTextArea (1,1); //instantiate text area
		JScrollPane scrollPane2 = new JScrollPane (triesLeftTxtArea); // add the text area to a scroll component, so if more data than fit into set size a scroll bar is presented
		triesLeftTxtArea.setEditable (false); //make textarea as read only!
		
		gamesWonTxtArea = new JTextArea(1,1);
		JScrollPane scrollPane3 = new JScrollPane(gamesWonTxtArea);
		gamesWonTxtArea.setEditable(false);

		panel = new JPanel (); //instantiate the panel
		panel.add (promptLabel1); //add components to the panel
		//panel.add(promptLabel2);
		panel.add(triesLeftLabel);
		panel.add(triesLeftTxtArea);
		panel.add(gamesWonLabel);
		panel.add(gamesWonTxtArea);
		panel.add (displayResults);
		panel.add (button1);
		panel.add (button2);
		panel.add (button3);
		panel.add (button4);
		panel.add (button5);
		panel.add (button6);
		panel.add(quitButton);
		panel.add(playAgainButton);
		
		displayResults.append("RandNum: "+randNum+"\n");// outputs rand num genenrated
		triesLeftTxtArea.setText(" ");
		triesLeftTxtArea.append(" "+tries);
		
		JFrame frame = new JFrame ("Guess a Number Game"); // instantiate the frame with a title
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize (300, 370);

		frame.getContentPane ().add (panel); //add the panel with components to the frame
		
		button1.addActionListener (new ActionListener()  //adding item listener to a radio button
				{
			public void actionPerformed (ActionEvent e)  //override itemstatechanged to detect radio button state change
			{
				int userInput = Integer.parseInt(button1.getText());
				if (userInput==randNum)
				{
					displayResults.append("Correct! The correct answer was: "+randNum+"\n");
					gamesWon++;
					gamesWonTxtArea.append(" "+gamesWon);
				}
				else 
				{
					tries=tries-1;
					triesLeftTxtArea.setText(" ");
					triesLeftTxtArea.append(" "+tries);
					displayResults.append("Wrong!\n");
					if(tries==0) 
					{
						displayResults.append("You lost the game :(\nThe correct answer was "+randNum+"\n");
						
					}
				}
				button1.setEnabled(false);// allows user to select this button only once
				
			}
				}
				);
		button2.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				int userInput = Integer.parseInt(button2.getText());
				
				if (userInput==randNum)
				{
					displayResults.append("Correct! The correct answer was: "+randNum+"\n");
					button2.setEnabled(false);
					gamesWon++;
					gamesWonTxtArea.append(" "+gamesWon);
				}
				
				else 
				{
					tries=tries-1;
					triesLeftTxtArea.setText(" ");
					triesLeftTxtArea.append(" "+tries);
					displayResults.append("Wrong!\n");
					if(tries==0) 
					{
						displayResults.append("You lost the game :(\nThe correct answer was "+randNum+"\n");
						
					}
					button2.setEnabled(false);
				}
				
			}
				}
				);
		button3.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				int userInput = Integer.parseInt(button3.getText());
				
				if (userInput==randNum)
				{
					displayResults.append("Correct!The correct answer was: "+randNum+"\n");
					button2.setForeground(Color.RED);
					gamesWon++;
					gamesWonTxtArea.append(" "+gamesWon);
				}
				else 
				{
					tries=tries-1;
					triesLeftTxtArea.setText(" ");
					triesLeftTxtArea.append(" "+tries);
					displayResults.append("Wrong!\n");
					if(tries==0) 
					{
						displayResults.append("You lost the game :(\nThe correct answer was "+randNum+"\n");
						
					}
				}
				button3.setEnabled(false);
			}
				}
				);
		button4.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				int userInput = Integer.parseInt(button4.getText());
				
				if (userInput==randNum)
				{
					displayResults.append("Correct! The correct answer was: "+randNum+"\n");
					button2.setForeground(Color.RED);
					gamesWon++;
					gamesWonTxtArea.append(" "+gamesWon);
				}
				else 
				{
					tries=tries-1;
					triesLeftTxtArea.setText(" ");
					triesLeftTxtArea.append(" "+tries);
					displayResults.append("Wrong!\n");
					if(tries==0) 
					{
						displayResults.append("You lost the game :(\nThe correct answer was "+randNum+"\n");
						
					}
				}
				button4.setEnabled(false);
			}
				}
				);
		button5.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				int userInput = Integer.parseInt(button5.getText());
				
				if (userInput==randNum)
				{
					displayResults.append("Correct! The correct answer was: "+randNum+"\n");
					button2.setForeground(Color.RED);
					gamesWon++;
					gamesWonTxtArea.append(" "+gamesWon);
				}
				else 
				{
					tries=tries-1;
					triesLeftTxtArea.setText(" ");
					triesLeftTxtArea.append(" "+tries);
					displayResults.append("Wrong!\n");
					if(tries==0) 
					{
						displayResults.append("You lost the game :(\nThe correct answer was "+randNum+"\n");
						
					}
				}
				button5.setEnabled(false);
			}
				}
				);
		button6.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				int userInput = Integer.parseInt(button6.getText());
				
				if (userInput==randNum)
				{
					displayResults.append("Correct! The correct answer was: "+randNum+"\n");
					button2.setForeground(Color.RED);
					gamesWon++;
					gamesWonTxtArea.append(" "+gamesWon);
				}
				else 
				{
					tries=tries-1;
					triesLeftTxtArea.setText(" ");
					triesLeftTxtArea.append(" "+tries);
					displayResults.append("Wrong!\n");
					if(tries==0) 
					{
						displayResults.append("You lost the game :(\nThe correct answer was "+randNum+"\n");
						
					}
				}
				button6.setEnabled(false);
			}
				}
				);
		quitButton.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				System.exit(0);
			}
				}
				);
		playAgainButton.addActionListener (new ActionListener ()  //adding action listener to the button component and creating a specific action performed method (override) for the button
				{
			public void actionPerformed (ActionEvent e)
			{
				//displayResults.append("The correct answer was: "+randNum+"\n");
				
				Random generator = new Random();// random generator
				int randNum = generator.nextInt(6)+1;
				displayResults.append("RandNum: "+randNum+"\n");// outputs rand num genenrated
				
			}
				}
				);
		
		frame.setVisible (true);
	}// main bracket
	
}// GuessRandNum class bracket

