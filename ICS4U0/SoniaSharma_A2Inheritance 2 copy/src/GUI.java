/*
 *  *********** Assignment Information **********
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: A2 Inheritance 
 * Due Date: March 7th, 2022
 * Description: This GUI program is designed to build a character from 3 classes/character types; Sage, Yoru, and Skye with its respective abilities.
 * This program allows the user to add a character from the 3 character types, view characters saved, edit characters saved, and delete characters. Make sure to QUIT program to save data.
 * 
 * *********** Assignment Concepts **********
 * Add: lines 123-125(declaration), 317-336, 379-424(save btn) in GUI.java file
 * 
 * Edit: lines 146-154(declaration), 514-634(including select edit and save edit btn) in GUI.java file
 * 
 * Delete: lines 156-161(declaration), 636-686 (including select delete btn) in GUI.java file
 * 
 * View: lines 139-144(declaration), 426-512(including select view btn) in GUI.java file
 * 
 * text file: CharactersCreationList.txt. (read file from lines 96, 811-830), (write file from lines 702, 832-890)
 * 
 * inheritance: all lines in following objects 
 * - base class is BaseCharacter (Parent Class)
 * - BaseCharacter's childs are Sage and Yoru  (Child Classes) (Sub classes)
 * - Yoru's child is Skye (Grandchild Class) (Sub Sub class)
 * 
 * overload: line 15 in Sage.java, Yoru.java, and Skye.java
 * 
 * override: lines 41-46 in Sage.java file, lines 43-48 in Yoru.java file, lines 43-48 in Skye.java file
 * 
 * array of records: Line 72 in GUI.java file. Used an array to store all characters and their abilities in GUI.java file
 * 
 * creation and usage of objects: 
 * - Lines 9-69 in BaseCharacter.java file (Super class aka Parent Class)
 * - Lines 9-39 in Sage.java file (Sub class 1 aka Child Class)
 * - Lines 9-41 in Yoru.java file (sub class 2 aka Child Class)
 * - Lines 9-41 in Skye.java file (sub sub class aka Grandchild Class)
 */

// Import Modules
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// GUI Class
public class GUI extends JFrame 
{
	// Declare GUI Components and Variables
	private static JPanel panel;
	private static JButton startBtn, quitBtn, viewBtn, deleteBtn, editBtn, saveBtn, addBtn;
	private static JButton sageBtn, yoruBtn, skyeBtn, selectViewBtn, selectEditBtn, editSaveBtn, selectDeleteBtn, cancelBtn;
	private static JLabel titleText;
	private static JComboBox<String> viewChar, levelInput, hitPointsInput, healPowInput, resPowInput, supSpeedInput;
	private static JTextField nameInput;
	private static JLabel nameLbl, levelLbl, hitPointsLbl, healPowLbl, resPowLbl, supSpeedLbl;
	private static String classUser, z, editSelection, editSelection1, editSelection2;
	private static int countVar = 0, countNum;
	BaseCharacter characters[] = new BaseCharacter[100]; // array of records which stores all characters and theirabilities
	String[] nameView = new String[100];

