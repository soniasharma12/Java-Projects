/* 
 * *********** Assignment Information **********
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: Linked List V2
 * Due Date: March 11th, 2022
 * Description: This program is a GUI of a palidrome checker. User enters a sequence of characters and the program will display in the text area
 * whether user's input is a palindrome or not. User has to press the reset button in order to submit another respose to be checked. User is also
 * allowed to quit the program at any time.
 * 
 *  *********** Assignment Concepts **********
 *  
 * Check button: 140-171 in GUI.java file
 * 
 * Reset button: 143-184 in GUI.java file
 * 
 * Quit button: 186-193 in GUI.java file
 * 
 * user friendly: prompt messages in check button action listener 
 * 
 * double link list: 199-247 in GUI.java file (refer to Character.java file for gets and sets)
 * 
 * works on a word, numbers: test word phrase; level AND test number phrase; 1221
 * 
 * works on sentence with punctuation, caps, spacing: test phrase; Satan, Oscillate My Metallic Sonatas
 */

// import modules
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// GUI class
public class GUI extends JFrame 
{
	// Declare variables
	private JPanel contentPane;
	private JTextField textField;
	private JButton checkBtn, quitBtn, resetBtn;
	private JLabel title, enterLbl, resultsLbl;
	private JTextArea textArea;
	private String userInput;// user's input
	
	//Launch the application	 
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}// main method

	// GUI method
	public GUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/************ GUI COMPOENENTS ************/
		
		// title of the program
		title = new JLabel("Palindrome Checker");
		title.setFont(new Font("Heiti SC", Font.BOLD, 17));
		title.setForeground(Color.BLUE);
		
		// check button declaration
		checkBtn = new JButton("CHECK");
		checkBtn.setFont(new Font("Heiti SC", Font.BOLD, 13));
		
		// reset button declaration
		resetBtn = new JButton("RESET");
		resetBtn.setFont(new Font("Heiti SC", Font.BOLD, 13));
		
		// quit button declaration
		quitBtn = new JButton("QUIT");
		quitBtn.setFont(new Font("Heiti SC", Font.BOLD, 13));
		
		// text field declaration
		textField = new JTextField();
		textField.setBounds(127, 61, 260, 37);
		
		// ennter label declaration
		enterLbl = new JLabel("Enter Text: ");
		enterLbl.setFont(new Font("Heiti SC", Font.PLAIN, 15));
		
		// results label declaration
		resultsLbl = new JLabel("Results:");
		resultsLbl.setFont(new Font("Heiti SC", Font.PLAIN, 15));
		
		// text area declaration
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		// Add components to panel
		title.setBounds(169, 20, 176, 29);
		contentPane.add(title);
		checkBtn.setBounds(399, 66, 100, 29);
		contentPane.add(checkBtn);
		resetBtn.setBounds(137, 182, 92, 29);
		contentPane.add(resetBtn);
		quitBtn.setBounds(293, 182, 92, 29);
		contentPane.add(quitBtn);
		contentPane.add(textField);
		textField.setColumns(10);
		enterLbl.setBounds(30, 71, 85, 16);
		contentPane.add(enterLbl);
		resultsLbl.setBounds(30, 138, 85, 16);
		contentPane.add(resultsLbl);
		textArea.setBounds(127, 126, 260, 29);
		contentPane.add(textArea);
		
		checkBtn.setEnabled(true);// allow user's input when program is running
		resetBtn.setEnabled(false);// dont allow user to reset when retrieving user's input
		quitBtn.setEnabled(true);// allow user to quit at any time
		
		/************ BUTTONS ************/
		
		// Check Button; allows user to check if their input is a Palindrome
		checkBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				userInput = textField.getText();// get user's input
				userInput = userInput.replaceAll("[^A-Za-z0-9_-]", "").toLowerCase();// discard special characters and spaces and update user's input 
				
				if(userInput.equals("")) 
				{// if user's input is blank, run the following if statement
					textArea.append("No input taken! Please reset checker!");// prompt user to reset checker
				}// if statement
				
				else 
				{// else, if user's input is NOT blank, run the following else statement
					if (checkPalindrome(userInput))
					{// if user's input is a palindrome, run the following if statement
						textArea.append(" Your input is a Palindrome");
					}// if statement
					
					else
					{// else, if the user's input is NOT a palindrome, run the following else statement
						textArea.append(" Your input is NOT a Palindrome");
					}// else statement
				}// else statement
				
				checkBtn.setEnabled(false);// don't allow user to check the same word again and allow them to either quit or reset game
				textField.setText(null);// clear text field where user inputs 
				resetBtn.setEnabled(true);// allow user to reset checker
				textField.setEnabled(false);// dont allow user to type another input
			}
		});// check btn

		// Reset Button; allows user to enter another word by clearing text from text field and area 
		resetBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				checkBtn.setEnabled(true);// allow user to check 
				textArea.setText(null);// clear text area where messages are displayed
				textField.setText(null);// clear text field where user inputs word
				resetBtn.setEnabled(false);// dont allow user to reset again until they check their input
				textField.setEnabled(true);// allow user to input 
			}
		});// reset btn

		// Quit Button; allows user to leave the program at any time
		quitBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);// leaves checker
			}
		});// quit btn	

	}// GUI method
	
	/************ ASSIGNMENT CONCEPTS ************/
	
	// push method; given a reference (pointer to pointer) to the head of a list, inserts a new character on the front of the list
	public static Character push(Character head_ref, char character) 
	{
		Character newChar = new Character(character);// constructor takes character
		newChar.setNextChar(head_ref);// next character is the updated head of the list
		if(head_ref !=null) 
		{// if head is not equal to null, run the following if statement
			head_ref.setPreviousChar(newChar);// set previous character 
			head_ref = newChar;// the head is the new character
		}
		return head_ref;// return the head of the list
	}// push method
	
	// checkPalindrome Method; check to see if user's input is a palindrome or not
	public static boolean checkPalindrome(String word) 
    {
        // Linked List
		Character head = new Character(word.charAt(0));// get user's input's first character and store it as the head 
        for (int i=1; i < word.length(); i++) 
        {// for i = 1, i is less than the length of user's input, increment i by 1
        	head = push(head, word.charAt(i));// call push method to set new head in the list
        }// for loop 
        
        if(head==null) 
        {// if character stored at head is equal to null, nothing is in the list, run the following statement
        	return true;// user's input is a palindrome
        }// if statement
        
        Character end = head;// set end character to head
        while(end.getNext()!=null) 
        {// looping until we get to the end of doubly linked list by continiously comparing start and end until we reach end of both sides or until both sides dont equal eachother
        	end = end.getNext();// get next character
        }// while loop
        
        while(end!=head) 
        {// while character stored in end is not equal to character stored in head, run while loop
        	if(end.getWord()!= head.getWord()) 
        	{// if end character is not equal to head character, run the following if statement
        		//System.out.println("end letter: "+ end.getWord());
        		return false;// user's input is NOT a palindrome
        	}// if statement
        	
        	//System.out.println("start letter: " + head.getWord());
        	head = head.getNext();// get next character and store it as the head
        	end = end.getPrevious();// get previous character and store it as end
        }// while loop
        
        return true;// user's word is a palindrome 
    } // checkPalindrome method
	
}// GUI class
