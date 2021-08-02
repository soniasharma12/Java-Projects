/*	Sonia Sharma
	ICS3U
	Uno with a Twist 
	April 7th, 2021
	Description: This program is designed for the user to play Uno with a Twist against the computer! Read the Requirements Document on how to play! Have fun :)
*/

import java.util.Scanner;// Scanner class

public class UnoTwistGame 
{
  public static UnoTwistCards[] userHand = new UnoTwistCards[7];// declare and instantiate an array of UnoTwistCards object (index 0-6)
  public static UnoTwistCards[] compHand = new UnoTwistCards[7];// declare and instantiate an array of UnoTwistCards object (index 0-6) 
  public static void main(String[] args) 
  {// main method
    Scanner keyb = new Scanner(System.in); //create link to input stream
    
    int win; // if user won or lost the game(1=win, 0=neutral, -1=lost)
   	UnoTwistCards topCard; // top card being played
    int cardChoice;// index of player's card choice to play the top card
    String suitChoice, suitChosen;// wild cards; suitChoice = user input, suitChosen = updated suit
    String[] suits = {"Diamonds", "Clovers", "Hearts", "Spades"};// array for card suits
    boolean userTurn = true;

    while(true)
    {
      win = 0;// neutral score
      topCard = new UnoTwistCards(); // instantiate UnoTwistCards object
      suitChosen = topCard.suit; // update the current suit to the suit of the topCard
      
      System.out.println(" Welcome to Uno with a Twist!!! Initializing game...."); 
      draw(7, userHand); // add 7 randomly generated cards from the deck to the user's hand 
      draw(7, compHand); // add 7 randomly generated cards from the deck to the computer's hand 
     
      while(win == 0)
      {// win is neutral
        cardChoice = 0;
        System.out.println("\n The top card is: " + topCard.getCard()); // display top card
        
// User's Turn        
        if(userTurn)
        {// execute the following as long as it's the user's turn
          System.out.println(" Your turn! ");
          // User's deck displayed
          for (int i = 0; i < userHand.length; i = i + 1)
          {// as long as i is less than the size of user's hand, increment and print the option number along with the user's card at that index within their hand
            System.out.print(String.valueOf(i+1) + ". " + ((UnoTwistCards)userHand[i]). getCard() + "\n"); 
          }//for loop
          System.out.println(String.valueOf(userHand.length + 1)+". " + "Draw card " + "\n" + String.valueOf(userHand.length + 2) + ". "+ "Quit"); // output draw option(+1 higher than the last card in user's hand) and quit option(+2 higher than the last card in user's hand)
          System.out.print("\n Please input the number of your choice (1/2/3/...) : ");
          cardChoice = (keyb.nextInt()-1); // get user's card choice
          
          if (cardChoice == userHand.length)
          {// if user's Card choice is equal to the size of user's hand, they chose "Draw" option
            System.out.println(" You can't play! Drawing card....");
            userHand = draw(1, userHand); // draw 1 random card from deck and add it to the user's hand
            userTurn = false; // computer's turn
          }// if
          else if (cardChoice == userHand.length+1)
          {// else if, user's card choice is equal to the size of user's hand + 1, they chose quit option 
            break; // leave loop
          }// else if          
          else if(((UnoTwistCards)userHand[cardChoice]).ableToPlay(topCard, suitChosen))
          {// else if, user's card choice is able to play the top card, execute the following
            topCard = (UnoTwistCards)(userHand[cardChoice]); //update top card as the user's cardChoice from their hand
            userHand = remove(userHand,cardChoice); // remove card choice which user played the top card on 
            suitChosen = topCard.suit; // update suit as the top card which is the cardChoice user chose
            userTurn = false; // computer's turn once user has placed the card if not an action or wild card
            
            if(topCard.value >=10)
            {// if the user's card choice is either an action or wild card from their hand
              userTurn = true; // user still gets to play
              switch(topCard.value)
              {
                case 12: // if user chose 2+ action card from their hand
                System.out.println(" Drawing 2 cards to computer's hand...");
                compHand = draw(2, compHand); //draw 2 random cards from deck and add them to the computer's hand 
                break;
                  
                case 13: // if user chose a wild card from their hand
                case 14: // or if they chose a 6+ wild card from their hand
                System.out.print("\n Enter the suit you'd like (Diamonds/Hearts/Clovers/Spades) : ");
                suitChoice = keyb.next(); // get user's suit choice
                for(int j = 0; j<4; j++)
                {// for loop to iterate till 4, update counter variable(j) and execute the following
                  if(suitChoice.equalsIgnoreCase(suits[j]))
                  {// if user's suit choice is equal to the index value in suits array, update the suit of the top card as that index value
                    suitChosen = suits[j];
                  }// if 
                }// for loop 
                System.out.println(" You chose "+ suitChosen);// output updated suit
                  
                if(topCard.value == 14)
                {// if user chose 6+ Wild Card from their hand
                  System.out.println(" Drawing 6 cards to computer's hand...");
                  compHand = draw(6, compHand);// draw 6 random generated cards from deck and add it to computer's hand                 
                }// if  
                break;  
                  
              }// switch 
            }// if                        
          }// else if
          
          else
          {// if user doesn't enter a valid option, skip user's turn  
            System.out.println(" Invalid choice. Your turn skipped. ");
            userTurn=false;// skip user's turn
          }// else
          
        }// if userTurn
        
// Computer's Turn         
        else 
        {// skip the code above and execute the following if it's the computer's turn
          
          // Comment /**/ if you want to display computer's hand for debugging 
          /*
          System.out.println("\n Computer's Hand: ");
          for (int i = 0; i < compHand.length; i = i + 1)
          {
            System.out.print(String.valueOf(i+1) + ". " + ((UnoTwistCards)compHand[i]). getCard() + "\n");
          }//for loop
          System.out.println(String.valueOf(compHand.length + 1)+". " + "Draw card " + "\n");
          /*/
          System.out.println(" Computer's Turn! They have " + String.valueOf(compHand.length) + " cards left!"); // display size of array(computer's hand) for the user to know the amount of cards computer has left
          
          // finding a card to place
          for(cardChoice = 0; cardChoice<compHand.length; cardChoice = cardChoice + 1)
          {// as long as computer's cardChoice is less than the size of computer's hand, increment card choice and execute the following until cardChoice can play
            if ( ((UnoTwistCards)compHand[cardChoice]).ableToPlay(topCard, suitChosen) )
            {//if computer's card choice is able to play the top card, leave the loop
              break; // leave loop
            }//if
          }// for loop
          
          if (cardChoice == compHand.length)
          {// if computer's card choice cannot play the topcard; card choice is equal to the size of computer's hand
            System.out.println(" Computer can't play! Drawing card....");
            compHand = draw(1, compHand); // draw 1 random card to computer's hand
            userTurn = true; // user gets to play
          }// if
          else
          {// else if, the computer's card choice can play the top card
            topCard = (UnoTwistCards)(compHand[cardChoice]); // update top card as the computer's cardChoice from their hand
            compHand = remove(compHand,cardChoice); // remove card choice which computer played the top card on 
            suitChosen = topCard.suit; // update suit as the top card which is the cardChoice computer chose
            System.out.println(" Computer chooses "+ topCard.getCard()+ " !"); // display card which computer chose
            userTurn = true; // user gets to play after computer places their card
            
            if(topCard.value >=10)
            {// if the computer's card choice is either an action or wild card from their hand
              userTurn = false; // skip user's turn if the computer plays the following 
              switch(topCard.value)
              {
                case 12:// if computer chose 2+ action card from their hand
                  System.out.println(" Drawing 2 cards for you...");
                  userHand = draw(2, userHand); // draw 2 random cards from deck and add them to the user's hand
                  break;
                case 13: // if user chose a wild card from their hand
                case 14: // or if they chose a 6+ wild card from their hand
                 while(suitChosen =="N/A")
                 {// pick a random suit that's not N/A
                   suitChosen = new UnoTwistCards().suit; // instantiate UnoTwistCards object 
                 }// while 
                 System.out.println(" New suit is "+ suitChosen); // display suit computer chose(randomly generated suit)
                 if(topCard.value ==14) // if computer chose 6+ Wild Card from their hand
                 {
                   System.out.println(" Drawing 6 cards for you...");
                   userHand = draw(6, userHand); // draw 6 random cards from deck and add them to the user's hand
                 }// if
                 break;                   
              }// switch
              
            }// if            
          }// else
          
        }// else compTurn
        
// Concluding Results; if player has one card left
          if (userHand.length==1)
          {// if there's one card left in user's hand, user won
            win = 1;
            System.out.println("\n Uno! You win!! Yay :)");
          }// if
          else if(compHand.length==1)
          {// else if there's one card left in computer's hand, user lost
            win = -1;
            System.out.println("\n Computer calls Uno! You lose. Better luck next time :(");
          }// else if  
        
      }// for loop
      
      break;// leave loop; exit the game
    }// while loop

    System.out.println("\n Goodbye! ");// output statement once program ends; game ends or user quits  
  }// main method
  
// Methods; add(), draw(), remove() 
  