	// Main Method
	public static void main(String[] args) throws IOException
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
	} // main method

	public GUI() 
	{
		read(); // run read file method

		/*********** DECLARATION OF GUI COMPONENTS ************/

		// GUI Program
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 437, 406);
		panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(new Color(245, 245, 245));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		// Buttons; start, quit, cancel, add, sage, yoru, skye. view, selectView, edit, selectEdit, editSave, delete, selectDelete
		startBtn = new JButton("START GAME");
		startBtn.setBounds(67, 90, 117, 29);
		panel.add(startBtn);

		quitBtn = new JButton("QUIT GAME");
		quitBtn.setBounds(255, 90, 117, 29);
		panel.add(quitBtn);

		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBounds(250, 320, 117, 29);
		panel.add(cancelBtn);

		addBtn = new JButton("ADD");
		addBtn.setBounds(20, 87, 94, 29);
		panel.add(addBtn);
		sageBtn = new JButton("Sage");
		sageBtn.setBounds(43, 87, 94, 29);
		panel.add(sageBtn);
		yoruBtn = new JButton("Yoru");
		yoruBtn.setBounds(177, 87, 94, 29);
		panel.add(yoruBtn);
		skyeBtn = new JButton("Skye");
		skyeBtn.setBounds(300, 87, 94, 29);
		panel.add(skyeBtn);
		saveBtn = new JButton("SAVE");
		saveBtn.setBounds(88, 320, 117, 29);
		panel.add(saveBtn);

		viewBtn = new JButton("VIEW");
		viewBtn.setBounds(126, 87, 94, 29);
		panel.add(viewBtn);
		selectViewBtn = new JButton("View Character");
		selectViewBtn.setBounds(127, 164, 188, 27);
		panel.add(selectViewBtn);

		editBtn = new JButton("EDIT");
		editBtn.setBounds(220, 87, 94, 29);
		panel.add(editBtn);
		selectEditBtn = new JButton("Edit Character");
		selectEditBtn.setBounds(127, 164, 188, 27);
		panel.add(selectEditBtn);
		editSaveBtn = new JButton("SAVE");
		editSaveBtn.setBounds(88, 320, 117, 29);
		panel.add(editSaveBtn);

		deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(326, 87, 94, 29);
		panel.add(deleteBtn);
		selectDeleteBtn = new JButton("Delete Character");
		selectDeleteBtn.setBounds(127, 164, 188, 27);
		panel.add(selectDeleteBtn);

		/* Text Fields, Labels, and Comboboxes; title, name label, name input , level label, level input, hitpoints label, hitpoints input, healPow label healPow
		 * input, resPow label, resPow input, supSpeed label, supSpeed input, viewChar combobox
		 */
		titleText = new JLabel();
		titleText.setFont(new Font("Monospaced", Font.BOLD, 15));
		titleText.setForeground(new Color(255, 153, 153));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setText("Build Your Valorant Character");
		titleText.setBounds(67, 28, 305, 16);
		panel.add(titleText);

		nameLbl = new JLabel();
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setText("Enter name: ");
		nameLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		nameLbl.setBounds(10, 80, 100, 23);
		panel.add(nameLbl);
		nameInput = new JTextField();
		nameInput.setHorizontalAlignment(SwingConstants.CENTER);
		nameInput.setForeground(Color.BLACK);
		nameInput.setBackground(Color.WHITE);
		nameInput.setText("");
		nameInput.setBounds(120, 80, 146, 23);
		panel.add(nameInput);
		nameInput.setColumns(10);

		levelLbl = new JLabel();
		levelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		levelLbl.setText("Level:");
		levelLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		levelLbl.setBounds(10, 130, 100, 23);
		panel.add(levelLbl);
		levelInput = new JComboBox<String>(); // level combobox
		levelInput.setBounds(120, 130, 146, 23);
		panel.add(levelInput);
		levelInput.addItem("N/A");
		levelInput.addItem("beginner");
		levelInput.addItem("intermediate");
		levelInput.addItem("pro");

		hitPointsLbl = new JLabel();
		hitPointsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		hitPointsLbl.setText("Health:");
		hitPointsLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		hitPointsLbl.setBounds(10, 176, 100, 23);
		panel.add(hitPointsLbl);
		hitPointsInput = new JComboBox<String>(); // hit points combobox
		hitPointsInput.setBounds(120, 176, 146, 23);
		panel.add(hitPointsInput);
		hitPointsInput.addItem("N/A");
		hitPointsInput.addItem("10");
		hitPointsInput.addItem("20");
		hitPointsInput.addItem("30");
		hitPointsInput.addItem("40");
		hitPointsInput.addItem("50");
		hitPointsInput.addItem("60");
		hitPointsInput.addItem("70");
		hitPointsInput.addItem("80");
		hitPointsInput.addItem("90");
		hitPointsInput.addItem("100");

		healPowLbl = new JLabel();
		healPowLbl.setHorizontalAlignment(SwingConstants.CENTER);
		healPowLbl.setText("Heal Powers:");
		healPowLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		healPowLbl.setBounds(10, 220, 100, 23);
		panel.add(healPowLbl);
		healPowInput = new JComboBox<String>(); // heal power combobox
		healPowInput.setBounds(120, 220, 146, 23);
		panel.add(healPowInput);
		healPowInput.addItem("N/A");
		healPowInput.addItem("healing fire");
		healPowInput.addItem("herbalism");
		healPowInput.addItem("healing water");
		healPowInput.addItem("healing vision");
		healPowInput.addItem("healing blast");

		resPowLbl = new JLabel();
		resPowLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resPowLbl.setText("Reserect Powers:");
		resPowLbl.setFont(new Font("Heiti SC", Font.BOLD, 12));
		resPowLbl.setBounds(10, 220, 100, 23);
		panel.add(resPowLbl);
		resPowInput = new JComboBox<String>(); // res power combobox
		resPowInput.setBounds(120, 220, 146, 23);
		panel.add(resPowInput);
		resPowInput.addItem("N/A");
		resPowInput.addItem("conversion res");
		resPowInput.addItem("infinite res");
		resPowInput.addItem("adaptive res");

		supSpeedLbl = new JLabel();
		supSpeedLbl.setHorizontalAlignment(SwingConstants.CENTER);
		supSpeedLbl.setText("Super Speed:");
		supSpeedLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		supSpeedLbl.setBounds(10, 260, 100, 23);
		panel.add(supSpeedLbl);
		supSpeedInput = new JComboBox<String>(); // super speed combobox
		supSpeedInput.setBounds(120, 260, 146, 23);
		panel.add(supSpeedInput);
		supSpeedInput.addItem("N/A");
		supSpeedInput.addItem("100");
		supSpeedInput.addItem("200");
		supSpeedInput.addItem("300");
		supSpeedInput.addItem("400");

		viewChar = new JComboBox<String>(); // view character combobox
		viewChar.setMaximumRowCount(10);
		viewChar.setBounds(127, 117, 188, 27);
		panel.add(viewChar);

		// Setup; set components to invisible until user selects option to start or quit the program
		startBtn.setVisible(true);
		quitBtn.setVisible(true);
		titleText.setVisible(true);

		selectEditBtn.setVisible(false);
		selectDeleteBtn.setVisible(false);
		selectViewBtn.setVisible(false);
		viewChar.setVisible(false);
		addBtn.setVisible(false);
		editBtn.setVisible(false);
		deleteBtn.setVisible(false);
		viewBtn.setVisible(false);
		saveBtn.setVisible(false);
		editSaveBtn.setVisible(false);
		sageBtn.setVisible(false);
		yoruBtn.setVisible(false);
		skyeBtn.setVisible(false);
		nameLbl.setVisible(false);
		nameInput.setVisible(false);
		levelLbl.setVisible(false);
		levelInput.setVisible(false);
		hitPointsLbl.setVisible(false);
		hitPointsInput.setVisible(false);
		healPowLbl.setVisible(false);
		healPowInput.setVisible(false);
		resPowLbl.setVisible(false);
		resPowInput.setVisible(false);
		supSpeedLbl.setVisible(false);
		supSpeedInput.setVisible(false);
		cancelBtn.setVisible(false);

		/*********** BUTTONS ************/

		// Start Button; allows the game to run
		startBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) // if user selects start button, run the following code
			{
				menu(); // call menu method
			}
		}); // start btn

		// Add Button; displays character types and allows users to add character to the game
		addBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects add button, run the following code
			{
				titleText.setFont(new Font("Monospaced", Font.BOLD, 16));
				titleText.setText("Character Type");
				titleText.setHorizontalAlignment(SwingConstants.CENTER);
				titleText.setBounds(20, 31, 400, 16);
				addBtn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				viewBtn.setVisible(false);
				sageBtn.setVisible(true);
				yoruBtn.setVisible(true);
				skyeBtn.setVisible(true);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(false);
			}
		}); // add btn

		// Sage Btn; allows user to add abilities with respect to the class object's information
		sageBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects Sage as character type, run folllowing code
			{
				charSelected(); // call charSelected method
				classUser = ("Sage Selected");
				// System.out.println(classUser);
				healPowLbl.setVisible(true);
				healPowInput.setVisible(true);
			}
		}); // Sage btn

		// Yoru Btn; allows user to add abilities with respect to the class object's information
		yoruBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects Yoru as character type, run folllowing code
			{
				charSelected(); // call charSelected method
				classUser = ("Yoru Selected");
				// System.out.println(classUser);
				resPowLbl.setVisible(true);
				resPowInput.setVisible(true);
			}
		}); // Yoru Btn

		// Skye Btn; allows user to add abilities respect to the class object's information
		skyeBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects Skye as character type, run folllowing code
			{
				charSelected(); // call charSelected method
				classUser = ("Skye Selected");
				// System.out.println(classUser);
				resPowLbl.setVisible(true);
				resPowInput.setVisible(true);
				supSpeedLbl.setVisible(true);
				supSpeedInput.setVisible(true);
			}
		}); // Skye Btn

		// Save Btn; saves user's choices of abilities for character created
		saveBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) // if user selects save button, run the following code
			{
				if (classUser == "Sage Selected") // if Sage is selected, run the following condition
				{
					String nameVar = nameInput.getText(); // get character's name
					String levelVar = (String) levelInput.getSelectedItem(); // get character's chosen level
					String hitPointsVar = (String) hitPointsInput.getSelectedItem(); // get character's hitPoints
					String healPowVar = (String) healPowInput.getSelectedItem(); // get character's heal power
					// System.out.println("Sage Saved");
					// System.out.println(nameVar + ";" +levelVar + ";" + hitPointsVar+";" + healPowVar);
					characters[countVar] = new Sage(nameVar, levelVar, hitPointsVar, healPowVar); // store character's data at index stored in countVar
					countVar++; // increment character count
				} // if bracket

				if (classUser == "Yoru Selected") // if yoru is selected, run the following condition
				{
					String nameVar = nameInput.getText(); // get character's name
					String levelVar = (String) levelInput.getSelectedItem(); // get character's chosen level
					String hitPointsVar = (String) hitPointsInput.getSelectedItem(); // get character's chosen hit
																						// points
					String resPowVar = (String) resPowInput.getSelectedItem(); // get character's chosen res power
					// System.out.println("Yoru Saved");
					// System.out.println(nameVar + ";" +levelVar + ";" + hitPointsVar +";" + resPowVar);
					characters[countVar] = new Yoru(nameVar, levelVar, hitPointsVar, resPowVar); // store character's data at index stored in countVar
					countVar++; // increment character count
				} // if bracket

				if (classUser == "Skye Selected") // if skye is selected, run the following condition
				{
					String nameVar = nameInput.getText(); // get character's name
					String levelVar = (String) levelInput.getSelectedItem(); // get character's chosen level
					String hitPointsVar = (String) hitPointsInput.getSelectedItem(); // get character's chosen hitpoints
					String resPowVar = (String) resPowInput.getSelectedItem(); // get character's chosen res power
					String supSpeedVar = (String) supSpeedInput.getSelectedItem(); // get character's chosen super speed
					// System.out.println("Skye Saved");
					// System.out.println(nameVar + ";" +levelVar + ";" + hitPointsVar+";" + resPowVar + ";" + supSpeedVar);
					characters[countVar] = new Skye(nameVar, levelVar, hitPointsVar, resPowVar, supSpeedVar); // store character's data at index stored in countVar
					countVar++; // increment character count
				} // if bracket

				menu(); // call menu method
			}
		}); // save btn

		// View Btn; allows user choose a saved character stored in viewChar
		// combobox
		viewBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects view button, run the following code
			{
				titleText.setText("Select a Character to View");
				addBtn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				viewBtn.setVisible(false);
				viewChar.setVisible(true);
				selectViewBtn.setVisible(true);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				viewChar.removeAllItems();
				nameView = new String[100];
				for (int i = 0; i < countVar; i++) 
				{
					nameView[i] = characters[i].getName(); // get user's choice of character they'd like to view and store it at index of i
					viewChar.addItem(nameView[i]); // retrieve user's choice of character from combobox
					// System.out.println(nameView[i]);
				} // for loop bracket
			}
		}); // view btn

		// Select View Btn; allows user to view chosen character's abilities but doesnt allow them to edit or modify characters
		selectViewBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects a character to view, run the following code
			{
				editSelection = viewChar.getSelectedItem().toString(); // store user's selection of character to view
				selectViewBtn.setVisible(false);
				cancelBtn.setVisible(true);
				quitBtn.setVisible(false);
				titleText.setText("Viewing " + editSelection); // display's character being viewed
				for (int i = 0; i < countVar; i++) 
				{
					if (editSelection == characters[i].getName()) 
					{ // if user's selected character matches index at which character was stored at, run the following condition
						if (characters[i] instanceof BaseCharacter) 
						{ // if user's selected character belongs to BaseCharacter class (which will always be true), run the following condition
							viewChar.setVisible(false);
							selectViewBtn.setVisible(false);
							nameLbl.setVisible(true);
							nameInput.setVisible(true);
							levelLbl.setVisible(true);
							levelInput.setVisible(true);
							hitPointsLbl.setVisible(true);
							hitPointsInput.setVisible(true);
							nameInput.setEditable(false);
							nameInput.setEnabled(false);
							levelInput.setEnabled(false);
							hitPointsInput.setEnabled(false);
							nameInput.setText(((BaseCharacter) characters[i]).getName()); // get chosen character's name
							levelInput.setSelectedItem(((BaseCharacter) characters[i]).getLevel()); // get chosen character's level
							hitPointsInput.setSelectedItem(((BaseCharacter) characters[i]).getHitPoints()); // get chosen character;s hitpoints
						} // if statement

						if (characters[i] instanceof Sage) 
						{ // if user's selected character belongs to Sage class, run the following condition
							healPowLbl.setVisible(true);
							healPowInput.setVisible(true);
							healPowInput.setEnabled(false);
							healPowInput.setSelectedItem(((Sage) characters[i]).getHealPow()); // get chosen character's heal power
						} // if statement

						if (characters[i] instanceof Yoru) 
						{ // if user's selected character belongs to Yoru class, run the following condition
							resPowLbl.setVisible(true);
							resPowInput.setVisible(true);
							resPowInput.setEnabled(false);
							resPowInput.setSelectedItem(((Yoru) characters[i]).getResPow()); // get chosen character's res power
						} // if statement

						if (characters[i] instanceof Skye) 
						{ // if user's selected character belongs to Skye, run the following condition
							supSpeedLbl.setVisible(true);
							supSpeedInput.setVisible(true);
							supSpeedInput.setEnabled(false);
							supSpeedInput.setSelectedItem(((Skye) characters[i]).getSupSpeed()); // get chosen character's super speed
						} // if statement
						
					}//if statement
				}// for loop
			}
		}); // select view btn

		// Edit Btn; allows user to select saved character from combobox to edit
		editBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects edit button, run the following code
			{
				titleText.setText("Select a Character to Edit");
				addBtn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				viewBtn.setVisible(false);
				viewChar.setVisible(true);
				selectEditBtn.setVisible(true);
				viewChar.removeAllItems();
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				nameView = new String[100];
				for (int i = 0; i < countVar; i++) 
				{
					nameView[i] = characters[i].getName(); // get user's choice of character they'd like to edit and store it at index of i
					viewChar.addItem(nameView[i]); // retrieve user's choice of character from combobox
					// System.out.println(nameView[i]);
				}// for loop
				editSelection1 = viewChar.getSelectedItem().toString(); // store user's selection of character to edit
			}
		});

		// Select Edit Btn; allows user to modify character's abilities execept for character's name
		selectEditBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects selectEditBtn, run following code
			{
				editSelection1 = viewChar.getSelectedItem().toString(); // store user's selection of character to edit
				selectEditBtn.setVisible(false);
				editSaveBtn.setVisible(true);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				titleText.setText("Editing " + editSelection1); // display's character being edited
				for (int i = 0; i < countVar; i++) 
				{
					if (editSelection1 == characters[i].getName()) 
					{ // if user's selected character matches index at which character was stored at, run the following condition
						if (characters[i] instanceof BaseCharacter) 
						{ // if user's selected character belongs to BaseCharacter class (which will always be true), run the following condition
							viewChar.setVisible(false);
							selectEditBtn.setVisible(false);
							nameLbl.setVisible(true);
							nameInput.setVisible(true);
							levelLbl.setVisible(true);
							levelInput.setVisible(true);
							hitPointsLbl.setVisible(true);
							hitPointsInput.setVisible(true);
							nameInput.setEditable(false);
							nameInput.setText(((BaseCharacter) characters[i]).getName()); // get chosen character's name
							levelInput.setSelectedItem(((BaseCharacter) characters[i]).getLevel()); // get chosen character's level
							hitPointsInput.setSelectedItem(((BaseCharacter) characters[i]).getHitPoints()); // get chosen character's hitpoints
							countNum = i; // set countNum variable to index value of "i"
						} // if bracket

						if (characters[i] instanceof Sage) 
						{ // if user's selected character belongs to Sage class, run the following condition
							healPowLbl.setVisible(true);
							healPowInput.setVisible(true);
							healPowInput.setSelectedItem(((Sage) characters[i]).getHealPow()); // get chosen character's heal power
							countNum = i; // set countNum variable to index value of "i"
						} // if bracket

						if (characters[i] instanceof Yoru) 
						{ // if user's selected character belongs to Yoru class, run the following condition
							resPowLbl.setVisible(true);
							resPowInput.setVisible(true);
							resPowInput.setSelectedItem(((Yoru) characters[i]).getResPow()); // get chosen character's res power
							countNum = i; // set countNum variable to index value of "i"
						} // if bracket

						if (characters[i] instanceof Skye) 
						{ // if user's selected character belongs to Skye class, run the following condition
							supSpeedLbl.setVisible(true);
							supSpeedInput.setVisible(true);
							supSpeedInput.setSelectedItem(((Skye) characters[i]).getSupSpeed()); // get chosen character's super speed
							countNum = i; // set countNum variable to index value of "i"
						} // if bracket
					} // if bracket
				} // for loop bracket
			}
		}); // select edit btn

		// Edit Save Button; allows user to save any changes made to a character
		editSaveBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (characters[countNum] instanceof BaseCharacter) 
				{ // if user's modified character belongs to BaseCharacter class (which is always true), run the following condition
					editSaveBtn.setVisible(false);
					String newLevel = (String) levelInput.getSelectedItem(); // get new level
					String newHitPoints = (String) hitPointsInput.getSelectedItem(); // get new hitpoints
					((BaseCharacter) characters[countNum]).setLevel(newLevel); // set charatcer's level to new level
					((BaseCharacter) characters[countNum]).setHitPoints(newHitPoints); // set character's hitpoints to new hitpoints
				} // if bracket

				if (characters[countNum] instanceof Sage) 
				{ // if user's modified character belongs to Sage class, run the following condition
					String newHealPow = (String) healPowInput.getSelectedItem(); // get new heal power
					((Sage) characters[countNum]).setHealPow(newHealPow); // set character's heal power to new heal power
				} // if bracket

				if (characters[countNum] instanceof Yoru) 
				{ // if user's modified character belongs to Yoru class, run the following condition
					String newResPow = (String) resPowInput.getSelectedItem(); // get new res power
					((Yoru) characters[countNum]).setResPow(newResPow); // set charater's res power to new res power
				} // if bracket

				if (characters[countNum] instanceof Skye) 
				{// if user's modified character belongs to Skye class, run the following condition
					String newSupSpeed = (String) supSpeedInput.getSelectedItem(); // get new super speed
					((Skye) characters[countNum]).setSupSpeed(newSupSpeed); // set character's super speed to new super speed
				} // if bracket

				menu(); // call menu method
			}
		}); // edit save btn

		// Delete Button; allows user to choose a character to delete from combobox
		deleteBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects delete button, run the following code
			{
				titleText.setText("Select a Character to Delete");
				addBtn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				viewBtn.setVisible(false);
				viewChar.setVisible(true);
				selectDeleteBtn.setVisible(true);
				viewChar.removeAllItems();
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				nameView = new String[100];
				for (int i = 0; i < countVar; i++) 
				{
					nameView[i] = characters[i].getName(); // get user's choice of character they'd like to delete and store it at index of i
					viewChar.addItem(nameView[i]); // retrieve user's choice of character from combobox
					// System.out.println(nameView[i]);
				}
				editSelection2 = viewChar.getSelectedItem().toString(); // store user's selection of character to delete
			}
		}); // delete btn

		// Select Delete Btn; allows user to delete selected character from the game
		selectDeleteBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects confirmation delete button, run the
			// following code
			{
				selectDeleteBtn.setVisible(false);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				editSelection2 = viewChar.getSelectedItem().toString(); // store user's selection of character to delete
				for (int j = 0; j < countVar; j++) 
				{
					if (editSelection2 == characters[j].getName()) 
					{ // retrieve character's saved data and if user's option matches at that index, run the following condition
						// System.out.println(j);
						for (int i = j; i < countVar; i++) 
						{
							characters[i] = characters[i + 1]; // add 1 to character's position
						}
						countVar--; // decrement character count
					}
				}
				menu(); // call menu method
			}
		}); // selects delete btn

		// Cancel Btn; allows user to cancel which leads them back to the menu and doesnt save any changes made before user selects button
		cancelBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) // if user selects cancel button, run the following code
			{
				menu(); // call menu method
			}
		}); // cancel btn

		// Quit Button; allows user to quit the program
		quitBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) // if user selects the quit button, run the following code
			{
				write(); // calls to write method
				System.exit(0); // exit program
			}
		}); // quit btn

	} // GUI method

	// Menu Method; this method displays the menu interface whenever user starts the game, saves a character, or chooses to cancel
	public static void menu() {
		startBtn.setVisible(false);
		addBtn.setVisible(true);
		editBtn.setVisible(true);
		deleteBtn.setVisible(true);
		cancelBtn.setVisible(false);
		viewBtn.setVisible(true);
		titleText.setFont(new Font("Poppins", Font.BOLD, 16));
		titleText.setText("Menu");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setBounds(20, 31, 400, 16);
		quitBtn.setBounds(150, 320, 117, 29);
		selectDeleteBtn.setVisible(false);
		selectViewBtn.setVisible(false);
		viewChar.setVisible(false);
		saveBtn.setVisible(false);
		sageBtn.setVisible(false);
		yoruBtn.setVisible(false);
		skyeBtn.setVisible(false);
		nameLbl.setVisible(false);
		nameInput.setVisible(false);
		levelLbl.setVisible(false);
		levelInput.setVisible(false);
		hitPointsLbl.setVisible(false);
		hitPointsInput.setVisible(false);
		healPowLbl.setVisible(false);
		healPowInput.setVisible(false);
		resPowLbl.setVisible(false);
		resPowInput.setVisible(false);
		supSpeedLbl.setVisible(false);
		supSpeedInput.setVisible(false);
		editSaveBtn.setVisible(false);
		selectEditBtn.setVisible(false);
		nameInput.setEditable(true);
		nameInput.setText(" ");
		levelInput.setSelectedItem("N/A"); // sets default option to N/A if user doesn't select an item
		hitPointsInput.setSelectedItem("N/A"); // sets default option to N/A if user doesn't select an item
		resPowInput.setSelectedItem("N/A"); // sets default option to N/A if user doesn't select an item
		supSpeedInput.setSelectedItem("N/A"); // sets default option to N/A if user doesn't select an item
		healPowInput.setSelectedItem("N/A"); // sets default option to N/A if user doesn't select an item
		nameInput.setEnabled(true);
		levelInput.setEnabled(true);
		hitPointsInput.setEnabled(true);
		healPowInput.setEnabled(true);
		resPowInput.setEnabled(true);
		supSpeedInput.setEnabled(true);
		hitPointsInput.removeItem(z);
		quitBtn.setVisible(true);
	} // menu method

	// Character selected method; when user selects a character type, run the following method
	public void charSelected() {
		titleText.setText("Abilities");
		saveBtn.setVisible(true);
		addBtn.setVisible(false);
		editBtn.setVisible(false);
		deleteBtn.setVisible(false);
		viewBtn.setVisible(false);
		sageBtn.setVisible(false);
		yoruBtn.setVisible(false);
		skyeBtn.setVisible(false);
		nameLbl.setVisible(true);
		nameInput.setVisible(true);
		levelLbl.setVisible(true);
		levelInput.setVisible(true);
		hitPointsLbl.setVisible(true);
		hitPointsInput.setVisible(true);
		quitBtn.setVisible(false);
		cancelBtn.setVisible(true);
	} // chararacter selected method

	/*********** ASSIGNMENT CONCEPTS ************/

	// Records method
	public BaseCharacter records(String line) 
	{

		String[] storage = line.split(";");// split data
		String type = storage[0]; // first value will equal type string value
		if (type.equals("sage")) // if type value is sage, run the following condition
		{
			characters[countVar] = new Sage(storage[1], storage[2], storage[3], storage[4]); // display saved data for character type Sage
			countVar++; // increment countVar
		} // if statement

		else if (type.equals("yoru")) // else if type value is yoru, run the following condition
		{
			characters[countVar] = new Yoru(storage[1], storage[2], storage[3], storage[4]); // display saved data for character type Yoru
			countVar++; // increment countVar
		} // else if statement

		else if (type.equals("skye")) // else if type value is skye, run the following condition
		{
			characters[countVar] = new Skye(storage[1], storage[2], storage[3], storage[4], storage[5]); // display saved data for character type Skye
			countVar++; // increment countVar
		} // else if statement

		return null; // return null value

	} // records method

	// Read File Method
	public void read() 
	{ // reads the file
		String line; // to read line by line
		BufferedReader input;
		try {
			input = new BufferedReader(new FileReader("CharactersCreatedList.txt")); // input reads file
			line = input.readLine(); // reads first line from file
			while (line != null) { // while the last line read is not empty, run the following while loop
				// System.out.println(line);// prints first line into console
				records(line); // calls records method
				line = input.readLine(); // reads & stores line
			} // while bracket
			input.close(); // close reader
		} catch (Exception e) // if above code fails, catch the exception
		{
			e.printStackTrace();
			// System.out.println("There's an error!"); // print error message
		}
	} // read method

	// Write File Method
	public void write() 
	{
		try {
			PrintWriter save; // data to write in file using PrintWriter
			save = new PrintWriter(new FileWriter("CharactersCreatedList.txt")); // text file inputs to notepad

			for (int j = 0; j < countVar; j++) 
			{
				if (characters[j].getClass() == Sage.class) // if character is an instance of Sage class, run the following condition
				{
					save.print("sage");
					save.print(";"); // split data
					save.print(characters[j].getName());// get character's name
					save.print(";"); // split data
					save.print(characters[j].getLevel());// get character's level
					save.print(";"); // split data
					save.print(characters[j].getHitPoints());// get character's hitpoints
					save.print(";"); // split data
					save.print(((Sage) characters[j]).getHealPow()); // add healPow
				} // if statement

				if (characters[j].getClass() == Yoru.class) // if character is an instance of Yoru class, run the following condition
				{
					save.print("yoru");
					save.print(";"); // split data
					save.print(characters[j].getName());// get character's name
					save.print(";"); // split data
					save.print(characters[j].getLevel());// get character's level
					save.print(";"); // split data
					save.print(characters[j].getHitPoints());// get character's hitpoints
					save.print(";"); // split data
					save.print(((Yoru) characters[j]).getResPow());// get character's resPow
				} // if statement

				if (characters[j].getClass() == Skye.class) // if character is an instance of Skye class, run the following condition
				{
					save.print("skye");
					save.print(";"); // split data
					save.print(characters[j].getName());// get character's name
					save.print(";"); // split data
					save.print(characters[j].getLevel());// get character's level
					save.print(";"); // split data
					save.print(characters[j].getHitPoints());// get character's hitpoints
					save.print(";"); // split data
					save.print(((Skye) characters[j]).getResPow());// get character's resPow
					save.print(";"); // split data
					save.print(((Skye) characters[j]).getSupSpeed());// get character's super speed
				} // if statement

				save.println("");
			} // for loop

			save.close(); // close writer
		} catch (Exception e) // catch the exception if above code fails
		{
			System.out.println("Error!"); // print error message
		}
	} // write method

} // GUI class
