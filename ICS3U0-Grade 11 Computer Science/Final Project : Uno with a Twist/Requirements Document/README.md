# Requirement Document of *Uno with a Twist*

## *Objective:*
- **Uno with a Twist** is a card game in which players attempt to discard all their cards from their hand. Each player starts the round with 7 random cards in their hands. The first person that has 1 remaining card is the winner; if the user has 1 card left, they win the game, else the computer wins the game.

- More cards decreases your chances of winning 

- During a player’s turn, they must attempt to discard a card by matching it to the top card, either by playing a card with the same suit, same number, or playing a wild card

## *Rules:*
The user will be prompted to enter a number corresponding to their card in their hand. 
> 1. [Spades 6]
> 2. [Clovers 2]

>   ....

> 7. [Diamonds Skip]
> 8. Draw Card
> 9. Quit

> Please input the number of your choice(1/2/….7/8/9):

### Deck & Play Rule:
- The deck of cards consists of 108 cards: 25 containing a suit(spade,clover,diamond,heart) and 8 wild cards. Once again, the user has to place their card according to the top card; has to be the number, suit, or a wild card in order to continue playing.
- The cards that have a suit each have a corresponding value of 0-9 or an action card which can either skip the next player’s turn, reverse the order of turns, or force the next player to draw two cards. 
- The first wild card only allows the player to declare which suit the next card should be. The second wild card allows the player to choose the next suit but also forces the next player to draw 6 cards.
- If the player cannot play on the top card, they have to draw a card from the deck (therefore increasing the amount of cards they have in their hand) or they can choose to quit the program.
- If the user draws a card that is not possible to play, (e.g if the top card is [Heart 8] but the user plays [Diamond 7]), the user’s turn will automatically skip

## *Number of Players:*
- Since this game isn’t being played in person, 1 player is required to face the computer, therefore 2 players in total.