  public static UnoTwistCards[] add(UnoTwistCards[] hand, UnoTwistCards newCard)
  {// adds a newCard from UnoTwistCards to the indicated hand
    boolean isPopulated = false; // boolean that tracks whether the array is empty or contains cards 
    for(int t = 0; t < hand.length; t++)
    {
        if(hand[t] != null)
        {// if there's no-null value, then isPopulated is true and the array contains cards
          isPopulated = true;  
        }// if
    }// for
    if(isPopulated)
    {// if array contains cards, execute the following
      UnoTwistCards[] newHand = new UnoTwistCards[hand.length + 1]; // player has cards and is adding another to its hand;expands the array
      for(int i = 0; i < newHand.length; i++)
        {// as long as i is less than the size of the player's updated hand, execute the following
          if( i < hand.length)
          {// if i is less than the size of the original hand, then put it into the updated hand
              newHand[i] = hand[i];
          }// if
          else
          {// insert the new card that's being adding
             newHand[i] = newCard;
          }// else
      }// for
      hand = newHand; // set the original hand to equal the updated hand
    }// if
    else
    {// if player doesn't have a hand containing cards, then create a new hand
      for(int j = 0; j < hand.length; j= j + 1)
      {//as long as j is less than the size of the player's original hand, increment j and execute the following
        hand[j] = new UnoTwistCards(); // set each index to a new card
      }// for
    }// else
    return hand; // returns player's hand
  }// add method
  
  
  public static UnoTwistCards[] draw(int numCards, UnoTwistCards[] hand)
  {// draw lets the player draw a specified amount of cards at the beginning of the game(7 cards each), if they can't play the top card(1 card), or the other player plays an action card(2+, 6+ Wild Card)
    for (int j = 0; j< numCards; j = j + 1)
    {// as long as j is less than the number cards wanted to be drawn, increment j and execute the following
      hand = add(hand, new UnoTwistCards()); // calls the add method to add cards to the player's hand
    }// for loop  
    return hand; // returns player's hand
  }// draw method 

  
  public static UnoTwistCards[] remove(UnoTwistCards[] hand, int cardChoice)
  {// remove removes the card choice player chooses to play from their hand 
    if(hand == null||cardChoice < 0)
    {// if player's hand is null or index is invalid
      return hand; // return player's hand
    }// if
    UnoTwistCards[] newHand = new UnoTwistCards[hand.length - 1];// instantiate UnoTwistCards object; creates a new array with one decremented spot
    for (int i = 0, j = 0; i< hand.length; i=i+1)
    {// as long as i is less than the size of the player's original hand, increment i and execute the following
      if(i == cardChoice)
      {// if i is the index of the card wanted to be removed, then don't execute the code outside of the if statement
        continue;
      }// if
      newHand[j++]=hand[i];// insert the cards from our original hand into the updated hand
      					// j++ is there so that it skips the index to remove a card and so i isn't incremented
    }// for loop
    hand = newHand; // set the original hand to equal the updated hand 
    return hand; // return the player's hand
  }// remove method 
     
  
}// UnoTwistGame class


