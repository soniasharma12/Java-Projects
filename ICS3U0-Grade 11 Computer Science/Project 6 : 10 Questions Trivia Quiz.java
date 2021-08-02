/*	Sonia Sharma
	ICS3U
	Arrays Assignment 
	March 21th, 2021
	Description: This program is designed to ask the user 10 one word/multiple choice trivia word questions and the user has to enter their answer or right letter. 
    			 The user will be awarded points for each question they get right(each question is worth different). 
                 At the end of the game, the user will recieve feedback for their performance & their final score. 
*/

import java.util.Scanner; // import Scanner class

public class TriviaQuiz10 
{
  public static void main(String[] args) 
  {
    Scanner keyb = new Scanner(System.in); //create link to input stream
    
    // Welcome Statement
    System.out.println(" Welcome to Sonia's Trivia Quiz! I'll be asking you a series of 10 questions and you have to type in the correct answer.");
    System.out.println(" If the question is multiple choice, type the letter corresponding to the answer(A/B/C/D). \n Let's get started!");
    
    
    // Declare variables     
    String [] myQuestions = new String[10];// declare and instantiate array for size 10; index 0-9
    String [] userInput = new String[10];// declare and instantiate array for size 10; index 0-9
    String [] answersRight = {"K", "Venus", "Horse", "Skin", "Asia", "Chickpeas", "Atlantis", "Alaska", "Giza", "Elon Musk"};// correct answers for the questions; declare and instantiate array using an array literal string type
    int [] pointValue = {1, 2, 1, 5, 1, 2, 1, 5, 10, 2};// points worth for each question; declare and instantiate array using an array literal integer type
    
    int score = 0;// variable to store user's score
    
    
 	// Insert values for myQuestions array variable for each index value
    myQuestions[0] = "Chemistry; What is the symbol for potassium?";// Question 1
    myQuestions[1] = "Space; Which planet is the hottest in the solar system?";// Question 2
    myQuestions[2] = "Auto; Which animal can be seen on the Porsche logo?";// Question 3
    myQuestions[3] = "Biology; What is your body’s largest organ?";// Question 4
    myQuestions[4] = "Geography; Which continent is the largest?";// Question 5
    myQuestions[5] = "Food; What’s the primary ingredient in hummus?";// Question 6
    myQuestions[6] = "DC Comics; Aquaman is from which city under the sea?";// Question 7
    myQuestions[7] = "Geography; Which American state is the largest (by area)?";// Question 8
    myQuestions[8] = "Geography; Which of the Seven Wonders is located in Egypt? The Pyramids of...";// Question 9
    myQuestions[9] = "Entrepreneurship; Who is the richest person in the world as of 2021(first and last name)?";// Question 10
     
    
    // For loop for user input
    for(int i = 0; i<10; i++)
    {// for loop to iterate till 10, update counter variable(i), display the question number, point value for each question, and get the user's response to the questions
      System.out.println("\n Question "+(i + 1)+": "+myQuestions[i] +"("+pointValue[i]+")");// display the question number & the amount of points the question is worth
      System.out.print(" Type your answer: ");
      userInput[i] = keyb.nextLine();// ge user's input 
    }// for loop-1
    
    
    // For Loop for user's feedback
    for(int j = 0; j<10; j++)
    {// for loop to iterate till 10, update counter variable(j), display the question number 
      System.out.println("\n Question "+(j+1)); // display question
      System.out.print(" Your response: "+userInput[j]);// display the user's response
      
      if(userInput[j].equalsIgnoreCase(answersRight[j]))
      {// if the user's input is equal to the index value in the answers array variable at the index value of the question, print the following statement
        System.out.print(" Right"+"\n");
        score += pointValue[j];// update score
      }// if statement
      else 
      {// else, if the user's input does not equal to the index value in the answersRight array variable, print the following statement
        System.out.print(" Wrong! The correct answer was "+answersRight[j]+"\n");
      }// else statement
      
    }// for loop-2
    
    
    // Condition for user's final score
    System.out.println("\n Final Score: "+score);// print user's final score
    
    if(score==30)
    {// if the user's final score is equal to 30 points, print the following statement
      System.out.println(" Awesome, you're a genius!");
    }// if statement
    else if (score<30 && score>=21)
    {// else if the user's score is less than 30 points and greater or equal to 21 points, print the following statement
      System.out.println(" Good job. Make sure to practice your trivia but, you have the potential to be a teacher one day!");
    }// else if statement
    else
    {// else, if the user's score is less than 21 points, print the following statement
      System.out.println(" Hmm needs improvement!");
    }// else
        
    
  }// main method
}// TriviaQuiz10 class

