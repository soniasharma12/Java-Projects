/*
 *  *********** Assignment Information **********
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: V2 Sort and Search Algorithms
 * Due Date: March 28th, 2022
 * Description: This program is a student data base which retrieves students'
 * name, unique ID, and grade from the user and saves the student. This program
 * uses an insertion sort algorithm to keep Student IDs sorted and a binary
 * search algorithm to add a new student and find the matching record when user has to edit, or
 * delete students
 *
 * *********** Assignment Concepts **********
 * Sorting Code: sortInserted method and insertionSort; lines 608-634 in GUI.java file
 * - saveBtn; lines(s) 261
 * - editSaveBtn; lines(s) 399
 * - selectDeleteBtn; lines(s) 458
 * 
 * Binary Search Code: binarySearch method  and checkStudent method; lines 636-675 in GUI.java file
 * - checkIdAddBtn; lines(s) 220
 * - checkIdEditBtn; lines(s) 349
 * - selectEditBtn; lines(s) 341, 354
 * - selectDeleteBtn; lines(s) 432, 434
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
	private static JButton startBtn, quitBtn, deleteBtn, editBtn, saveBtn, addBtn, checkIdAddBtn, checkIdEditBtn;
	private static JButton selectViewBtn, selectEditBtn, editSaveBtn, selectDeleteBtn, cancelBtn;
	private static JLabel titleText, promptLbl;
	private static JComboBox<String> gradeInput;
	private static JTextField nameInput;
	private static JLabel nameLbl, studentIdLbl, gradeLbl;
	private static int countVar = 0, countNum=0;
	static Student students[] = new Student[100]; // array of records which stores all students and their information
	private static JTextField studentIdInput; // student id input when user adds student
	private static JTextField checkStudentIdInput; // student id input when user edits/deletes student

	// Main Method
	public static void main(String[] args) throws IOException 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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

		// Buttons
		quitBtn = new JButton("QUIT");
		quitBtn.setBounds(255, 90, 117, 29);
		panel.add(quitBtn);

		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBounds(250, 320, 117, 29);
		panel.add(cancelBtn);

		addBtn = new JButton("ADD");
		addBtn.setBounds(49, 90, 94, 29);
		panel.add(addBtn);
		saveBtn = new JButton("SAVE");
		saveBtn.setBounds(88, 320, 117, 29);
		panel.add(saveBtn);

		/*selectViewBtn = new JButton("View Student");
		selectViewBtn.setBounds(127, 164, 188, 27);
		panel.add(selectViewBtn);*/

		editBtn = new JButton("EDIT");
		editBtn.setBounds(172, 90, 94, 29);
		panel.add(editBtn);
		selectEditBtn = new JButton("EDIT STUDENT");
		selectEditBtn.setBounds(127, 164, 188, 27);
		panel.add(selectEditBtn);
		editSaveBtn = new JButton("SAVE");
		editSaveBtn.setBounds(88, 320, 117, 29);
		panel.add(editSaveBtn);

		deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(313, 90, 94, 29);
		panel.add(deleteBtn);
		selectDeleteBtn = new JButton("DELETE STUDENT");
		selectDeleteBtn.setBounds(127, 164, 188, 27);
		panel.add(selectDeleteBtn);

		// Text Fields, Labels, and Comboboxes
		titleText = new JLabel();
		titleText.setFont(new Font("Monospaced", Font.BOLD, 15));
		titleText.setForeground(new Color(255, 153, 153));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setText("Student Data Base");
		titleText.setBounds(67, 28, 305, 16);
		panel.add(titleText);

		nameLbl = new JLabel();
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setText("Name:");
		nameLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		nameLbl.setBounds(10, 80, 100, 23);
		panel.add(nameLbl);
		nameInput = new JTextField(); // name textfield
		nameInput.setHorizontalAlignment(SwingConstants.CENTER);
		nameInput.setForeground(Color.BLACK);
		nameInput.setBackground(Color.WHITE);
		nameInput.setText("");
		nameInput.setBounds(120, 80, 146, 23);
		panel.add(nameInput);
		nameInput.setColumns(10);

		studentIdLbl = new JLabel();
		studentIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		studentIdLbl.setText("Student ID:");
		studentIdLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		studentIdLbl.setBounds(10, 130, 100, 23);
		panel.add(studentIdLbl);
		studentIdInput = new JTextField(); // student ID textfield
		studentIdInput.setBounds(126, 131, 140, 21);
		panel.add(studentIdInput);
		studentIdInput.setColumns(10);

		gradeLbl = new JLabel();
		gradeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gradeLbl.setText("Grade:");
		gradeLbl.setFont(new Font("Heiti SC", Font.BOLD, 13));
		gradeLbl.setBounds(10, 176, 100, 23);
		panel.add(gradeLbl);
		gradeInput = new JComboBox<String>(); // grade combobox
		gradeInput.setBounds(120, 176, 146, 23);
		panel.add(gradeInput);
		gradeInput.addItem("9");
		gradeInput.addItem("10");
		gradeInput.addItem("11");
		gradeInput.addItem("12");

		checkIdAddBtn = new JButton("CHECK ID");// check ID label
		checkIdAddBtn.setBounds(172, 214, 94, 29);
		panel.add(checkIdAddBtn);
		checkStudentIdInput = new JTextField(); // checks student ID for edit and delete
		checkStudentIdInput.setBounds(155, 115, 130, 26);
		panel.add(checkStudentIdInput);
		checkStudentIdInput.setColumns(10);

		checkIdEditBtn = new JButton("CHECK ID");
		checkIdEditBtn.setBounds(157, 214, 147, 29);
		panel.add(checkIdEditBtn);

		promptLbl = new JLabel(" ");
		promptLbl.setHorizontalAlignment(SwingConstants.CENTER);
		promptLbl.setBounds(127, 255, 199, 16);
		panel.add(promptLbl);

		// Setup; call menu method to display menu of student database
		menu();

		/*********** BUTTONS ************/

		// Add Button; displays character types and allows users to add student to the database
		addBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects add button, run the following code
			{
				studentSelected(); // call char selected method
			}
		}); // add btn

		// Check Id Add Button; check's if added student's student ID already exists or is invalid
		checkIdAddBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String newStudentId = studentIdInput.getText();// store added student's id into a variable
				String newName = nameInput.getText();// store added student's name into a variable
				if(!newStudentId.equals("") && !newName.equals("") && newStudentId.matches("^[0-9]+$"))
				{// if the student Id input and name input are NOT empty and student ID is a numeric input, run the following if statement
					if(!checkStudent(Integer.parseInt(newStudentId)))
					{// if student ID already exists through binary search, run the following if statement
						//System.out.println("ID Already Saved");
						promptLbl.setVisible(true);
						promptLbl.setText("Student ID Already Exists");// tell user that student already exists 
						saveBtn.setEnabled(false);// dont allow user to save student
						studentIdInput.setText(null);// clear student ID input
					} 
					else
					{// else, if check is true, student ID does not exist through binary search and may save the student, run the following else statement
						//System.out.println("ID passes test");
						promptLbl.setVisible(true);
						promptLbl.setText("Valid ID");
						studentIdInput.setEditable(false);
						checkIdAddBtn.setEnabled(false);
						nameInput.setEditable(false);
						gradeInput.setEnabled(false);
						saveBtn.setEnabled(true);// allow user to save student
					}
				}
				else 
				{// else, if user's input in name and student ID text field are empty or student ID is not a number, run the following else statement
					//System.out.println("ID Invalid");
					promptLbl.setVisible(true);
					promptLbl.setText("Invalid ID");
					saveBtn.setEnabled(false);
					studentIdInput.setText(null);// clear student ID input
					nameInput.setText(null);// clear name input
				}
			}
		});

		// Save Btn; saves student information selected
		saveBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent arg0)// if user selects save button, run the following code
			{
				String nameVar = nameInput.getText();// get students's name and store it in a variable
				String studentIdVar =(String)studentIdInput.getText(); // get students's ID and store it in a variable
				String gradeVar = (String)gradeInput.getSelectedItem(); // get student's grade and store it in a variable
				Student student = new Student(nameVar, Integer.parseInt(studentIdVar),Integer.parseInt(gradeVar));// save student's information
				sortInserted(student);// insert student sorted into the array
				countVar++;// increment countVar   
				menu();// call menu method
			}
		}); // save btn

		// Edit Btn; allows user to enter a student ID inorder to edit an existing student's info
		editBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)// if user selects edit button, run the following code
			{
				titleText.setText("Enter Student ID to Edit");
				addBtn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				selectEditBtn.setVisible(true);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				checkStudentIdInput.setVisible(true);// allow user to type in student ID and check to see if it exists or not
			}
		});
		
		// Select Edit Btn; if student exists, allow user to modify student's info 
		selectEditBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects selectEditBtn, run following code
			{
				String newStudentId = checkStudentIdInput.getText();// get student's ID from input and store it in a variable
				selectEditBtn.setVisible(false);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				studentIdInput.setEnabled(true);
				checkIdEditBtn.setVisible(true);
				checkIdEditBtn.setEnabled(true);
				editSaveBtn.setEnabled(false);
				if (newStudentId.matches("^[0-9]+$")) 
				{// if student ID is numeric, run the following if statement
					if(!checkStudent(Integer.parseInt(newStudentId))) 
					{// if student ID exists, run the following if statement
						editSaveBtn.setVisible(true);
						editSaveBtn.setEnabled(false);
						promptLbl.setVisible(false);
						checkIdEditBtn.setEnabled(true);
						checkStudentIdInput.setVisible(false);
						selectEditBtn.setVisible(false);
						nameLbl.setVisible(true);
						nameInput.setVisible(true);
						studentIdLbl.setVisible(true);
						studentIdInput.setVisible(true);
						gradeLbl.setVisible(true);
						gradeInput.setVisible(true);
						studentIdInput.setEditable(true);
						int i = binarySearch(Integer.parseInt(newStudentId));// binary search new student ID and store it in a variable
						nameInput.setText((students[i]).getName());// get chosen student's name
						studentIdInput.setText(String.valueOf((students[i]).getStudentId()));// get chosen student's ID
						gradeInput.setSelectedItem((students[i]).getGrade());// get chosen student's grade
					}
					else 
					{// else, if binary search fails, student is not saved in data base and therefore does not exist
						promptLbl.setVisible(true);
						promptLbl.setText("Student Does Not Exist");
						selectEditBtn.setVisible(true);
						checkStudentIdInput.setText(null);
						checkIdEditBtn.setVisible(false);
						//System.out.println("Cannot Find Student Id");
					}	
				}  
				else 
				{// else, if user's input in name and student ID text field are empty or student ID is not a number, run the following else statement
					//System.out.println("ID Invalid");
					promptLbl.setVisible(true);
					promptLbl.setText("Invalid ID");
					checkStudentIdInput.setText(null);// clear student ID input
					selectEditBtn.setVisible(true);
					checkIdEditBtn.setVisible(false);
				}
			}
		}); // select edit btn
		
		// Check Id Edit Button; checks if edited student's new student id is valid or not
		checkIdEditBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String newStudentId = studentIdInput.getText();// store added student's id into a variable
				String newName = nameInput.getText();// store added student's name into a variable
				if(!newStudentId.equals("") && !newName.equals("") && newStudentId.matches("^[0-9]+$"))
				{// if the student Id input and name input are NOT empty and student ID is a numeric input, run the following if statement
					if(!checkStudent(Integer.parseInt(newStudentId)))
					{// if student ID already exists through binary search and run the following if statement
						//System.out.println("ID Already Saved");
						promptLbl.setVisible(true);
						promptLbl.setText("Student ID Already Exists");// tell user that student already exists 
						editSaveBtn.setEnabled(false);// dont allow user to save student
						studentIdInput.setText(null);// clear student ID input
					} 
					else
					{// else, if check is true, student ID does not exist through binary search and may save the student, run the following else statement
						//System.out.println("ID passes test");
						promptLbl.setVisible(true);
						promptLbl.setText("Valid ID");
						studentIdInput.setEditable(false);
						checkIdAddBtn.setEnabled(false);
						nameInput.setEditable(false);
						gradeInput.setEnabled(false);
						checkIdEditBtn.setEnabled(false);
						editSaveBtn.setEnabled(true);// allow user to save student
					}
				}
				else 
				{// else, if user's input in name and student ID text field are empty or student ID is not a number, run the following else statement
					//System.out.println("ID Invalid");
					promptLbl.setVisible(true);
					promptLbl.setText("Invalid ID");
					editSaveBtn.setEnabled(false);// dont allow usert to save student
					studentIdInput.setText(null);// clear student ID input
					nameInput.setText(null);// clear name input
				}
			}
		});
		
		// Edit Save Button; allows user to save any changes made to a student
		editSaveBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//String newStudentId = checkStudentIdInput.getText();// get student's ID from input and store it in a variable
				studentIdInput.setEnabled(true);
				editSaveBtn.setVisible(true);
				studentIdInput.setEnabled(true);
				String newName = nameInput.getText();// get student's altered name and save it into a variable
				String newStudentId =(String)studentIdInput.getText(); // get new student ID and save it into a variable
				String newGrade = (String)gradeInput.getSelectedItem(); // get new grade and save it into a variable
				(students[countNum]).setName(newName);// set students name to new name
				(students[countNum]).setStudentId(Integer.parseInt(newStudentId)); // set student's ID to new ID
				(students[countNum]).setGrade(Integer.parseInt(newGrade)); // set student's grade to new grade
				countNum++;// increment countNum
				countVar--;// decrement countVar
				insertionSort();// insertion sort everything once user alters student's info
				countVar++;// increment countVar once sorted
				menu(); // call menu method
			}
		}); // edit save btn

		// Delete Button; allows user to enter a student to delete from database
		deleteBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects delete button, run the following code
			{
				titleText.setText("Enter Student ID to Delete");
				addBtn.setVisible(false);
				editBtn.setVisible(false);
				deleteBtn.setVisible(false);
				selectDeleteBtn.setVisible(true);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				checkStudentIdInput.setVisible(true);	
			}
		}); // delete btn

		// Select Delete Btn; if student ID exists, allow user to delete student from the program
		selectDeleteBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) // if user selects confirmation delete button, run the following code
			{
				selectDeleteBtn.setVisible(true);
				quitBtn.setVisible(false);
				cancelBtn.setVisible(true);
				String newStudentId = checkStudentIdInput.getText();// get student's id and store it in a variable
				if (newStudentId.matches("^[0-9]+$"))
				{// if student ID is numeric, run the following if statement
					if(!checkStudent(Integer.parseInt(newStudentId)))
					{// if student ID exists, run the following if statement
						int j = binarySearch(Integer.parseInt(newStudentId));// call binary search of student id and store it in a variable
						for (int i = j ; i < countVar; i++) 
						{
							students[i] = students[i + 1]; // add 1 to student's position
						}
						countVar--; // decrement countVar	
						menu(); // call menu method
					}
					else 
					{// else if binary search fails, student ID does not exist and run the following if statement
						//System.out.println("Cannot find Student Id");
						promptLbl.setVisible(true);
						selectDeleteBtn.setVisible(true);
						promptLbl.setText("Student Does Not Exist");// tell user that student does not exist with that ID
						checkStudentIdInput.setText(null);// clear student Id input
					}
				} 
				else 
				{
					promptLbl.setVisible(true);
					promptLbl.setText("Invalid ID");
					//checkStudentIdInput.setText(null);// clear student ID input
				}
				countVar--;// decrement countVar
				insertionSort();// insertion sort everything once user alters student's info
				countVar++;// increment countVar
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
			public void actionPerformed( ActionEvent arg0) // if user selects the quit button, run the following code
			{
				write();        // calls to write method
				System.exit(0); // exit program
			}
		}); // quit btn

	} // GUI method

	// Menu Method; this method displays the menu interface whenever user starts the game, saves a student, or chooses to cancel
	public static void menu() 
	{
		addBtn.setVisible(true);
		editBtn.setVisible(true);
		deleteBtn.setVisible(true);
		cancelBtn.setVisible(false);
		titleText.setFont(new Font("Poppins", Font.BOLD, 16));
		titleText.setText("Student Data Base");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setBounds(20, 31, 400, 16);
		quitBtn.setBounds(150, 320, 117, 29);
		selectDeleteBtn.setVisible(false);
		//selectViewBtn.setVisible(false);
		saveBtn.setVisible(false);
		nameLbl.setVisible(false);
		nameInput.setVisible(false);
		studentIdLbl.setVisible(false);
		studentIdInput.setVisible(false);
		gradeLbl.setVisible(false);
		gradeInput.setVisible(false);
		editSaveBtn.setVisible(false);
		selectEditBtn.setVisible(false);
		nameInput.setEditable(true);
		nameInput.setText("");
		studentIdInput.setText("");
		nameInput.setEnabled(true);
		studentIdInput.setEnabled(true);
		gradeInput.setEnabled(true);
		quitBtn.setVisible(true);
		checkIdAddBtn.setVisible(false);
		promptLbl.setVisible(false);
		checkStudentIdInput.setVisible(false);
		checkIdEditBtn.setVisible(false);
	} // menu method

	// Character selected method; when user presses add button, run the following method
	public void studentSelected() 
	{
		titleText.setText("Student Info");
		saveBtn.setVisible(true);
		saveBtn.setEnabled(false);
		addBtn.setVisible(false);
		editBtn.setVisible(false);
		deleteBtn.setVisible(false);
		nameLbl.setVisible(true);
		nameInput.setVisible(true);
		studentIdLbl.setVisible(true);
		studentIdInput.setVisible(true);
		gradeLbl.setVisible(true);
		gradeInput.setVisible(true);
		quitBtn.setVisible(false);
		cancelBtn.setVisible(true);
		checkIdAddBtn.setVisible(true);
		promptLbl.setVisible(false);
		studentIdInput.setEditable(true);
		checkIdAddBtn.setEnabled(true);
		checkStudentIdInput.setVisible(false);
		checkIdEditBtn.setVisible(false);
	} // student selected method

	/*********** ASSIGNMENT CONCEPTS ************/

	// Records method
	public void records(String line) 
	{
		String[] storage = line.split(";"); // split data
		if(storage.length<=1) 
		{
			return;
		}
		students[countVar] = new Student(storage[0], Integer.parseInt(storage[1]),Integer.parseInt(storage[2])); // display saved data for student
		countVar++; // increment countVar
	} 

	// Read File Method
	public void read()
	{// reads the file
		String line;// to read line by line
		BufferedReader input;
		try 
		{
			input = new BufferedReader(new FileReader("CharactersCreatedListSortAndSearch.txt")); // input reads file
			line = input.readLine(); // reads first line from file
			while (line != null) 
			{ // while the last line read is not empty, run the following while loop
				records(line);// calls records method
				line = input.readLine();// reads & stores line
			}                  
			input.close();// close reader
		} 
		catch (Exception e)// if above code fails, catch the exception
		{
			e.printStackTrace();
			// System.out.println("There's an error!"); // print error message
		}
	} // read method

	// Write File Method
	public void write() 
	{
		try 
		{
			PrintWriter save; // data to write in file using PrintWriter
			save = new PrintWriter(new FileWriter("CharactersCreatedListSortAndSearch.txt")); // text file inputs to notepad
			for (int j = 0; j < countVar; j++) 
			{
				save.print(students[j].getName());// get student's name
				save.print(";");// split data
				save.print(students[j].getStudentId());// get student's ID
				save.print(";");// split data
				save.print(students[j].getGrade());// get student's grade
				save.println("");
			}
			save.close();// close writer
		} 
		catch (Exception e) // catch the exception if above code fails
		{
			System.out.println("Error!"); // print error message
		}
	} // write method

	/*********** ASSIGNMENT CONCEPTS SORT AND SEARCH ************/

	// Sort Inserted Method; inserts the given student into the correct position in an already sorted students list. Ensures list remains sorted
	public static void sortInserted(Student student) 
	{
		students[countVar] = student;// store student passed in method at index of countVar in stored students array 
		insertionSort();// call insertionSort method; sort students based on student ID
	}

	// Insertion Sort Method; sorts the students list by id, in ascending order
	public static void insertionSort() 
	{
		int n = countVar;// store countVar in a variable
		for (int i = 0; i < n+1; i++) 
		{
			//System.out.println(i);
			Student student = students[i];// get the student at the given index
			int key = student.getStudentId();// store student's id in variable
			int j = i - 1;// calculate the value of one index before the current index and store it in a variable

			// moves elements of students array which are greater than the key, to one position ahead of their current position
			while (j >= 0 && students[j].getStudentId() > key) 
			{
				students[j + 1] = students[j];// add 1 to the position of the student
				j = j - 1;// decrement j by 1
			}
			students[j + 1] = student;// put in the student object at the current index at the correct position
		}
	} // sort method

	// Binary Search Method; searchs the student list. This returns the index of the student with the given id if found, else it returns -1
	public static int binarySearch(int studentId) 
	{
		int l = 0;// the start point to search from in the array
		int r = countVar - 1;// the end point uptil which to search in the array
		while (l <= r) 
		{// while the starting index is less than or equal to the ending index
			int m = l + ((r - l) / 2);// calculate middle index
			if (students[m].getStudentId() == studentId) 
			{// if the student at middle index is the right student, return the middle index
				return m;
			}
			if (students[m].getStudentId() < studentId) 
			{// if the student at the middle index has a student id less than the required student id, then it can only be present in left subarray
				l = m + 1;
			} 
			else 
			{// else, if the student at the middle index has a student id more than the required student id, then it can only be present in right subarray
				r = m - 1;
			}
		}
		return -1;// return -1 if element is not found 
	} // binary search method

	// Check Student Method; checks if student ID exists or not
	public static boolean checkStudent(int studentId) 
	{
		if (countVar !=0) 
		{// while countVar is not 0 (not empty), run the following if statement
			if (binarySearch(studentId) == -1) 
			{// if a student with the id does not already exists, return true
				return true;
			}
		} 
		else
		{// else if countVar is 0, still return true
			return true;
		}
		return false;// else, return false, meaning student does exist in database
	}
} // GUI class