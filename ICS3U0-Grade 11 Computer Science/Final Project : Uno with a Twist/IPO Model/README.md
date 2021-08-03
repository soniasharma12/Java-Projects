# IPO Model of *Uno with a Twist*
Name: Sonia Sharma

Date: March 31st, 2021

Course: ICS3U0

| Task | Input | Process | Output |
|------|-------|---------|--------|
| 1) menu displaying user’s hand| | Generate any of the following random cards; a random suit (spades, clovers, diamonds, hearts) and a random card number between 0-9, and/or generates a random action card (reverse/skip/2+), and/or generates a wild card or 6+ card | see **Note 1** |
| 2) get player’s card choice from their hand| cardChoice | |“ Please input the number of your choice: ” |
| 3) player’s card choice in their hand has a suit and/or number on their card that matches the top card| | Check if the user's card is playable. Play card and decrement card played from player’s hand based on their card choice.| see **Note 2** <br/> see **Note 1**
| 4) user’s card choice in their hand is a wild card or a +6 wild card | | Play card and make the user choose any suit they’d like(spades, clovers, diamonds, hearts) but if the user chooses 6+ wild card, repeat the same process and add 6 cards to the next player’s hand. <br/> Decrement card played from user’s hand based on the card choice.| “Enter the suit you’d like: ” <br/> “Drawing 6 cards ” <br/> see **Note 2** <br/> see **Note 1**
| 5) player’s card choice in their hand is the same suit and is an action card; reverse, skip, or 2+ card| | Check if the user's card is playable. <br/>If player’s card choice is reversed, switch the order of turns players are playing in. <br/>If player’s card choice is skip, skip the next player’s turn.<br/>If player’s card choice is 2+ card, add 2 cards to the next player’s hand.<br/>Decrement card played from player’s hand based on the card choice.| see **Note 2** <br/> see **Note 1**
| 6) player chooses to draw a  card from the deck| | If player cannot play on the top card, draw an additional card from the deck and increment the player’s hand by 1.| “ I’ve got nothing! Drawing Cards…” <br/> see **Note 2** <br/> see **Note 1**
| 7) user plays their choice of card from their hand that isn't playable| | If a player's card is not possible to play(suit and/or number doesn't match the top card) and is not a wild card or 6+ wild card, skip their turn and let the computer play.| "Invalid, skip turn!" <br/> see **Note 2** <br/> see **Note 1**
| 8) computer plays their choice of card from their hand that is a wild card or 6+ wild card| | If the computer has no other card in its hand matching the top card, play computer's card choice and output any random suit. <br/> Decrement card played from computer's hand based on the card choice.| see **Note 1** <br/> see **Note 2**
| 9)  computer has more than 1 option to play from their hand| | Play computer’s card choice and output a random card that is playable from their hand (suit or number matches to the top card, wild card or 6+ wild card, or action card that matches the suit of the top card). <br/> Decrement card played from computer’s hand based on the card choice.| see **Note 1** <br/> see **Note 2**
| 10) player has one card left| | | “Uno! You ”(win or lose)
| 11) user quits the program| | exit program| "Goodbye"

## General Notes:
- **Player** refers to both computer and user
- **Top card** refers to the top of the card of the card deck

## Note 1:
“ The top card is: ” (cardChoice) <br/>


“Your turn! 

> 1. [” (randomly generate card) “]

> 2. [” (randomly generate card) “]

> 3. [” (randomly generate card) “]

> 4. [” (randomly generate card) “]

> 5. [” (randomly generate card) “]

> 6. [” (randomly generate card) “]

> 7. [” (randomly generate card) “]

> 8. Draw Card

> 9. Quit Program”


- Display randomly generate card (suit & number, suit, and action, or wild card)
- Display cards in hand depending on the number of cards incremented/ decremented and update menu options
- Display top card depending on the last player’s play but at the start of the game, generate a random card from the deck 

## Note 2:
“The top card is [ ” (cardChoice) “ ]”

“Computer’s turn! They have” (computer number of cards) “ cards left”

“ The computer chooses [ ” (computer’s cardChoice) “]”


- Display top card depending on the last player’s play
- Update number of cards computer has left and displayed it 
- Display card computer wants to play
