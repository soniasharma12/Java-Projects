/*	Sonia Sharma
	ICS3U
	Uno with a Twist
	April 7th, 2021
	Description: This program is designed for the UI and condition of the cards for the game Uno with a Twist! 
*/

// import classes
import java.util.Random; // Random class

public class UnoTwistCards 
{
  public String suit; // suit of the player's card
  public int value; // numerical value and action value of the player's card 
  public Random rand = new Random(); // instantiate Random object
  
  public UnoTwistCards() 
  {// creates a random generated card from deck
    value = rand.nextInt(28); // randomly generate any of the card types from the deck
    
  // Values of card
    if(value > 14)
    {// if the value of the card is greater than 14, decrement the value so that it's within the range of the card types(0-14)
      value = value - 14;
    }// if
    
  // Suits of card
    switch(rand.nextInt(4)) // value 0-12
    {// generate any of the 4 suits for a card within the player's hand
      case 0: // Diamonds suit
        suit = "Diamonds";
        break;
      case 1: // Hearts suit
        suit = "Hearts";
        break; 
      case 2: // Clovers suit
        suit ="Clovers";
        break;
      case 3: // Spades suit
        suit = "Spades";
        break;  
    }// switch
    
  // Wild Cards
    if(value>=13) // value 13 & 14
    {// if the card is a wild or a 6+ wild card, don't set a suit to the card since player has to chose the suit of their choice
      suit = "N/A";
    }// if    
    
  }// UnoTwistCards method
  
  
  public String getCard()
  {// display card visible to the user
    
    // start of the card
    String card = "[";

    if (suit != "N/A") // value 0-12
    {// if the card is not a wild or 6+card, set any of the 4 suits to the card 
       card = card + this.suit + " ";    
    }// if 

  // Action & Wild Cards  
    switch(this.value)
    {// get the numerical value from deck of the card type  
      default: // return the value of card for all types cards (value 0-14)
        card = card + String.valueOf(this.value);
        break;
      case 10: // value 10 is skip action card
        card = card + "Skip";
        break; 
      case 11: // value 11 is reverse action card
        card = card + "Reverse";
        break;
      case 12: // value 12 is 2+ action card
        card = card + "2+";
        break;
      case 13: // value 13 is wild card
        card = card + "Wild";
        break;
      case 14: // value 14 is 6+ wild card
        card = card + "Wild 6+";
        break;
    }// switch
    
    // end card
    card = card + "]";
    return card; // return player's card 
    
  }// getCard method
   

  public boolean ableToPlay(UnoTwistCards v, String s)
  {// ableToPlay checks if player's card can play the top card
    if(this.suit.equals(s) || this.value == v.value || this.suit == "N/A")
    {// if the suit or card value(number or action value) of the player's card choice from their hand is equal to suit or card value of the top card, OR if the player's chooses a a wild or 6+ wild card to play from their hand 
      return true; // player can play 
    }// if
    else
    {// else, if the player's card is not equal to any of the conditions above, player cannot play
      return false; // player cannot play
    }// else
    
  }// ableToPlay method
  
}// UnoTwistCards class

