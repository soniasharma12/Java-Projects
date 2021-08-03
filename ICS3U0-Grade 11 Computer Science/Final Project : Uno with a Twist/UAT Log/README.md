# UAT Log of *Uno with a Twist*

|Test Case|Inputs|Outputs|Results <br/> (outputs & pass/fail with explanation)|
|---------|------|-------|----------------------------------------------------|
| 1) At the beginning of the game, check if the ***user’s*** hand randomly generates cards each time the program is executed (different hand on each execution), if the top card is also randomly generated each time, and takes the user’s input|cardChoice|“ Welcome to Uno with a Twist! Initializing game….” <br/> see **Note 1** <br/>“ Please input the number of your choice: ”|  “Welcome to Uno with a Twist!!! Initializing game.... <br/>The top card is: [Hearts 7] <br/> Your turn! <br/> 1. [Hearts 2]<br/>2. [Spades 0]<br/>3. [Clovers 2]<br/>4. [Clovers 3]<br/>5. [Diamonds 3]<br/>6. [Hearts 0]<br/>7. [Clovers 0]<br/>8. Draw card<br/>9. Quit <br/> Please input the number of your choice (1/2/3/...) : ***1*** ” <br/><br/> **PASS**|
| 2) Check if the ***player's*** card choice from their hand plays, which matches the suit and/or the number on their card as the top card, and updates the top card as their choice| cardChoice| see **Note 2** <br/> see **Note 1**| "The top card is: [Spades 2] <br/> Your turn! <br/>1. [Clovers 6]<br/>2. [Hearts 2]<br/>3. [Clovers 7]<br/>4. ***[Spades 4]***<br/>5. [Wild]<br/>6. [Diamonds 3]<br/>7. [Hearts 6]<br/>8. Draw card<br/>9. Quit <br/>Please input the number of your choice (1/2/3/...) : ***4*** <br/>The top card is: ***[Spades 4]***<br/>Computer's Turn! They have 7 cards left!<br/>Computer chooses ***[Spades 6]*** ! <br/><br/> **PASS**
| 3) Check if ***user’s*** card choice from their hand plays, which is a wild card or a 6+ wild card, and asks the user to pick a suit, adds 6 cards to the next player’s hand from the deck (for the 6+ wild card), and updates the top card as their choice| cardChoice <br/> suitChoice|“Enter the suit you’d like:” (suitChoice) <br/>“ You chose ” (suitChoice)<br/>“Drawing 6+ cards” <br/> see **Note 2** <br/>see **Note 1**|  Enter the suit you'd like (Diamonds/Hearts/Clovers/Spades) : ***Spades***<br/> You chose ***Spades***<br/>Drawing 6 cards to computer's hand...<br/>The top card is: ***[Wild 6+]*** <br/>Your turn! <br/><br/> **PASS**
| 4) Check if the ***player’s*** card choice from their hand  plays, which is the skip action card, skips the next player’s turn, and updates the top card as their choice| cardChoice| see **Note 2**<br/> see **Note 1**| The top card is: ***[Hearts 1]***<br/>Your turn!<br/>1. [Diamonds 8]<br/>2. [Hearts Skip]<br/>3. [Diamonds 7]<br/>4. [Hearts 4]<br/>5. Draw card <br/>6. Quit<br/>Please input the number of your choice (1/2/3/...) : ***2***<br/>The top card is: ***[Hearts Skip]***<br/>Your turn!<br/><br/> **PASS**
| 5) Check if the ***player's*** card choice from their hand plays, which is the reverse action card, reverses the direction of play, and updates the top card as their choice| cardChoice| see **Note 2**<br/> see **Note 1**|The top card is: ***[Clovers 1]***<br/>Your turn!<br/>1. [Clovers 4]<br/>2. [Clovers 5]<br/>3. [Spades 4]<br/>4. [Hearts 4]<br/>5. ***[Clovers Reverse]***<br/>6. [Spades 1]<br/>7. [Clovers 9]<br/>8. Draw card<br/>9. Quit<br/>Please input the number of your choice (1/2/3/...) : ***5***<br/>The top card is: ***[Clovers Reverse]***<br/>Your turn!<br/><br/>**PASS** 
| 6) Check if ***player’s*** card choice from their hand plays, which is the 2+ action card, adds 2 cards to the next player’s hand from the deck, and updates the top card as their choice| cardChoice |“ Drawing 2 cards to computer’s hand …”<br/>see **Note 2**<br/>see **Note 1**|The top card is: ***[Hearts 4]***<br/>Your turn!<br/>1. [Spades 4]<br/>2. [Clovers 6]<br/>3. [Spades 1]<br/>4. [Clovers 8]<br/>5. [Hearts 7]<br/>6. ***[Hearts 2+]***<br/>7. [Hearts Reverse]<br/>8. Draw card <br/>9. Quit<br/>Please input the number of your choice (1/2/3/...) : ***6***<br/>Drawing 2 cards to computer's hand...<br/>The top card is: ***[Hearts 2+]***<br/>Your turn!<br/><br/>**PASS**

In progress...

## General Notes:
- **Player**
- **Top card**
- **cardChoice**
- **suitChoice**

## Note 1: (Output statement before user's input)

## Note 2: (Output statement after user's input)

## Note 3: (Output statement when computer chooses a wild card)

## Note 4: (Output statement when computer has more than 1 option to play)

## Sample 1: (Sample of computer not being able to play the top card and their hand containing a wild card)

## Sample 2: (Sample of computer having more than one card option to play from their hand)

